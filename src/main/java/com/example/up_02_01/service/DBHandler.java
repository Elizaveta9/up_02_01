package com.example.up_02_01.service;


import com.example.up_02_01.entities.Abiturient;
import com.example.up_02_01.entities.Education;
import com.example.up_02_01.entities.Parents;
import com.example.up_02_01.entities.PersonalData;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.sql.*;
import java.time.LocalDate;

public class DBHandler {
    private static DBHandler dbHandler;
    private Connection dbConnection;

    private DBHandler() {
    }

    public static DBHandler getDbHandler() {
        if (dbHandler == null) {
            dbHandler = new DBHandler();
        }
        return dbHandler;
    }

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://localhost/up_02_01";
        String password = "";
        String username = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, username, password);
        return dbConnection;
    }

    public void putPersonalData(PersonalData personalData) {
        String insert = "INSERT INTO up_02_01.personal_data (" +
                "abiturient_surname," +
                "abiturient_name," +
                "abiturient_patronymic," +
                "abiturien_birthday," +
                "birth_place," +
                "pasport_seria," +
                "pasport_number," +
                "who_gave_pasport," +
                "when_pasrort_given," +
                "birth_certificate_number," +
                "birth_certificate_seria," +
                "who_gave_birth_certificate" +
                ")" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ps.setString(1, personalData.getAbiturientSurname());
            ps.setString(2, personalData.getAbiturientName());
            ps.setString(3, personalData.getAbiturientPatronymic());
            ps.setObject(4, personalData.getAbiturientBirthday());
            ps.setString(5, personalData.getBirthPlace());
            ps.setString(6, personalData.getPasportSeria());
            ps.setString(7, personalData.getPasportNumber());
            ps.setString(8, personalData.getWhoGavePasport());
            ps.setObject(9, personalData.getWhenPassportGiven());
            ps.setString(10, personalData.getBirthCertificateNumber());
            ps.setString(11, personalData.getBirthCertificateSeria());
            ps.setString(12, personalData.getWhoGaveBirthCertificate());

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void putParents(Parents parents) {
        String insert = "INSERT INTO up_02_01.parents (" +
                "family_status," +
                "children_amount," +
                "mother_name," +
                "mother_phone," +
                "mother_address," +
                "mother_work," +
                "father_name," +
                "father_work," +
                "father_phone," +
                "father_address" +
                ")" +
                "VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ps.setString(1, parents.getFamily_status());
            ps.setInt(2, parents.getChildren_amount());
            ps.setString(3, parents.getMother_name());
            ps.setString(4, parents.getMother_phone());
            ps.setString(5, parents.getMother_address());
            ps.setString(6, parents.getMother_work());
            ps.setString(7, parents.getFather_name());
            ps.setString(8, parents.getFather_work());
            ps.setString(9, parents.getFather_phone());
            ps.setString(10, parents.getFather_address());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void putEducation(Education education) {
        String insert = "INSERT INTO up_02_01.education (" +
                "education_livel," +
                "attestat_nuber," +
                "grade," +
                "speciality_code," +
                "speciality_name" +
                ")" +
                "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ps.setString(1, education.getEducationLevel());
            ps.setString(2, education.getAttesstatNumber());
            ps.setFloat(3, education.getGrade());
            ps.setString(4, education.getSpecialityCode());
            ps.setString(5, education.getSpecialityName());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void putAbiturient(Abiturient abiturient) {
        String insert = "INSERT INTO up_02_01.abiturients (" +
                "fullname," +
                "birthday," +
                "phone_number," +
                "address" +
                ")" +
                "VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ps.setString(1, abiturient.getFullname());
            ps.setObject(2, abiturient.getBirthday());
            ps.setString(3, abiturient.getPhoneNumber());
            ps.setString(4, abiturient.getAddress());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public TableView setTableData(TableView tableView, String select) {
        tableView.getColumns().clear();
        ResultSet rs;
        ObservableList tableData = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(select);
            rs = ps.executeQuery();

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn column = new TableColumn(rs.getMetaData().getColumnLabel(i+1));
                column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue>() {
                    @Override
                    public ObservableValue call(TableColumn.CellDataFeatures<ObservableList, String> cellDataFeatures) {
                        return new SimpleStringProperty(cellDataFeatures.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(column);
            }

            while (rs.next()) {
                ObservableList row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getObject(i));
                }
                tableData.add(row);
            }

            tableView.setItems(tableData);


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tableView;
    }

    public Abiturient getAbiturient(Long id) {
        ResultSet rs;
        Abiturient abiturient = null;

        String select = "SELECT * FROM up_02_01.abiturients WHERE code = " + id;

        try {
            PreparedStatement ps = getDbConnection().prepareStatement(select);
            rs = ps.executeQuery();

            while (rs.next()) {
                abiturient = new Abiturient(
                        rs.getString("fullname"),
                        rs.getObject("birthday", LocalDate.class),
                        rs.getString("phone_number"),
                        rs.getString("address")
                        );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return abiturient;

    }

    public Education getEducation(Long id) {
        ResultSet rs;
        Education education = null;

        String select = "SELECT * FROM up_02_01.education WHERE abiturient_code = " + id;

        try {
            PreparedStatement ps = getDbConnection().prepareStatement(select);
            rs = ps.executeQuery();

            while (rs.next()) {
                education = new Education(
                        rs.getString("education_livel"),
                        rs.getString("attestat_nuber"),
                        rs.getFloat("grade"),
                        rs.getString("speciality_name"),
                        rs.getString("speciality_code")
                        );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return education;
    }

    public Parents getParents(Long id) {
        ResultSet rs;
        Parents parents = null;

        String select = "SELECT * FROM up_02_01.parents WHERE abiturient_code = " + id;

        try {
            PreparedStatement ps = getDbConnection().prepareStatement(select);
            rs = ps.executeQuery();

            while (rs.next()) {
                parents = new Parents(
                        rs.getString("family_status"),
                        rs.getInt("children_amount"),
                        rs.getString("mother_name"),
                        rs.getString("mother_phone"),
                        rs.getString("mother_work"),
                        rs.getString("mother_address"),
                        rs.getString("father_name"),
                        rs.getString("father_work"),
                        rs.getString("father_phone"),
                        rs.getString("father_address")
                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return parents;
    }

    public PersonalData getPersonalData(Long id) {
        ResultSet rs;
        PersonalData personalData = null;

        String select = "SELECT * FROM up_02_01.personal_data WHERE abiturient_code = " + id;

        try {
            PreparedStatement ps = getDbConnection().prepareStatement(select);
            rs = ps.executeQuery();

            while (rs.next()) {
                personalData = new PersonalData(
                        rs.getString("abiturient_surname"),
                        rs.getString("abiturient_name"),
                        rs.getString("abiturient_patronymic"),
                        rs.getObject("abiturien_birthday", LocalDate.class),
                        rs.getString("birth_place"),
                        rs.getString("pasport_seria"),
                        rs.getString("pasport_number"),
                        rs.getString("who_gave_pasport"),
                        rs.getObject("when_pasrort_given", LocalDate.class),
                        rs.getString("birth_certificate_number"),
                        rs.getString("birth_certificate_number"),
                        rs.getString("who_gave_birth_certificate")
                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personalData;
    }

    public void updateAbiturient(String update) {
        PreparedStatement ps = null;
        try {
            ps = getDbConnection().prepareStatement(update);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
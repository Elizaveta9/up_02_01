package com.example.up_02_01.controllers;

import com.example.up_02_01.entities.Abiturient;
import com.example.up_02_01.entities.Education;
import com.example.up_02_01.entities.Parents;
import com.example.up_02_01.entities.PersonalData;
import com.example.up_02_01.service.DBHandler;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class EditAbiturientController implements NumericFields {

    @FXML
    private AnchorPane abiturientPane;

    @FXML
    private Button saveAbiturientButton;

    @FXML
    private TextField addressTF;

    @FXML
    private TextField atestatNumberTF;

    @FXML
    private TextField birthPlaceTF;

    @FXML
    private TextField birthSertificateNumberTF;

    @FXML
    private TextField birthSertificateSeriaTF;

    @FXML
    private DatePicker birthdayDP;

    @FXML
    private DatePicker birthdayDPPassport;

    @FXML
    private TextField childeAmountTF;

    @FXML
    private ComboBox<String> educationLevelCB;

    @FXML
    private AnchorPane educationPane;

    @FXML
    private ComboBox<String> familyStatusCB;

    @FXML
    private TextField fatherAddressTF;

    @FXML
    private TextField fatherNameTF;

    @FXML
    private TextField fatherPhoneTF;

    @FXML
    private TextField fatherWorkTF;

    @FXML
    private TextField fullnameTF;

    @FXML
    private TextField gradeTF;

    @FXML
    private TextField motherAddressTF;

    @FXML
    private TextField motherNameTF;

    @FXML
    private TextField motherPhoneTF;

    @FXML
    private TextField motherWorkTF;

    @FXML
    private TextField nameTF;

    @FXML
    private Button nextPaneButton;

    @FXML
    private AnchorPane parentsPane;

    @FXML
    private TextField passportNumberTF;

    @FXML
    private TextField passportSeriaTF;

    @FXML
    private TextField patronymicTF;

    @FXML
    private AnchorPane personalDataPane;

    @FXML
    private TextField phoneNumberTF;

    @FXML
    private TextField specialityCodeTF;

    @FXML
    private TextField specialityNameTF;

    @FXML
    private TextField surnameTF;

    @FXML
    private DatePicker whenPassportGivenDP;

    @FXML
    private TextField whoGaveBirthSertificateTF;

    @FXML
    private TextField whoGavePassportTF;

    private Abiturient abiturient;
    private Education education;
    private PersonalData personalData;
    private Parents parents;
    private Long id;
    private DBHandler dbHandler = DBHandler.getDbHandler();
    private List<AnchorPane> panes = new ArrayList<>();
    private int nextPaneIndex = 1;
    private AnchorPane activePane;

    @FXML
    void initialize() {
        panes.add(abiturientPane);
        panes.add(personalDataPane);
        panes.add(educationPane);
        panes.add(parentsPane);
        activePane = panes.get(0);

        setOnlyNumeric(gradeTF, childeAmountTF, phoneNumberTF, fatherPhoneTF, motherPhoneTF);

        educationLevelCB.setItems(FXCollections.observableArrayList("Основное общее", "Среднее общее", "Начальное профессиональное"));

        familyStatusCB.setItems(FXCollections.observableArrayList("Полная", "Неполная"));

        id = up_02_01Controller.getId();

        abiturient = dbHandler.getAbiturient(id);
        education = dbHandler.getEducation(id);
        parents = dbHandler.getParents(id);
        personalData = dbHandler.getPersonalData(id);

        //abiturient
        birthdayDP.setValue(abiturient.getBirthday());
        addressTF.setText(abiturient.getAddress());
        phoneNumberTF.setText(abiturient.getPhoneNumber());
        fullnameTF.setText(abiturient.getFullname());

        //education
        educationLevelCB.setValue(education.getEducationLevel());
        atestatNumberTF.setText(education.getAttesstatNumber());
        gradeTF.setText(String.valueOf(education.getGrade()));
        specialityCodeTF.setText(education.getSpecialityCode());
        specialityNameTF.setText(education.getSpecialityName());

        //parents
        childeAmountTF.setText(String.valueOf(parents.getChildren_amount()));
        familyStatusCB.setValue(parents.getFamily_status());
        motherNameTF.setText(parents.getMother_name());
        motherAddressTF.setText(parents.getMother_address());
        motherPhoneTF.setText(parents.getMother_phone());
        motherWorkTF.setText(parents.getMother_work());
        fatherNameTF.setText(parents.getFather_name());
        fatherAddressTF.setText(parents.getFather_address());
        fatherPhoneTF.setText(parents.getFather_phone());
        fatherWorkTF.setText(parents.getFather_work());

        //personal data
        surnameTF.setText(personalData.getAbiturientSurname());
        nameTF.setText(personalData.getAbiturientName());
        patronymicTF.setText(personalData.getAbiturientPatronymic());
        birthPlaceTF.setText(personalData.getBirthPlace());
        birthdayDPPassport.setValue(personalData.getAbiturientBirthday());
        passportSeriaTF.setText(personalData.getPasportSeria());
        passportNumberTF.setText(personalData.getPasportNumber());
        whoGavePassportTF.setText(personalData.getWhoGavePasport());
        whenPassportGivenDP.setValue(personalData.getWhenPassportGiven());
        birthSertificateSeriaTF.setText(personalData.getBirthCertificateSeria());
        birthSertificateNumberTF.setText(personalData.getBirthCertificateNumber());
        whoGaveBirthSertificateTF.setText(personalData.getWhoGaveBirthCertificate());

        nextPaneButton.setOnAction(event -> {
            setNextPane();
//            if (fullnameTF.getText() == "") {
                fullnameTF.setText(surnameTF.getText() + " " + nameTF.getText() + " " + patronymicTF.getText());
                birthdayDPPassport.setValue(birthdayDP.getValue());
//            }
        });

        saveAbiturientButton.setOnAction(actionEvent -> {
            saveAbiturient(); //and my soul save too
            Stage stage = (Stage) saveAbiturientButton.getScene().getWindow();
            stage.close();
        });

    }

    private void saveAbiturient() {
        String update = "UPDATE up_02_01.parents, up_02_01.education, up_02_01.abiturients, up_02_01.personal_data SET " +
                "fullname = '" + fullnameTF.getText() +"', "+
                "phone_number = '" + phoneNumberTF.getText() +"', "+
                "address = '" + addressTF.getText() +"', "+

                "education_livel = '" + educationLevelCB.getValue() +"', "+
                "attestat_nuber = '" + atestatNumberTF.getText() +"', "+
                "grade = '" + gradeTF.getText() +"', "+
                "speciality_code = '" + specialityCodeTF.getText() +"', "+
                "speciality_name = '" + specialityNameTF.getText() +"', "+

                "family_status = '" + familyStatusCB.getValue() +"', "+
                "children_amount = '" + childeAmountTF.getText() +"', "+
                "mother_name = '" + motherNameTF.getText() +"', "+
                "mother_phone = '" + motherPhoneTF.getText() +"', "+
                "mother_address = '" + motherAddressTF.getText() +"', "+
                "mother_work = '" + motherWorkTF.getText() +"', "+
                "father_name = '" + fatherNameTF.getText() +"', "+
                "father_work = '" + fatherWorkTF.getText() +"', "+
                "father_phone = '" + fatherPhoneTF.getText() +"', "+
                "father_address = '" + fatherAddressTF.getText() +"', "+

                "abiturient_surname = '" + surnameTF.getText() +"', "+
                "abiturient_name = '" + nameTF.getText() +"', "+
                "abiturient_patronymic = '" + patronymicTF.getText() +"', "+
                "birth_place = '" + birthPlaceTF.getText() +"', "+
                "pasport_seria = '" + passportSeriaTF.getText() +"', "+
                "pasport_number = '" + passportNumberTF.getText() +"', "+
                "who_gave_pasport = '" + whoGavePassportTF.getText() +"', "+
                "birth_certificate_number = '" + birthSertificateNumberTF.getText() +"', "+
                "birth_certificate_seria = '" + birthSertificateSeriaTF.getText() +"', "+
                "who_gave_birth_certificate = '" + whoGaveBirthSertificateTF.getText() +"' "+

                "WHERE code = " + id + " and parents.abiturient_code = code and education.abiturient_code = code and personal_data.abiturient_code = code";
    dbHandler.updateAbiturient(update);
    }

    public void setNextPane() {
        activePane.setVisible(false);
        activePane = panes.get(nextPaneIndex);
        nextPaneIndex++;
        activePane.setVisible(true);
        if (nextPaneIndex == 4) {
            nextPaneButton.setDisable(true);
            saveAbiturientButton.setDisable(false);
        }
    }

}

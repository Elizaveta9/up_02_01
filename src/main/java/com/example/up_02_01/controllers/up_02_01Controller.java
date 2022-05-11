package com.example.up_02_01.controllers;

import com.example.up_02_01.service.DBHandler;
import com.example.up_02_01.windows.ModalWindow;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class up_02_01Controller {

    private DBHandler dbHandler = DBHandler.getDbHandler();

    @FXML
    private TableView<ObservableList> abiturientsTableView;

    @FXML
    private Button addButton;

    @FXML
    private TableView<ObservableList> educationTableView;

    @FXML
    private TableView<ObservableList> parentsTableView;

    @FXML
    private TableView<ObservableList> personalDataTableView;

    private static Long id;

    public static Long getId() {
        return id;
    }

    @FXML
    void initialize() {
        addButton.setOnAction(event -> {
            ModalWindow.newWindow("add_abiturient_window.fxml", "Добавить абитуриента");
            setTables();
        });

        setTables();
        setActionOnTables(abiturientsTableView, educationTableView, parentsTableView,personalDataTableView);
    }

    private void setActionOnTables(TableView<ObservableList>... tables) {
        for (TableView<ObservableList> t :
                tables) {
            t.setOnMouseClicked(mouseEvent -> {
                try {
                    String s = String.valueOf(t.getSelectionModel().getSelectedItem().get(0));
                    id = Long.valueOf(s);
                    ModalWindow.newWindow("edit_abiturient_window.fxml", "Редактировать пользователя");
                    setTables();
                } catch (Exception e){
                    System.out.println("Пустая строка");
                }
            });
        }
    }

    private void setTables() {
        dbHandler.setTableData(abiturientsTableView, "SELECT code as Код,fullname as ФИО,birthday as `День рождения`,phone_number as Телефон,address as Адресс FROM up_02_01.abiturients;");
        dbHandler.setTableData(educationTableView, "SELECT abiturient_code as `Код абитуриента`, education_livel as `Уровень образования`, attestat_nuber as `Номер аттестата`,\n" +
                "grade as `Средний балл`, speciality_code as `Код специальности`, speciality_name as `Специальность` FROM up_02_01.education;");
        dbHandler.setTableData(parentsTableView, "SELECT abiturient_code as `Код абитуриента`, family_status as `Статус семьи`, children_amount as `Количество детей`, mother_name as `ФИО матери`, mother_phone as `Телефон матери`, mother_address as `Адресс матери`, mother_work as `Место работы матери`, father_name as `ФИО отца`, father_phone as `Телефон отца`, \n" +
                "father_address as `Адрес отца`, father_work as `Место работы отца` FROM up_02_01.parents;");
        dbHandler.setTableData(personalDataTableView, "SELECT abiturient_code as `Код`, abiturient_surname as `Фамилия`, abiturient_name as `Имя`, abiturient_patronymic as `Отчество`, abiturien_birthday as `День рождения`, birth_place as `Место рождения`, pasport_seria as `Серия паспорта`,\n" +
                "pasport_number as `Номер паспорта`, who_gave_pasport as `Кем выдан паспорт`, when_pasrort_given as `Дата выдачи паспорта`, birth_certificate_number as `Номер свидетельства о рождении`, birth_certificate_seria as `Серия свидетельства о рождении`, who_gave_birth_certificate as `Кем выдано свидетельство о рождении` FROM up_02_01.personal_data;");
    }

}
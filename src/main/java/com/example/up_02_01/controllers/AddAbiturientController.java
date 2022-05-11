package com.example.up_02_01.controllers;

import com.example.up_02_01.entities.Abiturient;
import com.example.up_02_01.entities.Education;
import com.example.up_02_01.entities.Parents;
import com.example.up_02_01.entities.PersonalData;
import com.example.up_02_01.service.DBHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddAbiturientController implements NumericFields{

    @FXML
    private AnchorPane abiturientPane;

    @FXML
    private Button addAbiturientButton;

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
    private DatePicker whenPassportGivenDP;

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
    private TextField fatherHouseTF;

    @FXML
    private TextField fatherNameTF;

    @FXML
    private TextField fatherPhoneTF;

    @FXML
    private TextField fatherRoomTF;

    @FXML
    private TextField fatherStreetTF;

    @FXML
    private TextField fatherTownTF;

    @FXML
    private TextField fatherWorkTF;

    @FXML
    private TextField fullnameTF;

    @FXML
    private TextField gradeTF;

    @FXML
    private TextField houseTF;

    @FXML
    private TextField motherHouseTF;

    @FXML
    private TextField motherNameTF;

    @FXML
    private TextField motherPhoneTF;

    @FXML
    private TextField motherRoomTF;

    @FXML
    private TextField motherStreetTF;

    @FXML
    private TextField motherTownTF;

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
    private TextField roomTF;

    @FXML
    private TextField specialityCodeTF;

    @FXML
    private TextField specialityNameTF;

    @FXML
    private TextField streetTF;

    @FXML
    private TextField surnameTF;

    @FXML
    private TextField townTF;

    @FXML
    private TextField whoGaveBirthSertificateTF;

    @FXML
    private TextField whoGavePassportTF;

    private AnchorPane activePane;

    private DBHandler dbHandler = DBHandler.getDbHandler();

    private List<AnchorPane> panes = new ArrayList<>();
    private int nextPaneIndex = 1;

    @FXML
    void initialize() {
        panes.add(abiturientPane);
        panes.add(personalDataPane);
        panes.add(educationPane);
        panes.add(parentsPane);

        setOnlyNumeric(houseTF, roomTF, gradeTF, motherHouseTF, motherRoomTF, fatherHouseTF, fatherRoomTF,
                childeAmountTF, phoneNumberTF, fatherPhoneTF, motherPhoneTF);

        activePane = panes.get(0);

        nextPaneButton.setOnAction(event -> {
            setNextPane();
            if (fullnameTF.getText() == "") {
                fullnameTF.setText(surnameTF.getText() + " " + nameTF.getText() + " " + patronymicTF.getText());
                birthdayDPPassport.setValue(birthdayDP.getValue());
            }
        });

        addAbiturientButton.setOnAction(event -> {
            addAbiturientButton.setDisable(true);
            List<TextField> numericFields = FXCollections.observableArrayList(houseTF, roomTF, gradeTF, motherHouseTF, motherRoomTF, fatherHouseTF, fatherRoomTF,
                    childeAmountTF, phoneNumberTF, fatherPhoneTF, motherPhoneTF);
            for (TextField t :
                    numericFields) {
                if (t.getText() == "") {
                    t.setText("0");
                }
            }
            List<DatePicker> datePickers = FXCollections.observableArrayList(birthdayDP, birthdayDPPassport, whenPassportGivenDP);
            for (DatePicker dp :
                    datePickers) {
                if (dp.getValue() == null) {
                    dp.setValue(LocalDate.now());
                }
            }
            addAbiturient();
            Stage stage = (Stage) addAbiturientButton.getScene().getWindow();
            stage.close();
        });

        educationLevelCB.setItems(FXCollections.observableArrayList("Основное общее", "Среднее общее", "Начальное профессиональное"));
        educationLevelCB.setValue("Основное общее");

        familyStatusCB.setItems(FXCollections.observableArrayList("Полная", "Неполная"));
        familyStatusCB.setValue("Полная");
    }

    public void setNextPane() {
        activePane.setVisible(false);
        activePane = panes.get(nextPaneIndex);
        nextPaneIndex++;
        activePane.setVisible(true);
        if (nextPaneIndex == 4) {
            nextPaneButton.setDisable(true);
            addAbiturientButton.setDisable(false);
        }
    }

    public void addAbiturient() {
        dbHandler.putAbiturient(new Abiturient(
                fullnameTF.getText(),
                birthdayDPPassport.getValue(),
                phoneNumberTF.getText(),
                townTF.getText(),
                streetTF.getText(),
                Integer.parseInt(houseTF.getText()),
                Integer.parseInt(roomTF.getText())
        ));

        dbHandler.putEducation(new Education(
                educationLevelCB.getValue(),
                atestatNumberTF.getText(),
                Float.parseFloat(gradeTF.getText()),
                specialityNameTF.getText(),
                specialityCodeTF.getText()
        ));

        dbHandler.putParents(new Parents(
                familyStatusCB.getValue(),
                Integer.parseInt(childeAmountTF.getText()),
                motherNameTF.getText(),
                motherTownTF.getText(),
                Integer.parseInt(motherHouseTF.getText()),
                motherStreetTF.getText(),
                Integer.parseInt(motherRoomTF.getText()),
                motherPhoneTF.getText(),
                motherWorkTF.getText(),
                fatherNameTF.getText(),
                fatherTownTF.getText(),
                Integer.parseInt(fatherHouseTF.getText()),
                fatherStreetTF.getText(),
                Integer.parseInt(fatherRoomTF.getText()),
                fatherWorkTF.getText(),
                fatherPhoneTF.getText()

        ));

        dbHandler.putPersonalData(new PersonalData(
                surnameTF.getText(),
                nameTF.getText(),
                patronymicTF.getText(),
                birthdayDP.getValue(),
                birthPlaceTF.getText(),
                passportSeriaTF.getText(),
                passportNumberTF.getText(),
                whoGavePassportTF.getText(),
                whenPassportGivenDP.getValue(),
                birthSertificateNumberTF.getText(),
                birthSertificateSeriaTF.getText(),
                whoGaveBirthSertificateTF.getText()
        ));
    }

}

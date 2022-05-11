package com.example.up_02_01.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public interface NumericFields {
    public default void setOnlyNumeric(TextField... textFields) {
        for (TextField t :
                textFields) {
            t.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    if (!t1.matches("\\d")) {
                        t.setText(t1.replaceAll("[^\\d\\.]", ""));
                    }
                }
            });
        }
    }
}

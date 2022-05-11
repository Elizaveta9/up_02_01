module com.example.up_02_01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens com.example.up_02_01 to javafx.fxml;
    exports com.example.up_02_01;

    opens com.example.up_02_01.controllers to javafx.fxml;
    opens com.example.up_02_01.entities to javafx.base;
}
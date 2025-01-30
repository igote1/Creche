module com.tads.creche {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.tads.creche to javafx.fxml;
    exports com.tads.creche;
    exports com.tads.creche.Controller;
    opens com.tads.creche.Controller to javafx.fxml;
}
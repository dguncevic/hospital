module com.mycompany.hospital2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires lombok;
    requires com.google.gson;
    requires com.dlsc.pickerfx;

    opens com.mycompany.hospital2 to javafx.fxml, com.google.gson;
    opens com.hospital.beans to com.google.gson;
    exports com.mycompany.hospital2;
}

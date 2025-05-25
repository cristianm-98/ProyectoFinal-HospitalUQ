module co.edu.uniquindio.poo.hospital {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens co.edu.uniquindio.poo.hospital to javafx.fxml;
    opens co.edu.uniquindio.poo.hospital.viewController to javafx.fxml;
    opens co.edu.uniquindio.poo.hospital.model to java.base;

    exports co.edu.uniquindio.poo.hospital;
    exports co.edu.uniquindio.poo.hospital.viewController;
    exports co.edu.uniquindio.poo.hospital.controller;
    exports co.edu.uniquindio.poo.hospital.model;



}
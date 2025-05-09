module co.edu.uniquindio.poo.hospital {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens co.edu.uniquindio.poo.hospital to javafx.fxml;
    exports co.edu.uniquindio.poo.hospital;
}
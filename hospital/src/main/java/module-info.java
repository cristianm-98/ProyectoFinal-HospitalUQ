module co.edu.uniquindio.poo.hospital {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.hospital to javafx.fxml;
    exports co.edu.uniquindio.poo.hospital;
}
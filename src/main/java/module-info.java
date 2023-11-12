module com.example.finalisw3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalisw3 to javafx.fxml;
    exports com.example.finalisw3;
}
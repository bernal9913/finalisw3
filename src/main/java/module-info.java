module com.example.finalisw3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.finalisw3 to javafx.fxml;
    exports com.example.finalisw3;
}
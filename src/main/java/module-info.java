module com.example.finalisw3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;


    opens com.example.finalisw3 to javafx.fxml;
    exports com.example.finalisw3;
    exports tests;
    opens tests to javafx.fxml;
}
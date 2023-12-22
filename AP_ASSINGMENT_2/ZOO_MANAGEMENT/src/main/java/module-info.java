module com.example.zoo_management {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zoo_management to javafx.fxml;
    exports com.example.zoo_management;
}
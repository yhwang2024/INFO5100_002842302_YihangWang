module com.example.image_management_tool {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.image_management_tool to javafx.fxml;
    exports com.example.image_management_tool;
}
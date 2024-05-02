module com.example.helloworld {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.helloworld to javafx.fxml;
    exports com.example.helloworld;
}
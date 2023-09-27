module com.mycompany.hotel.prototype.maven {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    opens com.mycompany.hotel.prototype.maven to javafx.fxml;
    exports com.mycompany.hotel.prototype.maven;
}

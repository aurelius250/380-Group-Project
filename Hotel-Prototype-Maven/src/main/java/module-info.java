module com.mycompany.hotel.prototype.maven {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires javafx.base;
    requires javafx.graphics;
    requires java.base;
    opens com.mycompany.hotel.prototype.maven to javafx.fxml;
    exports com.mycompany.hotel.prototype.maven;
}

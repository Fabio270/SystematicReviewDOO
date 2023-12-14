module com.systematic.doosystematic {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires java.logging;
    requires com.google.gson;

    exports com.systematic.doosystematic.application.view;
    exports com.systematic.doosystematic.application.controller to javafx.fxml;
    opens com.systematic.doosystematic.application.view.images;
    opens com.systematic.doosystematic.application.view;
    opens com.systematic.doosystematic.application.controller to javafx.fxml;
    opens com.systematic.doosystematic.domain.entities to com.google.gson;

}
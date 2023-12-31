package com.systematic.doosystematic.application.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowLoader extends Application {
    private static Scene scene;
    private static Object controller;

    private  static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFxml("initial_page.fxml"));
        primaryStage = stage;
        stage.setMinWidth(600);
        stage.setMinHeight(400.0);
        stage.setTitle("Systematic Review");
        stage.setScene(scene);
        stage.show();
    }
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFxml(fxml));
    }
    private static Parent loadFxml(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent parent = fxmlLoader.load(WindowLoader.class.getResource(fxml).openStream());
        controller = fxmlLoader.getController();
        return parent;
    }
    public static Object getController() {
        return controller;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    public static void main(String[] args) {
        launch();
    }
}

package com.systematic.doosystematic.application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class InitialPageUIController {
    @FXML
    private ImageView imgLogo;

    @FXML
    private Button btnStart;

    @FXML
    private ImageView imgStart;

    @FXML
    private Button btnSaved1;

    @FXML
    public void initialize() {
        setImages();
    }

    private void setImages() {
        Image image1 = new Image("file:src/main/resources/com/systematic/doosystematic/application/view/images/logo.png");
        Image image2 = new Image("file:src/main/resources/com/systematic/doosystematic/application/view/images/play-button.png");
        imgLogo.setImage(image1);
        imgStart.setImage(image2);
    }


}

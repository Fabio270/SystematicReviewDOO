package com.systematic.doosystematic.application.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TextAnswerUIController {

    @FXML
    private ImageView imgCheck;

    public void initialize() {
        setImages();
    }

    private void setImages() {
        Image imagePlus = new Image("file:src/main/resources/com/systematic/doosystematic/application/view/images/check.png");
        imgCheck.setImage(imagePlus);
    }
}

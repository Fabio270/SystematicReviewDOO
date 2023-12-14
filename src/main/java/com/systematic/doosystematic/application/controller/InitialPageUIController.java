package com.systematic.doosystematic.application.controller;

import com.systematic.doosystematic.application.view.WindowLoader;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class InitialPageUIController {
    @FXML
    private ImageView imgLogo;

    @FXML
    private ImageView imgStart;

    @FXML
    public void initialize() {
        setImages();
    }

    private void setImages() {
        Image imageLogo = new Image("file:src/main/resources/com/systematic/doosystematic/application/view/images/logo.png");
        Image imagePlay = new Image("file:src/main/resources/com/systematic/doosystematic/application/view/images/play-button.png");
        imgLogo.setImage(imageLogo);
        imgStart.setImage(imagePlay);
    }

    @FXML
    private void goToNewSystematicReview() throws IOException {
        WindowLoader.setRoot("newSystematicReview.fxml");
    }
}

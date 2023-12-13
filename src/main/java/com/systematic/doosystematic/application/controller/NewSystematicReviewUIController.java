package com.systematic.doosystematic.application.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NewSystematicReviewUIController {

    @FXML
    private ImageView imgUpload;

    @FXML
    private ImageView imgNext;

    @FXML
    public void initialize() {
        setImages();
    }

    private void setImages() {
        Image imageArrow = new Image("file:src/main/resources/com/systematic/doosystematic/application/view/images/arrow.png");
        Image imageArrowNext = new Image("file:src/main/resources/com/systematic/doosystematic/application/view/images/arrow-next.png");
        imgUpload.setImage(imageArrow);
        imgNext.setImage(imageArrowNext);
    }
}

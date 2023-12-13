package com.systematic.doosystematic.application.controller;

import com.systematic.doosystematic.domain.entities.Protocol;
import com.systematic.doosystematic.domain.entities.SystematicReview;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ProtocolQuestionsViewUIController {

    @FXML
    private ImageView imgArrowNext;

    @FXML
    private ImageView imgPlus;

    private SystematicReview systematicReview;
    private Protocol protocol;

    @FXML
    public void initialize() {
        setImages();
    }

    private void setImages() {
        Image imagePlus = new Image("file:src/main/resources/com/systematic/doosystematic/application/view/images/plus.png");
        Image imageArrowNext = new Image("file:src/main/resources/com/systematic/doosystematic/application/view/images/arrow-next.png");
        imgPlus.setImage(imagePlus);
        imgArrowNext.setImage(imageArrowNext);
    }

    public void getCurrentData(SystematicReview currentSystematicReview, Protocol currentProtocol) {
        systematicReview = currentSystematicReview;
        protocol = currentProtocol;
    }
}

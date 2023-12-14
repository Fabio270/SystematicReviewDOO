package com.systematic.doosystematic.application.controller;

import com.systematic.doosystematic.application.view.WindowLoader;
import com.systematic.doosystematic.utils.SystematicReviewAlerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MultiChoicesQuestionUIController {

    @FXML
    private ImageView imgCheck;

    @FXML
    private TextField txtAnswer1;

    @FXML
    private TextField txtAnswer2;

    @FXML
    private TextField txtAnswer3;

    @FXML
    private TextField txtAnswer4;

    private List<String> options;

    private Stage stage;

    private ProtocolQuestionsViewUIController protocolQuestionsViewUIController;

    private final SystematicReviewAlerts alerts = new SystematicReviewAlerts();

    public void setNavigationData(Stage stage, ProtocolQuestionsViewUIController protocolQuestionsViewUIController) {
        this.stage = stage;
        this.protocolQuestionsViewUIController = protocolQuestionsViewUIController;
    }

    public void initialize() {
        options = new ArrayList<>();
        setImages();
    }

    private void setImages() {
        Image imagePlus = new Image("file:src/main/resources/com/systematic/doosystematic/application/view/images/check.png");
        imgCheck.setImage(imagePlus);
    }

    @FXML
    private void backToProtocolQuestionsView() throws IOException {
        String answer1 = txtAnswer1.getText();
        String answer2 = txtAnswer2.getText();
        String answer3 = txtAnswer3.getText();
        String answer4 = txtAnswer4.getText();
        if (answer1.isEmpty() || answer2.isEmpty() || answer3.isEmpty() || answer4.isEmpty()) {
            alerts.showInsuficientDataAlert();
        } else {
            options.add(answer1);
            options.add(answer2);
            options.add(answer3);
            options.add(answer4);
            presentOptionsToProtocolQuestionsView(options);
            stage.close();
        }
    }

    private void presentOptionsToProtocolQuestionsView(List<String> options) throws IOException {
        protocolQuestionsViewUIController.setOptions(options);
    }
}

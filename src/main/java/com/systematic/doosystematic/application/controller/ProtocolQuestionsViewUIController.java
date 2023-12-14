package com.systematic.doosystematic.application.controller;

import com.systematic.doosystematic.application.view.WindowLoader;
import com.systematic.doosystematic.domain.entities.*;
import com.systematic.doosystematic.utils.SystematicReviewAlerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProtocolQuestionsViewUIController {

    @FXML
    private TextField txtDescription;

    @FXML
    private ImageView imgArrowNext;

    @FXML
    private ImageView imgPlus;

    @FXML
    private RadioButton rdBtnBoxTextual;

    @FXML
    private RadioButton rdBtnBoxList;

    @FXML
    private Label lblNumberQuestion;

    private ToggleGroup toggleGroup;

    private SystematicReview systematicReview;
    private Protocol protocol;

    private List<Question> questions;

    private List<String> multiChoiceOptions;

    private final SystematicReviewAlerts alerts = new SystematicReviewAlerts();

    int counter;

    @FXML
    public void initialize() {
        setImages();
        setToggleGroup();
        questions = new ArrayList<>();
        multiChoiceOptions = new ArrayList<>();
        counter = 0;
        updateQuestionCounter();
    }

    private void updateQuestionCounter() {
        counter += 1;
        lblNumberQuestion.setText("Pergunta " + String.valueOf(counter));
    }

    private void setImages() {
        Image imagePlus = new Image("file:src/main/resources/com/systematic/doosystematic/application/view/images/plus.png");
        Image imageArrowNext = new Image("file:src/main/resources/com/systematic/doosystematic/application/view/images/arrow-next.png");
        imgPlus.setImage(imagePlus);
        imgArrowNext.setImage(imageArrowNext);
    }

    private void setToggleGroup() {
        toggleGroup = new ToggleGroup();
        rdBtnBoxTextual.setToggleGroup(toggleGroup);
        rdBtnBoxList.setToggleGroup(toggleGroup);
    }

    public void setCurrentData(SystematicReview currentSystematicReview, Protocol currentProtocol) {
        systematicReview = currentSystematicReview;
        protocol = currentProtocol;
    }

    public void setOptions(List<String> currentOptions) {
        multiChoiceOptions = currentOptions;
    }

    @FXML
    private void goToMultiChoicesQuestions() throws IOException {
        Stage modalStage = new Stage();
        Stage primaryStage = WindowLoader.getPrimaryStage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(WindowLoader.class.getResource("multi_choices_question.fxml").openStream());
        modalStage.initOwner(primaryStage);
        modalStage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        modalStage.setScene(scene);
        MultiChoicesQuestionUIController multiChoicesQuestionUIController = loader.getController();
        multiChoicesQuestionUIController.setNavigationData(modalStage, this);
        modalStage.showAndWait();
    }

    @FXML
    private void didSelectTextQuestion() {
        multiChoiceOptions.clear();
    }

    @FXML
    private void addQuestion() {
        RadioButton selectedButton = (RadioButton) toggleGroup.getSelectedToggle();
        String description = txtDescription.getText();

        if (selectedButton == null || description.isEmpty()) {
            alerts.showInsuficientDataAlert();
        } else {
            String selectedId = selectedButton.getId();
            if (selectedId.equals("rdBtnBoxTextual")) {
                addTextualQuestion(description);
            } else {
                addMultiChoicesQuestion(description);
            }

        }
    }

    private void addTextualQuestion(String description) {
        QuestionTextual textualQuestion = new QuestionTextual(description);
        questions.add(textualQuestion);
        questionAddedWithSuccess();
    }

    private void addMultiChoicesQuestion(String description) {
        if (multiChoiceOptions.isEmpty()) {
            alerts.showInsuficientDataAlert();
        } else {
            QuestionPickList pickListQuestion = new QuestionPickList(description, multiChoiceOptions);
            questions.add(pickListQuestion);
            multiChoiceOptions.clear();
            questionAddedWithSuccess();
        }
    }

    private void questionAddedWithSuccess() {
        txtDescription.clear();
        toggleGroup.selectToggle(null);
        updateQuestionCounter();
        alerts.showSuccessAlert("Questão adicionada com sucesso. \n Número de questões adicionadas até o momento: " +
                String.valueOf(questions.size()));
    }

    @FXML
    private void goToFiltragem1() {
        if (questions.isEmpty()) {
            alerts.showInsuficientDataAlert();
        } else {
//            protocol.setForm(questions);
//            systematicReview.setProtocol(protocol);

        }
    }

    public ProtocolQuestionsViewUIController getController() {
        return this;
    }
}

package com.systematic.doosystematic.application.controller;

import com.systematic.doosystematic.application.view.WindowLoader;
import com.systematic.doosystematic.domain.entities.Criteria;
import com.systematic.doosystematic.domain.entities.CriteriaType;
import com.systematic.doosystematic.domain.entities.Protocol;
import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.utils.SystematicReviewAlerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProtocoloViewUIController {

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtSearchString;

    @FXML
    private TextField txtInclusionCriteria;

    @FXML
    private TextField txtExclusionCriteria;

    @FXML
    private ImageView imgPlus1;

    @FXML
    private ImageView imgArrowNext;

    @FXML
    private ImageView imgPlus2;

    private SystematicReview systematicReview;

    private List<Criteria> inclusionCriteriaList;
    private List<Criteria> exclusionCriteriaList;

    private final SystematicReviewAlerts alerts = new SystematicReviewAlerts();


    @FXML
    public void initialize() {
        inclusionCriteriaList = new ArrayList<>();
        exclusionCriteriaList = new ArrayList<>();
        setImages();
    }

    private void setImages() {
        Image imagePlus = new Image("file:src/main/resources/com/systematic/doosystematic/application/view/images/plus.png");
        Image imageArrowNext = new Image("file:src/main/resources/com/systematic/doosystematic/application/view/images/arrow-next.png");
        imgPlus1.setImage(imagePlus);
        imgPlus2.setImage(imagePlus);
        imgArrowNext.setImage(imageArrowNext);
    }

    public void getCurrentSystematicReview(SystematicReview currentSystematicReview) {
        systematicReview = currentSystematicReview;
    }

    @FXML
    private void addInclusionCriteria() {
        if (txtInclusionCriteria.getText().isEmpty()) {
            alerts.showInsuficientDataAlert();
        } else {
            Criteria inclusionCriteria = new Criteria(txtInclusionCriteria.getText(), CriteriaType.INCLUSION);
            inclusionCriteriaList.add(inclusionCriteria);
            txtInclusionCriteria.clear();
            alerts.showSuccessAlert("Critério de inclusão adicionado com sucesso.");
        }
    }

    @FXML
    private void addExclusionCriteria() {
        if (txtExclusionCriteria.getText().isEmpty()) {
            alerts.showInsuficientDataAlert();
        } else {
            Criteria exclusionCriteria = new Criteria(txtExclusionCriteria.getText(), CriteriaType.EXCLUSION);
            exclusionCriteriaList.add(exclusionCriteria);
            txtExclusionCriteria.clear();
            alerts.showSuccessAlert("Critério de exclusão adicionado com sucesso.");
        }
    }

    @FXML
    private void goToProtocolQuestionsView() throws IOException {
        String title = txtTitle.getText();
        String description = txtDescription.getText();
        String searchString = txtSearchString.getText();

        if (title.isEmpty() || description.isEmpty() || searchString.isEmpty() ||
                exclusionCriteriaList.isEmpty() || inclusionCriteriaList.isEmpty()) {
            alerts.showInsuficientDataAlert();
        } else {
            Protocol protocol = new Protocol(title, description, searchString, inclusionCriteriaList, exclusionCriteriaList);
            presentDataToProtocolQuestionsView(protocol);
        }
    }

    private void presentDataToProtocolQuestionsView(Protocol protocol) throws IOException {
//        ProtocolQuestionsViewUIController protocolQuestionsViewUIController = new ProtocolQuestionsViewUIController().getController();
//        protocolQuestionsViewUIController.setCurrentData(systematicReview, protocol);
//        WindowLoader.setRoot("protocol_questions_view.fxml");
        FXMLLoader loader = new FXMLLoader();
        Parent parent = loader.load(WindowLoader.class.getResource("protocol_questions_view.fxml").openStream());
        ProtocolQuestionsViewUIController protocolQuestionsViewUIController = loader.getController();
        protocolQuestionsViewUIController.setCurrentData(systematicReview, protocol);
        WindowLoader.setRoot("protocol_questions_view.fxml");
    }

}

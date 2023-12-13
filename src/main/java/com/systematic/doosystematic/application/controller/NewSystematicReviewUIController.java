package com.systematic.doosystematic.application.controller;

import com.systematic.doosystematic.domain.entities.Article;
import com.systematic.doosystematic.domain.entities.Base;
import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.utils.JSONParser;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class NewSystematicReviewUIController {

    @FXML
    private ImageView imgUpload;

    @FXML
    private ImageView imgNext;

    @FXML
    private Button btnUpload;

    @FXML
    private Label fileNameLbl;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtBase;

    private File baseFile;

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

    @FXML
    private void uploadBase() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivos JSON", "*.json"));
        File choosedFile = fileChooser.showOpenDialog(new Stage());

        if (choosedFile != null) {
            fileNameLbl.setText(choosedFile.getName());
            baseFile = choosedFile;
        } else {
            baseFile = null;
        }
    }

    @FXML
    private void goToProtocoloView() {
        String title = txtTitle.getText();
        String description = txtDescription.getText();

        if (title.isEmpty() || description.isEmpty() || (baseFile == null)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, preencha todos os campos.");
            alert.showAndWait();
        } else {
            List<Article> articles = JSONParser.parseJSONFile(baseFile.getAbsolutePath());
            Base base = new Base(txtBase.getText(), articles);
            SystematicReview systematicReview = new SystematicReview(title, description, base);

            // WIP

        }
    }
}

package com.systematic.doosystematic.utils;

import javafx.scene.control.Alert;

public class SystematicReviewAlerts {

    private String systematicReview = "Systematic Review informa";
    public void showErrorAlert(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(systematicReview);
        alert.setContentText(e.getLocalizedMessage());
        alert.showAndWait();
    }

    public void showInsuficientDataAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(systematicReview + " - Dados insuficientes");
        alert.setContentText("Por favor, preencha todos os campos e tente novamente.");
        alert.showAndWait();
    }

    public void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(systematicReview);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void showWarningAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(systematicReview);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

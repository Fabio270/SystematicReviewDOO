package com.systematic.doosystematic.domain.usecases.studyReview;

import com.systematic.doosystematic.domain.entities.Stage1;
import com.systematic.doosystematic.domain.entities.StudyReview;

import java.util.List;

public class SelectStage1StudiesUseCase {
    private final List<StudyReview> articlesFromDatabases;

    public SelectStage1StudiesUseCase(List<StudyReview> articlesFromDatabases) {
        this.articlesFromDatabases = articlesFromDatabases;

    }

    public void reviewArticles() {
        for (StudyReview article : articlesFromDatabases) {
            displayArticleDetails(article);

            Stage1 userDecision = getUserDecision();

            if (userDecision == Stage1.ACCEPTED) {
                article.setStatusStage1(Stage1.ACCEPTED);
            } else {
                article.setStatusStage1(Stage1.REJECTED);
            }
        }
    }

    private Stage1 getUserDecision() {
        return Stage1.ACCEPTED;
    }

    private void displayArticleDetails(StudyReview article) {
        System.out.println("\nTítulo: " + article.getTitle() +
                            "\nResumo: " + article.getResumo());

    }
}

package com.systematic.doosystematic.domain.usecases.studyReview;

import com.systematic.doosystematic.domain.entities.Stage1;
import com.systematic.doosystematic.domain.entities.Stage2;
import com.systematic.doosystematic.domain.entities.StudyReview;

import java.util.List;
import java.util.stream.Collectors;

public class SelectStage2StudiesUseCase {
    private final List<StudyReview> articlesFromDatabases;

    public SelectStage2StudiesUseCase(List<StudyReview> articlesFromDatabases) {
        this.articlesFromDatabases = articlesFromDatabases;

    }

    public void Stage2Articles() {
        List<StudyReview> acceptedArticles = articlesFromDatabases.stream()
                .filter(article -> article.getStatusStage1() == Stage1.ACCEPTED)
                .collect(Collectors.toList());
        for (StudyReview article : acceptedArticles) {
            displayArticleDetails(article);


        }
    }

    private Stage2 getUserDecision() {
        return null;
    }

    private void displayArticleDetails(StudyReview article) {
        System.out.println("\nTítulo: " + article.getTitle() +
                        "\nResumo: " + article.getResumo() +
                        "\nAuthors: " + article.getAuthors() +
                        "\n\n" + article.getText());

    }
}

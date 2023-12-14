package com.systematic.doosystematic.domain.entities;

import org.bson.Document;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class StudyReview {
    private UUID id;
    private UUID systematicReviewId;
    private Article article;
    private Enum<Stage1> statusStage1;
    private Enum<Stage2> statusStage2;
    private List<Answer> answers;

    public StudyReview(UUID id, UUID systematicReviewId, Article article, Enum<Stage1> statusStage1, List<Answer> answers) {
        this.id = id;
        this.systematicReviewId = systematicReviewId;
        this.article = article;
        this.statusStage1 = statusStage1;
        this.answers = answers;
    }

    public StudyReview(UUID id, Article article) {
        this.id = id;
        this.article = article;
    }

    public Document toJson() {
        Document document = new Document("id", id.toString())
                .append("article", article.toJson());

        if (statusStage1 != null) {
            document.append("statusStage1", statusStage1.toString());
        }

        if (statusStage2 != null) {
            document.append("statusStage2", statusStage2.toString());
        }

        List<Document> answersDocuments = answers.stream()
                .map(Answer::toJson)
                .collect(Collectors.toList());
        document.append("answers", answersDocuments);

        return document;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public UUID getId() {
        return id;
    }

    public Enum<Stage1> getStatusStage1() {
        return statusStage1;
    }

    public Enum<Stage2> getStatusStage2() {
        return statusStage2;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setStatusStage1(Enum<Stage1> statusStage1) {
        this.statusStage1 = statusStage1;
    }

    public void setStatusStage2(Enum<Stage2> statusStage2) {
        this.statusStage2 = statusStage2;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public UUID getSystematicReviewId() {
        return systematicReviewId;
    }

    public void setSystematicReviewId(UUID systematicReviewId) {
        this.systematicReviewId = systematicReviewId;
    }
}

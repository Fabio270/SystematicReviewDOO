package com.systematic.doosystematic.domain.entities;

import java.util.List;
import java.util.UUID;

public class StudyReview {
    private UUID id;
    private UUID systematicReviewId;
    private String title;
    private String resumo;
    private String text;
    private String authors;
    private String keywords;
    private List<Base> bases;
    private Enum<Stage1> statusStage1;
    private Enum<Stage2> statusStage2;
    private List<Answer> answers;

    public StudyReview(UUID id, UUID systematicReviewId, String title, String resumo, String text, String authors, String keywords, List<Base> bases, Enum<Stage1> statusStage1, List<Answer> answers) {
        this.id = id;
        this.systematicReviewId = systematicReviewId;
        this.title = title;
        this.resumo = resumo;
        this.text = text;
        this.authors = authors;
        this.keywords = keywords;
        this.bases = bases;
        this.statusStage1 = statusStage1;
        this.answers = answers;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getResumo() {
        return resumo;
    }

    public String getText() {
        return text;
    }

    public String getAuthors() {
        return authors;
    }

    public String getKeywords() {
        return keywords;
    }

    public List<Base> getBases() {
        return bases;
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

    public void setBases(List<Base> bases) {
        this.bases = bases;
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

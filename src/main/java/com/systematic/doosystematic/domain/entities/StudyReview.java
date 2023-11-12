package com.systematic.doosystematic.domain.entities;

import java.util.List;
import java.util.UUID;

public class StudyReview {
    private UUID id;
    private String title;
    private String resumo;
    private String text;
    private String authors;
    private String keywords;
    private List<Base> bases;
    private Enum<Stage1> statusStage1;
    private Enum<Stage2> statusStage2;
    private List<Answer> answers;

    public StudyReview(UUID id, String title, String resumo, String text, String authors, String keywords, List<Base> bases, Enum<Stage1> statusStage1, List<Answer> answers) {
        this.id = id;
        this.title = title;
        this.resumo = resumo;
        this.text = text;
        this.authors = authors;
        this.keywords = keywords;
        this.bases = bases;
        this.statusStage1 = statusStage1;
        this.answers = answers;
    }

    public StudyReview(UUID id, String title, String resumo, String text, String authors, String keywords, List<Base> bases) {
        this.id = id;
        this.title = title;
        this.resumo = resumo;
        this.text = text;
        this.authors = authors;
        this.keywords = keywords;
        this.bases = bases;
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
}

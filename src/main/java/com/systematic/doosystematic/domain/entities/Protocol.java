package com.systematic.doosystematic.domain.entities;

import org.bson.Document;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Protocol {
    private UUID uuid;
    private UUID systematicReviewId;
    private String title;
    private String description;
    private String searchString;
    private List<Question> form;
    private List<Criteria> inclusionCriteria;
    private List<Criteria> exclusionCriteria;

    public Protocol(UUID uuid, UUID systematicReviewId, String title, String description, String searchString, List<Question> form, List<Criteria> inclusionCriteria, List<Criteria> exclusionCriteria) {
        this.uuid = uuid;
        this.systematicReviewId = systematicReviewId;
        this.title = title;
        this.description = description;
        this.searchString = searchString;
        this.form = form;
        this.inclusionCriteria = inclusionCriteria;
        this.exclusionCriteria = exclusionCriteria;
    }

    public Protocol(String title, String description, String searchString, List<Criteria> inclusionCriteria, List<Criteria> exclusionCriteria) {
        this.title = title;
        this.description = description;
        this.searchString = searchString;
        this.inclusionCriteria = inclusionCriteria;
        this.exclusionCriteria = exclusionCriteria;
    }

    public Document toJson(){
        Document document = new Document("uuid", uuid.toString());
        document.append("title", title);
        document.append("description", description);
        document.append("searchString", searchString);

        List<Document> formDocuments = form.stream()
                .map(Question::toJson)
                .collect(Collectors.toList());
        document.append("form", formDocuments);

        List<Document> inclusionCriteriaDocuments = inclusionCriteria.stream()
                .map(Criteria::toJson)
                .collect(Collectors.toList());
        document.append("inclusionCriteria", inclusionCriteriaDocuments);

        List<Document> exclusionCriteriaDocuments = exclusionCriteria.stream()
                .map(Criteria::toJson)
                .collect(Collectors.toList());
        document.append("exclusionCriteria", exclusionCriteriaDocuments);

        return document;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getDescription() {
        return description;
    }

    public String getSearchString() {
        return searchString;
    }

    public List<Question> getForm() {
        return form;
    }

    public List<Criteria> getInclusionCriteria() {
        return inclusionCriteria;
    }

    public List<Criteria> getExclusionCriteria() {
        return exclusionCriteria;
    }

    public UUID getSystematicReviewId() {
        return systematicReviewId;
    }

    public void setSystematicReviewId(UUID systematicReviewId) {
        this.systematicReviewId = systematicReviewId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setForm(List<Question> form) {
        this.form = form;
    }
}
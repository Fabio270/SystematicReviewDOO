package com.systematic.doosystematic.domain.entities;

import org.bson.Document;

import java.util.UUID;

public class Criteria {
    private UUID id;
    private UUID systematicReviewId;
    private String description;
    private CriteriaType type;

    public Criteria(UUID id, UUID systematicReviewId, String description, CriteriaType type) {
        this.id = id;
        this.systematicReviewId = systematicReviewId;
        this.description = description;
        this.type = type;
    }

    public Criteria(String description, CriteriaType type) {
        this.description = description;
        this.type = type;
    }

    public Criteria(UUID id, String description, CriteriaType type) {
        this.id = id;
        this.description = description;
        this.type = type;
    }

    public Document toJson() {
        Document document = new Document("id", id.toString());
        document.append("description", description);
        document.append("type", type);

        return document;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public CriteriaType getType() {
        return type;
    }

    public UUID getSystematicReviewId() {
        return systematicReviewId;
    }

    public void setSystematicReviewId(UUID systematicReviewId) {
        this.systematicReviewId = systematicReviewId;
    }
}

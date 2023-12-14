package com.systematic.doosystematic.domain.entities;

import org.bson.Document;

import java.util.UUID;

public abstract class Question {
    private UUID id;
    private UUID systematicReviewId;
    private String description;

    public Question(UUID id, UUID systematicReviewId, String description) {
        this.id = id;
        this.systematicReviewId = systematicReviewId;
        this.description = description;
    }

    public Question(UUID id, String description) {
        this.description = description;
    }

    public Question(String description) {
        this.description = description;
    }

    public Document toJson() {
        Document document = new Document("id", id.toString());
        document.append("description", description);
        return document;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public UUID getSystematicReviewId() {
        return systematicReviewId;
    }

    public void setSystematicReviewId(UUID systematicReviewId) {
        this.systematicReviewId = systematicReviewId;
    }
}

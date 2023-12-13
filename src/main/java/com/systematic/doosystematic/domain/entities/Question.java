package com.systematic.doosystematic.domain.entities;

import org.bson.Document;

import java.util.UUID;

public abstract class Question {
    private UUID id;
    private String description;

    public Question(UUID id, String description) {
        this.id = id;
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
}

package com.systematic.doosystematic.domain.entities;

import org.bson.Document;

import java.util.UUID;

public class Criteria {
    private UUID id;
    private String description;
    private boolean type;

    public Criteria(UUID id, String description, boolean type) {
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

    public boolean getType() {
        return type;
    }
}

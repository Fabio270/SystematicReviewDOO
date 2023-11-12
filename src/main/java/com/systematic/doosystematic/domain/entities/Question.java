package com.systematic.doosystematic.domain.entities;

import java.util.UUID;

public abstract class Question {
    private UUID id;
    private String description;

    public Question(UUID id, String description) {
        this.id = id;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}

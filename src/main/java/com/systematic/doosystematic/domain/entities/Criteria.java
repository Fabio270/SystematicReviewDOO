package com.systematic.doosystematic.domain.entities;

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

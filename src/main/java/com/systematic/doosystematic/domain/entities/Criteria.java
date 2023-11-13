package com.systematic.doosystematic.domain.entities;

import java.util.UUID;

public class Criteria {
    private UUID id;
    private String description;

    public Criteria(UUID id, String description) {
        this.id = id;
        this.description = description;
    }
}

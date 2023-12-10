package com.systematic.doosystematic.domain.entities;

import java.util.UUID;

public class Criteria {
    private UUID id;
    private UUID systematicReviewId;
    private String description;
    private boolean type;

    public Criteria(UUID id, UUID systematicReviewId, String description, boolean type) {
        this.id = id;
        this.systematicReviewId = systematicReviewId;
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

    public UUID getSystematicReviewId() {
        return systematicReviewId;
    }

    public void setSystematicReviewId(UUID systematicReviewId) {
        this.systematicReviewId = systematicReviewId;
    }
}

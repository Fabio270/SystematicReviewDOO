package com.systematic.doosystematic.domain.entities;

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

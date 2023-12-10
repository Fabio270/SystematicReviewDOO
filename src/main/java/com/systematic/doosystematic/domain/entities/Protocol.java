package com.systematic.doosystematic.domain.entities;

import java.util.List;
import java.util.UUID;

public class Protocol {
    private UUID uuid;
    private UUID systematicReviewId;
    private String description;
    private String searchString;
    private List<Question> form;
    private List<Criteria> inclusionCriteria;
    private List<Criteria> exclusionCriteria;

    public Protocol(UUID uuid, UUID systematicReviewId, String description, String searchString, List<Question> form, List<Criteria> inclusionCriteria, List<Criteria> exclusionCriteria) {
        this.uuid = uuid;
        this.systematicReviewId = systematicReviewId;
        this.description = description;
        this.searchString = searchString;
        this.form = form;
        this.inclusionCriteria = inclusionCriteria;
        this.exclusionCriteria = exclusionCriteria;
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
}
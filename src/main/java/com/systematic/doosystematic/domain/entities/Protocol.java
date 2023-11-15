package com.systematic.doosystematic.domain.entities;

import java.util.List;
import java.util.UUID;

public class Protocol {
    private UUID uuid;
    private String description;
    private List<Base> bases;
    private String searchString;
    private List<Question> form;
    private List<Criteria> inclusionCriteria;
    private List<Criteria> exclusionCriteria;

    public Protocol(UUID uuid, String description, List<Base> bases, String searchString, List<Question> form, List<Criteria> inclusionCriteria, List<Criteria> exclusionCriteria) {
        this.uuid = uuid;
        this.description = description;
        this.bases = bases;
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

    public List<Base> getBases() {
        return bases;
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
}
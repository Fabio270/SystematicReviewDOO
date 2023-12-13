package com.systematic.doosystematic.domain.entities;

import org.bson.Document;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Protocol {
    private UUID uuid;
    private String description;
    private String searchString;
    private List<Question> form;
    private List<Criteria> inclusionCriteria;
    private List<Criteria> exclusionCriteria;

    public Protocol(UUID uuid, String description, String searchString, List<Question> form, List<Criteria> inclusionCriteria, List<Criteria> exclusionCriteria) {
        this.uuid = uuid;
        this.description = description;
        this.searchString = searchString;
        this.form = form;
        this.inclusionCriteria = inclusionCriteria;
        this.exclusionCriteria = exclusionCriteria;
    }

    public Document toJson(){
        Document document = new Document("uuid", uuid.toString());
        document.append("description", description);
        document.append("searchString", searchString);

        List<Document> formDocuments = form.stream()
                .map(Question::toJson)
                .collect(Collectors.toList());
        document.append("form", formDocuments);

        List<Document> inclusionCriteriaDocuments = inclusionCriteria.stream()
                .map(Criteria::toJson)
                .collect(Collectors.toList());
        document.append("inclusionCriteria", inclusionCriteriaDocuments);

        List<Document> exclusionCriteriaDocuments = exclusionCriteria.stream()
                .map(Criteria::toJson)
                .collect(Collectors.toList());
        document.append("exclusionCriteria", exclusionCriteriaDocuments);

        return document;
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
}
package com.systematic.doosystematic.domain.entities;

import java.util.List;
import java.util.UUID;

public class SystematicReview {
    private UUID id;
    private String name;
    private String description;
    private Protocol protocol;
    private List<StudyReview> studies;
    private List<Statistic> statistics;
    private List<Base> bases;

    public SystematicReview(UUID id, String name, String description, Protocol protocol, List<StudyReview> studies, List<Statistic> statistics, List<Base> bases) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.protocol = protocol;
        this.studies = studies;
        this.statistics = statistics;
        this.bases = bases;
    }

    public SystematicReview(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public List<StudyReview> getStudies() {
        return studies;
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public List<Base> getBases() {
        return bases;
    }
}

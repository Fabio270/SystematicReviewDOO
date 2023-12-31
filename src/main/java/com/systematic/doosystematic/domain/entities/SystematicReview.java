package com.systematic.doosystematic.domain.entities;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class SystematicReview {
    private UUID id;
    private String name;
    private String description;
    private Protocol protocol;
    private List<StudyReview> studies;
    private List<Statistic> statistics;
    private Base base;

    public SystematicReview(UUID id, String name, String description, Protocol protocol, List<StudyReview> studies, List<Statistic> statistics, Base base) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.protocol = protocol;
        this.studies = studies;
        this.statistics = statistics;
        this.base = base;
    }

    public SystematicReview(String name, String description, Base base) {
        this.name = name;
        this.description = description;
        this.base = base;
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

    public Base getBase() {
        return base;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public void setStudies(List<StudyReview> studies) {
        this.studies = studies;
    }

    public void setStatistics(List<Statistic> statistics) {
        this.statistics = statistics;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof SystematicReview that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(protocol, that.protocol) && Objects.equals(studies, that.studies) && Objects.equals(statistics, that.statistics) && Objects.equals(base, that.base);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, protocol, studies, statistics, base);
    }
}

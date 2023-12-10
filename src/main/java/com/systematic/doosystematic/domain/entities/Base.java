package com.systematic.doosystematic.domain.entities;

import java.util.UUID;

public class Base {
    private String name;
    private UUID systematicReviewId;

    public UUID getSystematicReviewId() {
        return systematicReviewId;
    }

    public void setSystematicReviewId(UUID systematicReviewId) {
        this.systematicReviewId = systematicReviewId;
    }

    private String link;


    public Base(String name, UUID systematicReviewId,String link) {
        this.name = name;
        this.systematicReviewId=systematicReviewId;
        this.link = link;
    }
    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

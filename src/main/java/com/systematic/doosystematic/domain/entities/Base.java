package com.systematic.doosystematic.domain.entities;

public class Base {
    private String name;
    private String link;

    public Base(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }
}

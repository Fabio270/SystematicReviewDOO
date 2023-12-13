package com.systematic.doosystematic.domain.entities;

import com.google.gson.annotations.Expose;
import org.bson.Document;

public class Article {

    private int id;
    private String title;
    private String resumo; // abstract é reservada pelo Java
    private String text;
    private String authors;
    private String keywords;

    public Article(int id, String title, String resumo, String text, String authors, String keywords) {
        this.id = id;
        this.title = title;
        this.resumo = resumo;
        this.text = text;
        this.authors = authors;
        this.keywords = keywords;
    }

    public Document toJson() {
        Document document = new Document("id", String.valueOf(id))
                .append("title", title)
                .append("resumo", resumo)
                .append("text", text)
                .append("authors", authors)
                .append("keywords", keywords);

        return document;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getResumo() {
        return resumo;
    }

    public String getText() {
        return text;
    }

    public String getAuthors() {
        return authors;
    }

    public String getKeywords() {
        return keywords;
    }

}

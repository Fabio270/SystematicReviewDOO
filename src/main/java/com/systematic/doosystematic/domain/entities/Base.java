package com.systematic.doosystematic.domain.entities;

import org.bson.Document;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Base {
    private String name;
    private UUID systematicReviewId;
    private List<Article> articles;

    public Base(String name, List<Article> articles) {
        this.name = name;
        this.articles = articles;
    }

    public Base(String name, UUID systematicReviewId, List<Article> articles) {
        this.name = name;
        this.systematicReviewId = systematicReviewId;
        this.articles = articles;
    }

    public Document toJson() {
        Document document = new Document("name", name)
                .append("systematicReviewId", systematicReviewId.toString());

        List<Document> articleDocuments = articles.stream()
                .map(Article::toJson)
                .collect(Collectors.toList());
        document.append("articles", articleDocuments);

        return document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getSystematicReviewId() {
        return systematicReviewId;
    }

    public void setSystematicReviewId(UUID systematicReviewId) {
        this.systematicReviewId = systematicReviewId;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}

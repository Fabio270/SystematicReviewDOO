package com.systematic.doosystematic.domain.entities;

import org.bson.Document;

public class Answer {
    private Question question;
    private String answer;

    public Answer(Question question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Document toJson() {
        Document document = new Document("question", question.toJson())
                .append("answer", answer);

        return document;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

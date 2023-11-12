package com.systematic.doosystematic.domain.entities;

public class Answer {
    private Question question;
    private String answer;

    public Answer(Question question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}

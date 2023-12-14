package com.systematic.doosystematic.domain.entities;

import java.util.UUID;

public class QuestionTextual extends Question{
    public QuestionTextual(UUID id, UUID systematicReviewId, String description) {
        super(id, systematicReviewId, description);
    }

    public QuestionTextual(UUID id, String description) {
        super(id, description);
    }



}

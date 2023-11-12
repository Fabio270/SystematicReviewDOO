package com.systematic.doosystematic.domain.entities;

import java.util.List;
import java.util.UUID;

public class QuestionPickList extends Question{
    private List<String> options;

    public QuestionPickList(UUID id, String description, List<String> options) {
        super(id, description);
        this.options = options;
    }
}

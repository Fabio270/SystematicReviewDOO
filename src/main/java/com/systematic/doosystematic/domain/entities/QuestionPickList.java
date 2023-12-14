package com.systematic.doosystematic.domain.entities;

import java.util.List;
import java.util.UUID;

public class QuestionPickList extends Question{
    private List<String> options;

    public QuestionPickList(UUID id, UUID systematicReviewId, String description, List<String> options) {
        super(id, systematicReviewId, description);
        this.options = options;
    }

    public QuestionPickList(UUID id, String description, List<String> options) {
        super(id, description);
        this.options = options;
    }

    public QuestionPickList(String description, List<String> options) {
        super(description);
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean nullOrBlankOptions(){
        for(String str: this.options){
            return str.isBlank();
        }
        return false;
    }
}

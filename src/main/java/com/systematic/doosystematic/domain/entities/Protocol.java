package com.systematic.doosystematic.domain.entities;

import java.util.List;

public class Protocol {
    String description;
    private List<Base> bases;
    private String searchString;
    private List<Question> form;
    private List<Criteria> inclusionCriteria;
    private List<Criteria> exclusionCriteria;
}
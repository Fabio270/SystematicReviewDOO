package com.systematic.doosystematic.domain.usecases.criteria;


import com.systematic.doosystematic.domain.entities.Criteria;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

import java.util.UUID;

public class CriteriaValidator extends Validator<Criteria> {

    public Notification validate(Criteria criteria) {
        Notification notification = new Notification();

        if (criteria == null){
            notification.addError("Criteria is null.");
            return notification;
        }

        if (nullOrEmpty(criteria.getDescription())) notification.addError("Description is null or empty.");

        return notification;
    }
}

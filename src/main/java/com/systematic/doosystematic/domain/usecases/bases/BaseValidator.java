package com.systematic.doosystematic.domain.usecases.bases;

import com.systematic.doosystematic.domain.entities.Base;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

public class BaseValidator extends Validator<Base> {

    public Notification validate(Base base) {
        Notification notification = new Notification();

        if (base == null){
            notification.addError("Base is null.");
            return notification;
        }

        if (nullOrEmpty(base.getName())) notification.addError("Name is null or empty.");
        if (nullOrEmpty(base.getArticles())) notification.addError("Articles is null or empty.");

        return notification;
    }
}

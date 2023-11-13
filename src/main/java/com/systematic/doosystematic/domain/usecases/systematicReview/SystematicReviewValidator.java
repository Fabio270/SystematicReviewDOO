package com.systematic.doosystematic.domain.usecases.systematicReview;

import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

public class SystematicReviewValidator extends Validator<SystematicReview> {
    @Override
    public Notification validate(SystematicReview systematicReview){
        Notification notification = new Notification();

        if (systematicReview == null){
            notification.addError("systematicReview is null.");
            return notification;
        }
        if (nullOrEmpty(systematicReview.getName())) notification.addError("Name is null or empty.");
        if (nullOrEmpty(systematicReview.getDescription())) notification.addError("Description is null or empty.");
        return null;
    }
}

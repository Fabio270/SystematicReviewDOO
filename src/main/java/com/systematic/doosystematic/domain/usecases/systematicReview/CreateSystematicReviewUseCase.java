package com.systematic.doosystematic.domain.usecases.systematicReview;

import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.utils.EntityAlreadyExistsException;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

import java.util.UUID;

public class CreateSystematicReviewUseCase {
    private SystematicReviewDao dao;

    public CreateSystematicReviewUseCase(SystematicReviewDao dao) {
        this.dao = dao;
    }

    public UUID insert(SystematicReview systematicReview){
        Validator<SystematicReview> validator = new SystematicReviewValidator();
        Notification notification = validator.validate(systematicReview);

        if (notification.hasErrors()){throw new IllegalArgumentException(notification.errorMessage());}

        if (dao.findOne(systematicReview.getId()).isPresent()){
            throw new EntityAlreadyExistsException("This systematic review already exists.");
        }

        return dao.create(systematicReview);
    }
}

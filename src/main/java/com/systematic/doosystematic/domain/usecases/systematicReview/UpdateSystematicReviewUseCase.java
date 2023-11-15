package com.systematic.doosystematic.domain.usecases.systematicReview;

import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.utils.EntityAlreadyExistsException;
import com.systematic.doosystematic.utils.EntityNotFoundException;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

import java.util.Optional;

public class UpdateSystematicReviewUseCase {

    private SystematicReviewDao dao;

    public UpdateSystematicReviewUseCase(SystematicReviewDao dao) {
        this.dao = dao;
    }
    public boolean update(SystematicReview systematicReview){
        Validator<SystematicReview> validator = new SystematicReviewValidator();
        Notification notification = validator.validate(systematicReview);

        if (notification.hasErrors()) {
            throw new IllegalArgumentException(notification.errorMessage());
        }

        Optional<SystematicReview> existingReview = dao.findOne(systematicReview.getId());
        if (existingReview.isEmpty()) {
            throw new EntityNotFoundException("Systematic review not found.");
        }

        return dao.update(systematicReview);
    }
}

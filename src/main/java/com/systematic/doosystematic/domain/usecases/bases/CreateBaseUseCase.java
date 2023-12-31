package com.systematic.doosystematic.domain.usecases.bases;

import com.systematic.doosystematic.domain.entities.Base;
import com.systematic.doosystematic.domain.usecases.systematicReview.SystematicReviewDao;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

public class CreateBaseUseCase {
    BasesDAO basesDAO;

    public CreateBaseUseCase(BasesDAO basesDAO) {
        this.basesDAO = basesDAO;
    }

    public void insert(Base base){
        Validator<Base> validator = new BaseValidator();
        Notification notification = validator.validate(base);

        if (notification.hasErrors()) throw new IllegalArgumentException(notification.errorMessage());

        basesDAO.create(base);
    }
}

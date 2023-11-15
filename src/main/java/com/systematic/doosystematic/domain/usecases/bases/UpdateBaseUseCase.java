package com.systematic.doosystematic.domain.usecases.bases;

import com.systematic.doosystematic.domain.entities.Base;
import com.systematic.doosystematic.domain.usecases.systematicReview.SystematicReviewDao;
import com.systematic.doosystematic.utils.EntityNotFoundException;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

public class UpdateBaseUseCase {
    BasesDAO basesDAO;

    public UpdateBaseUseCase(BasesDAO basesDAO) {
        this.basesDAO = basesDAO;
    }

    public boolean update(Base base){
        Validator<Base> validator = new BaseValidator();
        Notification notification = validator.validate(base);

        if (notification.hasErrors()) throw new IllegalArgumentException(notification.errorMessage());
        String name = base.getName();
        if (basesDAO.findOne(name).isEmpty())throw new EntityNotFoundException("Base not found");

        return basesDAO.update(base);
    }
}

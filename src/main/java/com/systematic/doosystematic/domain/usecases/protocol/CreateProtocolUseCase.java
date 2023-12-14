package com.systematic.doosystematic.domain.usecases.protocol;

import com.systematic.doosystematic.domain.entities.Protocol;
import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.domain.usecases.systematicReview.SystematicReviewDao;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

public class CreateProtocolUseCase {
    private SystematicReviewDao dao;

    public CreateProtocolUseCase(SystematicReviewDao dao) {
        this.dao = dao;
    }

    public void insert(SystematicReview systematicReview, Protocol protocol){
        Validator<Protocol> validator = new ProtocolValidator();
        Notification notification = validator.validate(protocol);

        if (notification.hasErrors()) throw new IllegalArgumentException(notification.errorMessage());
        systematicReview.setProtocol(protocol);
        dao.assingProtocol(systematicReview);
    }
}

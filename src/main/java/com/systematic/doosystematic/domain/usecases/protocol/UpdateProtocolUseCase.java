package com.systematic.doosystematic.domain.usecases.protocol;

import com.systematic.doosystematic.domain.entities.Protocol;
import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.domain.usecases.systematicReview.SystematicReviewDao;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

public class UpdateProtocolUseCase {

    private SystematicReviewDao dao;

    public UpdateProtocolUseCase(SystematicReviewDao dao) {
        this.dao = dao;
    }

    public boolean update(SystematicReview systematicReview, Protocol newProtocol){
        Validator<Protocol> validator = new ProtocolValidator();
        Notification notification = validator.validate(newProtocol);

        if (notification.hasErrors()) {
            throw new IllegalArgumentException();
        }

        systematicReview.setProtocol(newProtocol);

        return dao.assingProtocol(systematicReview.getProtocol());
    }
}


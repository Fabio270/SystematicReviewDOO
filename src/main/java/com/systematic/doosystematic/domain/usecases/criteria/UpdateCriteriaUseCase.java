package com.systematic.doosystematic.domain.usecases.criteria;

import com.systematic.doosystematic.domain.entities.Criteria;
import com.systematic.doosystematic.domain.entities.CriteriaType;
import com.systematic.doosystematic.domain.entities.Protocol;
import com.systematic.doosystematic.domain.usecases.protocol.ProtocolDao;
import com.systematic.doosystematic.utils.EntityNotFoundException;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

public class UpdateCriteriaUseCase {

    private ProtocolDao dao;

    public UpdateCriteriaUseCase(ProtocolDao dao) {
        this.dao = dao;
    }

    public boolean update(Protocol protocol, Criteria criteria){
        Validator<Criteria> validator = new CriteriaValidator();
        Notification notification = validator.validate(criteria);

        if (notification.hasErrors()) {
            throw new IllegalArgumentException();
        }

        if (criteria.getType() == CriteriaType.INCLUSION){
            protocol.getInclusionCriteria().remove(criteria);
            protocol.getInclusionCriteria().add(criteria);
        }
        else{
            protocol.getExclusionCriteria().remove(criteria);
            protocol.getExclusionCriteria().add(criteria);
        }

        return dao.update(protocol);
    }
}


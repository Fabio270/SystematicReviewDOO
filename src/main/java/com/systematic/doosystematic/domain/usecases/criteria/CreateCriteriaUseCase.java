package com.systematic.doosystematic.domain.usecases.criteria;

import com.systematic.doosystematic.domain.entities.Criteria;
import com.systematic.doosystematic.domain.entities.CriteriaType;
import com.systematic.doosystematic.domain.usecases.protocol.ProtocolDao;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

public class CreateCriteriaUseCase {
    private ProtocolDao dao;

    public CreateCriteriaUseCase(ProtocolDao dao) {
        this.dao = dao;
    }

    public void insert(Criteria criteria){
        Validator<Criteria> validator = new CriteriaValidator();
        Notification notification = validator.validate(criteria);

        if (notification.hasErrors()) throw new IllegalArgumentException();

        if (criteria.getType() == CriteriaType.INCLUSION){
            dao.addInclusionCriteria(criteria);
        }
        else {
            dao.addExclusionCriteria(criteria);
        }
    }
}

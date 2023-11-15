package com.systematic.doosystematic.domain.usecases.criteria;

import com.systematic.doosystematic.domain.entities.Criteria;
import com.systematic.doosystematic.domain.usecases.protocol.ProtocolDao;
import com.systematic.doosystematic.utils.EntityNotFoundException;

import java.util.Optional;
import java.util.UUID;

public class DeleteCriteriaUseCase {
    private ProtocolDao dao;

    public DeleteCriteriaUseCase(ProtocolDao dao) { this.dao = dao; }

    public boolean delete(UUID criteriaId) {
        Optional<Criteria> optCriteria = dao.findOneCriteria(criteriaId);
        if (optCriteria.isEmpty())
            throw new EntityNotFoundException("Criteria not found");
        return dao.deleteCriteria(optCriteria.get());
    }

}

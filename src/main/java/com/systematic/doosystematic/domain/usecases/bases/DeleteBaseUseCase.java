package com.systematic.doosystematic.domain.usecases.bases;

import com.systematic.doosystematic.domain.entities.Base;
import com.systematic.doosystematic.domain.entities.Criteria;
import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.domain.usecases.systematicReview.SystematicReviewDao;
import com.systematic.doosystematic.utils.EntityNotFoundException;

import java.util.Optional;
import java.util.UUID;

public class DeleteBaseUseCase {
    SystematicReviewDao dao;

    public DeleteBaseUseCase(SystematicReviewDao dao) { this.dao = dao; }

    public boolean delete(String baseName, SystematicReview systematicReview) {
        Optional<Base> optBase = dao.findOneBase(baseName);
        if (optBase.isEmpty())
            throw new EntityNotFoundException("Criteria not found");
        systematicReview.getBases().remove(optBase);
        return dao.deleteBase(systematicReview);
    }
}

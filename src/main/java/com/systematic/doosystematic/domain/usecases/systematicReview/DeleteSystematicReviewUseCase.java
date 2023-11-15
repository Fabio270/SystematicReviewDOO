package com.systematic.doosystematic.domain.usecases.systematicReview;

import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.utils.EntityNotFoundException;

import java.util.Optional;
import java.util.UUID;

public class DeleteSystematicReviewUseCase {

    private SystematicReviewDao dao;

    public DeleteSystematicReviewUseCase(SystematicReviewDao dao ) { this.dao = dao; }

    public boolean delete(UUID systematicReviewId) {
        Optional<SystematicReview> optSystematicReview = dao.findOne(systematicReviewId);
        if (optSystematicReview.isEmpty())
            throw new EntityNotFoundException("Systematic Review not found");
        return dao.delete(optSystematicReview.get());
    }
}

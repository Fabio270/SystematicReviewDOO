package com.systematic.doosystematic.domain.usecases.studyReview;

import com.systematic.doosystematic.domain.entities.Criteria;
import com.systematic.doosystematic.domain.entities.StudyReview;
import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.domain.usecases.systematicReview.SystematicReviewDao;
import com.systematic.doosystematic.utils.EntityNotFoundException;

import java.util.Optional;
import java.util.UUID;

public class DeleteStudyReviewUseCase {

    private SystematicReviewDao dao;

    public DeleteStudyReviewUseCase(SystematicReviewDao dao){
        this.dao = dao;
    }

    public boolean delete(UUID studyReviewId, SystematicReview systematicReview) {
        Optional<StudyReview> optStudyReview = dao.findOneStudyReview(studyReviewId);
        if (optStudyReview.isEmpty())
            throw new EntityNotFoundException("Study Review not found");
        systematicReview.getStudies().remove(optStudyReview);
        return dao.deleteStudyReview(systematicReview);
    }
}

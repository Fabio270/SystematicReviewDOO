package com.systematic.doosystematic.domain.usecases.studyReview;

import com.systematic.doosystematic.domain.entities.StudyReview;
import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.domain.usecases.protocol.ProtocolValidator;
import com.systematic.doosystematic.domain.usecases.systematicReview.SystematicReviewDao;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

import java.util.List;

public class UpdateStudyReviewUseCase {

    private SystematicReviewDao dao;

    public UpdateStudyReviewUseCase(SystematicReviewDao dao) {
        this.dao = dao;
    }

    public boolean update(SystematicReview systematicReview, StudyReview studyReview){
        Validator<StudyReview> validator = new StudyReviewValidator();
        Notification notification = validator.validate(studyReview);

        if (notification.hasErrors()) {
            throw new IllegalArgumentException("Invalid study review");
        }

        List<StudyReview> studies = systematicReview.getStudies();

        studies.add(studyReview);

        systematicReview.setStudies(studies);

        return dao.addStudyReview(studyReview);
    }
}


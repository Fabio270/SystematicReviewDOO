package com.systematic.doosystematic.domain.usecases.studyReview;

import com.systematic.doosystematic.domain.entities.StudyReview;
import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.domain.usecases.systematicReview.SystematicReviewDao;
import com.systematic.doosystematic.utils.EntityAlreadyExistsException;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

import java.util.UUID;

public class CreateStudyReviewUseCase {
    private SystematicReviewDao dao;

    public CreateStudyReviewUseCase(SystematicReviewDao dao){
        this.dao = dao;
    }

    public void insert(StudyReview studyReview, SystematicReview systematicReview){
        Validator<StudyReview> validator = new StudyReviewValidator();
        Notification notification = validator.validate(studyReview);

        if (notification.hasErrors()){throw new IllegalArgumentException(notification.errorMessage());}

        systematicReview.getStudies().add(studyReview);

        dao.addStudyReview(systematicReview);


    }
}

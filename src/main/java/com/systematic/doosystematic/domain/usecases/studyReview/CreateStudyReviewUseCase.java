package com.systematic.doosystematic.domain.usecases.studyReview;

import com.systematic.doosystematic.domain.entities.StudyReview;
import com.systematic.doosystematic.utils.EntityAlreadyExistsException;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

import java.util.UUID;

public class CreateStudyReviewUseCase {
    private StudyReviewDao dao;

    public CreateStudyReviewUseCase(StudyReviewDao dao){
        this.dao = dao;
    }

    public UUID insert(StudyReview studyReview){
        Validator<StudyReview> validator = new StudyReviewValidator();
        Notification notification = validator.validate(studyReview);

        if (notification.hasErrors()){throw new IllegalArgumentException(notification.errorMessage());}

        if (dao.findStudyByTitle(studyReview.getTitle()).isPresent()){
            throw new EntityAlreadyExistsException("This Study already exists.");
        }
        return dao.create(studyReview);
    }
}

package com.systematic.doosystematic.domain.usecases.studyReview;

import com.systematic.doosystematic.domain.entities.StudyReview;
import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

public class StudyReviewValidator extends Validator<StudyReview> {
    public Notification validate(StudyReview studyReview){
        Notification notification = new Notification();

        if (studyReview == null){
            notification.addError("studyReview is null.");
            return notification;
        }
        if (studyReview.getArticle() == null) {
            notification.addError("Article is null or empty.");
        }


        return null;
    }
}

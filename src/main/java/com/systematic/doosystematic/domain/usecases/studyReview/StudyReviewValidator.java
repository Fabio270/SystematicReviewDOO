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
        if (nullOrEmpty(studyReview.getTitle())) notification.addError("Title is null or empty.");
        if (nullOrEmpty(studyReview.getResumo())) notification.addError("Abstract is null or empty.");
        if (nullOrEmpty(studyReview.getText())) notification.addError("Text is null or empty.");
        if (nullOrEmpty(studyReview.getAuthors())) notification.addError("Authors is null or empty.");
        if (nullOrEmpty(studyReview.getKeywords())) notification.addError("Keywords is null or empty.");
        if (studyReview.getBases().isEmpty()) notification.addError("Bases are empty.");


        return null;
    }
}

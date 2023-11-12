package com.systematic.doosystematic.domain.usecases.Question;

import com.systematic.doosystematic.domain.entities.QuestionTextual;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

public class QuestionTextualValidator extends Validator<QuestionTextual> {

    public Notification validate(QuestionTextual question) {
        Notification notification = new Notification();

        if (question == null) {
            notification.addError("Question is null.");
            return notification;
        }

        if (nullOrEmpty(question.getDescription())){
            notification.addError("Question description ir null or empty.");
        }

        return null;
    }
}

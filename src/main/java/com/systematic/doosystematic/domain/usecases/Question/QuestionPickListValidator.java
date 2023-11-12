package com.systematic.doosystematic.domain.usecases.Question;

import com.systematic.doosystematic.domain.entities.QuestionPickList;
import com.systematic.doosystematic.domain.entities.QuestionTextual;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

public class QuestionPickListValidator extends Validator<QuestionPickList> {
    public Notification validate(QuestionPickList question) {
        Notification notification = new Notification();

        if (question == null) {
            notification.addError("Question is null.");
            return notification;
        }

        if (nullOrEmpty(question.getDescription())){
            notification.addError("Question description ir null or empty.");
        }
        if (question.getOptions().isEmpty()){
            notification.addError("There are no options available.");
        }
        if (question.nullOrBlankOptions()){
            notification.addError("PickList option is null or blank.");
        }

        return null;
    }
}

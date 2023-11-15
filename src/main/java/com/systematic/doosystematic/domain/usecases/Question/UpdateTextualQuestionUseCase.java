package com.systematic.doosystematic.domain.usecases.Question;

import com.systematic.doosystematic.domain.entities.Protocol;
import com.systematic.doosystematic.domain.entities.QuestionPickList;
import com.systematic.doosystematic.domain.usecases.protocol.ProtocolDao;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

public class UpdateTextualQuestionUseCase {
    private ProtocolDao dao;

    public UpdateTextualQuestionUseCase(ProtocolDao dao) {
        this.dao = dao;
    }

    public void update(Protocol protocol, QuestionPickList question){
        Validator<QuestionPickList> validator = new QuestionPickListValidator();
        Notification notification = validator.validate(question);

        if (notification.hasErrors()){throw  new IllegalArgumentException(notification.errorMessage());}

        dao.update(protocol);
    }
}

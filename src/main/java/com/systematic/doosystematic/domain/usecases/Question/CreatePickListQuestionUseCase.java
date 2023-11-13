package com.systematic.doosystematic.domain.usecases.Question;


import com.systematic.doosystematic.domain.entities.Question;
import com.systematic.doosystematic.domain.entities.QuestionPickList;
import com.systematic.doosystematic.domain.usecases.protocol.ProtocolDao;
import com.systematic.doosystematic.utils.EntityAlreadyExistsException;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

import java.util.UUID;

public class CreatePickListQuestionUseCase {
    private ProtocolDao dao;

    public CreatePickListQuestionUseCase(ProtocolDao dao) {
        this.dao = dao;
    }

    public void insert(QuestionPickList question){
        Validator<QuestionPickList> validator = new QuestionPickListValidator();
        Notification notification = validator.validate(question);

        if (notification.hasErrors()){throw  new IllegalArgumentException(notification.errorMessage());}

        if (dao.findOne(question.getId()).isPresent())
            throw new EntityAlreadyExistsException("This question already exists.");

        dao.addQuestion(question);
    }
}

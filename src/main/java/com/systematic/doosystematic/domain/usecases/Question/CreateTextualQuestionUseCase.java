package com.systematic.doosystematic.domain.usecases.Question;

import com.systematic.doosystematic.domain.entities.QuestionPickList;
import com.systematic.doosystematic.domain.entities.QuestionTextual;
import com.systematic.doosystematic.domain.usecases.protocol.ProtocolDao;
import com.systematic.doosystematic.utils.EntityAlreadyExistsException;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

import java.util.UUID;

public class CreateTextualQuestionUseCase {
    private ProtocolDao dao;

    public CreateTextualQuestionUseCase(ProtocolDao dao) {
        this.dao = dao;
    }

    public void insert(QuestionTextual question){
        Validator<QuestionTextual> validator = new QuestionTextualValidator();
        Notification notification = validator.validate(question);

        if (notification.hasErrors()){throw  new IllegalArgumentException(notification.errorMessage());}

        if (dao.findOne(question.getId()).isPresent())
            throw new EntityAlreadyExistsException("This question already exists.");

        dao.addQuestion(question);
    }
}

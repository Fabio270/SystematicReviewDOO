package com.systematic.doosystematic.domain.usecases.Question;

import com.systematic.doosystematic.domain.entities.Question;
import com.systematic.doosystematic.domain.entities.StudyReview;
import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.domain.usecases.protocol.ProtocolDao;
import com.systematic.doosystematic.utils.EntityNotFoundException;

import java.util.Optional;
import java.util.UUID;

public class DeleteQuestionUseCase {

    private ProtocolDao dao;

    public DeleteQuestionUseCase(ProtocolDao dao) {
        this.dao = dao;
    }

    public boolean delete(UUID questionId) {
        Optional<Question> optQuestion = dao.findOneQuestion(questionId);
        if (optQuestion.isEmpty())
            throw new EntityNotFoundException("Question not found");
        return dao.deleteQuestion(optQuestion.get());
    }
}

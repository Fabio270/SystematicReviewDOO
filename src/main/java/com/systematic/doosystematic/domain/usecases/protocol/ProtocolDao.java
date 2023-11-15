package com.systematic.doosystematic.domain.usecases.protocol;

import com.systematic.doosystematic.domain.entities.Criteria;
import com.systematic.doosystematic.domain.entities.Protocol;
import com.systematic.doosystematic.domain.entities.Question;
import com.systematic.doosystematic.utils.DAO;

import java.util.Optional;
import java.util.UUID;

public interface ProtocolDao extends DAO<Protocol, UUID> {
    boolean addQuestion(Question question);
    boolean addExclusionCriteria(Criteria criteria);
    boolean addInclusionCriteria(Criteria criteria);
    boolean deleteCriteria(Criteria criteria);
    Optional<Criteria> findOneCriteria(UUID criteriaId);
    boolean deleteQuestion(Question question);
    Optional<Question> findOneQuestion(UUID questionId);
}

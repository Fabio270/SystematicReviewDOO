package com.systematic.doosystematic.domain.usecases.protocol;

import com.systematic.doosystematic.domain.entities.Protocol;
import com.systematic.doosystematic.domain.entities.Question;
import com.systematic.doosystematic.utils.DAO;

import java.util.UUID;

public interface ProtocolDao extends DAO<Protocol, UUID> {
    boolean addQuestion(Question question);
}

package com.systematic.doosystematic.repository;


import com.systematic.doosystematic.domain.entities.Criteria;
import com.systematic.doosystematic.domain.entities.Protocol;
import com.systematic.doosystematic.domain.entities.Question;
import com.systematic.doosystematic.domain.usecases.protocol.ProtocolDao;

import java.util.*;

public class MockProtocolDAO implements ProtocolDao {

    private static final Map<UUID, Protocol> db = new LinkedHashMap<>();

    @Override
    public boolean addQuestion(Question question) {
        return false;
    }

    @Override
    public boolean addExclusionCriteria(Criteria criteria) {
        return false;
    }

    @Override
    public boolean addInclusionCriteria(Criteria criteria) {
        return false;
    }

    @Override
    public UUID create(Protocol type) {
        return null;
    }

    @Override
    public Optional<Protocol> findOne(UUID key) {
        return Optional.empty();
    }

    @Override
    public List<Protocol> findAll() {
        return null;
    }

    @Override
    public boolean update(Protocol type) {
        return false;
    }

    @Override
    public boolean deleteById(UUID key) {
        return false;
    }

    @Override
    public boolean delete(Protocol type) {
        return false;
    }
}

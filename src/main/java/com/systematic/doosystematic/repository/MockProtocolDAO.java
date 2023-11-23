package com.systematic.doosystematic.repository;


import com.systematic.doosystematic.domain.entities.Criteria;
import com.systematic.doosystematic.domain.entities.Protocol;
import com.systematic.doosystematic.domain.entities.Question;
import com.systematic.doosystematic.domain.usecases.protocol.ProtocolDao;
import com.systematic.doosystematic.utils.UUIDGeneratorService;

import java.util.*;

public class MockProtocolDAO implements ProtocolDao {

    private static final Map<UUID, Protocol> db = new LinkedHashMap<>();
    UUIDGeneratorService uuid = new UUIDGeneratorService();

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
    public boolean deleteCriteria(Criteria criteria) {
        return false;
    }

    @Override
    public Optional<Criteria> findOneCriteria(UUID criteriaId) {
        return Optional.empty();
    }

    @Override
    public boolean deleteQuestion(Question question) {
        return false;
    }

    @Override
    public Optional<Question> findOneQuestion(UUID questionId) {
        return Optional.empty();
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

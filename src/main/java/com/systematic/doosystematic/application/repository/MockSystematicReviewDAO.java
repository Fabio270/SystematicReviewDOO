//package com.systematic.doosystematic.repository;
//
//import com.systematic.doosystematic.domain.entities.Base;
//import com.systematic.doosystematic.domain.entities.Protocol;
//import com.systematic.doosystematic.domain.entities.StudyReview;
//import com.systematic.doosystematic.domain.entities.SystematicReview;
//import com.systematic.doosystematic.domain.usecases.bases.BasesDAO;
//import com.systematic.doosystematic.domain.usecases.systematicReview.SystematicReviewDao;
//
//import java.util.*;
//
//public class MockSystematicReviewDAO implements SystematicReviewDao {
//
//
//    @Override
//    public boolean assingProtocol(Protocol protocol) {
//        return false;
//    }
//
//    @Override
//    public boolean addStudyReview(StudyReview studyReview) {
//        return false;
//    }
//
//    @Override
//    public boolean addBase(Base base) {
//        return false;
//    }
//
//    @Override
//    public boolean deleteStudyReview(StudyReview studyReview) {
//        return false;
//    }
//
//    @Override
//    public Optional<StudyReview> findOneStudyReview(UUID studyReviewId) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean deleteBase(Base base) {
//        return false;
//    }
//
//    @Override
//    public Optional<Base> findOneBase(String baseName) {
//        return Optional.empty();
//    }
//
//    @Override
//    public UUID create(SystematicReview type) {
//        return null;
//    }
//
//    @Override
//    public Optional<SystematicReview> findOne(UUID key) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<SystematicReview> findAll() {
//        return null;
//    }
//
//    @Override
//    public boolean update(SystematicReview type) {
//        return false;
//    }
//
//    @Override
//    public boolean deleteById(UUID key) {
//        return false;
//    }
//
//    @Override
//    public boolean delete(SystematicReview type) {
//        return false;
//    }
//}

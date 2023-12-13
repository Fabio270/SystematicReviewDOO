package com.systematic.doosystematic.domain.usecases.systematicReview;

import com.systematic.doosystematic.domain.entities.*;
import com.systematic.doosystematic.utils.DAO;

import java.util.Optional;
import java.util.UUID;

public interface SystematicReviewDao extends DAO<SystematicReview, UUID>{
    boolean assingProtocol(SystematicReview systematicReview);
    boolean addStudyReview(StudyReview studyReview);
    boolean addBase(Base base);
    boolean deleteStudyReview(StudyReview studyReview);
    Optional<StudyReview> findOneStudyReview(UUID studyReviewId);

    boolean deleteBase(Base base);
    Optional<Base> findOneBase(String baseName);
}

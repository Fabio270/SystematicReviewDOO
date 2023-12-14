package com.systematic.doosystematic.domain.usecases.systematicReview;

import com.systematic.doosystematic.domain.entities.*;
import com.systematic.doosystematic.utils.DAO;

import java.util.Optional;
import java.util.UUID;

public interface SystematicReviewDao extends DAO<SystematicReview, UUID>{
    boolean assingProtocol(SystematicReview systematicReview);

    boolean addStudyReview(SystematicReview systematicReview);

    boolean addBase(SystematicReview systematicReview);
    boolean deleteStudyReview(SystematicReview systematicReview);

    Optional<StudyReview> findOneStudyReview(UUID studyReviewId);

    boolean deleteBase(SystematicReview systematicReview);
    Optional<Base> findOneBase(String baseName);
}

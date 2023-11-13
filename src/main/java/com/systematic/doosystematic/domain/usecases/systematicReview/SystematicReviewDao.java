package com.systematic.doosystematic.domain.usecases.systematicReview;

import com.systematic.doosystematic.domain.entities.Protocol;
import com.systematic.doosystematic.domain.entities.StudyReview;
import com.systematic.doosystematic.domain.entities.SystematicReview;
import com.systematic.doosystematic.utils.DAO;

import java.util.UUID;

public interface SystematicReviewDao extends DAO<SystematicReview, UUID>{
    boolean assingProtocol(Protocol protocol);
    boolean addStudyReview(StudyReview studyReview);
}

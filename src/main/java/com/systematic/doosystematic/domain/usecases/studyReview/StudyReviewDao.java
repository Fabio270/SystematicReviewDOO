package com.systematic.doosystematic.domain.usecases.studyReview;

import com.systematic.doosystematic.domain.entities.StudyReview;
import com.systematic.doosystematic.utils.DAO;

import java.util.Optional;
import java.util.UUID;

public interface StudyReviewDao extends DAO<StudyReview, UUID> {
    Optional<StudyReview> findStudyByTitle(String title);
}

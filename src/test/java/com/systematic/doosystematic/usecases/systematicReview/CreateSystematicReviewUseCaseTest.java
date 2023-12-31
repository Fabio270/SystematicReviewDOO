package com.systematic.doosystematic.usecases.systematicReview;

import com.mongodb.client.MongoClient;
import com.systematic.doosystematic.domain.entities.*;
import com.systematic.doosystematic.application.repository.MongoDb.MongoConnectionFactory;
import com.systematic.doosystematic.application.repository.MongoDb.MongoSystematicReviewDAO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CreateSystematicReviewUseCaseTest {

    @Test
    void name() {
        Question question1 = new QuestionPickList(UUID.randomUUID(), UUID.randomUUID(),"test1?", List.of("a","b","c"));
        Question question2 = new QuestionTextual(UUID.randomUUID(), UUID.randomUUID(), "test12");

        List<Question> list = List.of(question1, question2);

        Criteria criteria1 = new Criteria(UUID.randomUUID(), "blabla", CriteriaType.EXCLUSION);
        List<Criteria> listCriteria1 = List.of(criteria1);
        Criteria criteria2 = new Criteria(UUID.randomUUID(), "blabla", CriteriaType.INCLUSION);
        List<Criteria> listCriteria2 = List.of(criteria2);

        Article article = new Article(1, "oooo", "oooooooo", "aaaaa", "aaaaa", "aaaaaaaaaaaa");
        List<Article> articleList = List.of(article);
        Base base1 = new Base("NAMEBASE", UUID.randomUUID(), articleList);

        StudyReview studyReview = new StudyReview(UUID.randomUUID(), article);
        studyReview.setAnswers(List.of(new Answer(question2, "aaaaaaa ")));
        List<StudyReview> studyReviewList = List.of(studyReview);

        List<Statistic> statisticList = List.of(new Statistic());
        Protocol protocol = new Protocol(UUID.randomUUID(),"testing protocol", "testing description", "testing searchString", list, listCriteria2, listCriteria1);
        protocol.setSystematicReviewId(UUID.randomUUID());
        SystematicReview systematicReview = new SystematicReview(UUID.randomUUID(), "test", "testing", protocol, studyReviewList, statisticList, base1);

        MongoSystematicReviewDAO mongoDAO = new MongoSystematicReviewDAO();
        mongoDAO.create(systematicReview);

    }


}
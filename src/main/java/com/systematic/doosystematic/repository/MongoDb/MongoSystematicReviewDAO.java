package com.systematic.doosystematic.repository.MongoDb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.systematic.doosystematic.domain.entities.*;
import com.systematic.doosystematic.domain.usecases.systematicReview.SystematicReviewDao;
import com.systematic.doosystematic.utils.DAO;
import org.bson.Document;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class MongoSystematicReviewDAO implements SystematicReviewDao {

    @Override
    public boolean assingProtocol(SystematicReview systematicReview) {
        return false;
    }

    @Override
    public boolean addStudyReview(StudyReview studyReview) {
        return false;
    }

    @Override
    public boolean addBase(Base base) {
        return false;
    }

    @Override
    public boolean deleteStudyReview(StudyReview studyReview) {
        return false;
    }

    @Override
    public Optional<StudyReview> findOneStudyReview(UUID studyReviewId) {
        return Optional.empty();
    }

    @Override
    public boolean deleteBase(Base base) {
        return false;
    }

    @Override
    public Optional<Base> findOneBase(String baseName) {
        return Optional.empty();
    }

    @Override
    public UUID create(SystematicReview systematicReview) {
            MongoClient mongoClient = MongoConnectionFactory.getMongoClient();
            MongoDatabase database = mongoClient.getDatabase("systematic");
            MongoCollection<Document> collection = database.getCollection("systematicreview");

        Document document = new Document("id", systematicReview.getId().toString())
                .append("name", systematicReview.getName())
                .append("description", systematicReview.getDescription())
                .append("protocol", systematicReview.getProtocol().toJson());

        List<Document> studiesDocuments = systematicReview.getStudies().stream()
                .map(StudyReview::toJson)
                .collect(Collectors.toList());
        document.append("studies", studiesDocuments);

//        List<Document> statisticsDocuments = systematicReview.getStatistics().stream()
//                .map(Statistic::toJson)
//                .collect(Collectors.toList());
//        document.append("statistics", statisticsDocuments);

        List<Document> basesDocuments = systematicReview.getBases().stream()
                .map(Base::toJson)
                .collect(Collectors.toList());
        document.append("bases", basesDocuments);
        collection.insertOne(document);

        return systematicReview.getId();
    }

    @Override
    public Optional<SystematicReview> findOne(UUID key) {
        return Optional.empty();
    }

    @Override
    public List<SystematicReview> findAll() {
        return null;
    }

    @Override
    public boolean update(SystematicReview type) {
        return false;
    }

    @Override
    public boolean deleteById(UUID key) {
        return false;
    }

    @Override
    public boolean delete(SystematicReview type) {
        return false;
    }
}

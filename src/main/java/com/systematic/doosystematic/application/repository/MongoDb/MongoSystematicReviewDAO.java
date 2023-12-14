package com.systematic.doosystematic.application.repository.MongoDb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.systematic.doosystematic.application.repository.MongoDb.MongoConnectionFactory;
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
        MongoClient mongoClient = MongoConnectionFactory.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("systematic");
        MongoCollection<Document> collection = database.getCollection("systematicreview");

        Document filter = new Document("id", systematicReview.getId().toString());

        Document update = new Document("$set", new Document()
                .append("protocol", systematicReview.getProtocol().toJson())
        );

        UpdateResult updateResult = collection.updateOne(filter, update);
        return updateResult.wasAcknowledged() && updateResult.getModifiedCount() > 0;
    }

    @Override
    public boolean addStudyReview(SystematicReview systematicReview) {
        MongoClient mongoClient = MongoConnectionFactory.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("systematic");
        MongoCollection<Document> collection = database.getCollection("systematicreview");

        List<Document> studiesDocuments = systematicReview.getStudies().stream()
                .map(StudyReview::toJson)
                .collect(Collectors.toList());

        Document filter = new Document("id", systematicReview.getId().toString());

        Document update = new Document("$set", new Document()
                .append("studies", studiesDocuments)
        );

        UpdateResult updateResult = collection.updateOne(filter, update);
        return updateResult.wasAcknowledged() && updateResult.getModifiedCount() > 0;
    }

    @Override
    public boolean addBase(SystematicReview systematicReview) {
        MongoClient mongoClient = MongoConnectionFactory.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("systematic");
        MongoCollection<Document> collection = database.getCollection("systematicreview");

        Document base = systematicReview.getBase().toJson();

        Document filter = new Document("id", systematicReview.getId().toString());

        Document update = new Document("$set", new Document()
                .append("base", base)
        );

        UpdateResult updateResult = collection.updateOne(filter, update);
        return updateResult.wasAcknowledged() && updateResult.getModifiedCount() > 0;
    }

    @Override
    public boolean deleteStudyReview(SystematicReview systematicReview) {
        MongoClient mongoClient = MongoConnectionFactory.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("systematic");
        MongoCollection<Document> collection = database.getCollection("systematicreview");

        List<Document> studiesDocuments = systematicReview.getStudies().stream()
                .map(StudyReview::toJson)
                .collect(Collectors.toList());

        Document filter = new Document("id", systematicReview.getId().toString());

        Document update = new Document("$set", new Document()
                .append("studies", studiesDocuments)
        );

        UpdateResult updateResult = collection.updateOne(filter, update);
        return updateResult.wasAcknowledged() && updateResult.getModifiedCount() > 0;
    }

    @Override
    public Optional<StudyReview> findOneStudyReview(UUID studyReviewId) {
        return Optional.empty();
    }

    @Override
    public boolean deleteBase(SystematicReview systematicReview) {
        MongoClient mongoClient = MongoConnectionFactory.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("systematic");
        MongoCollection<Document> collection = database.getCollection("systematicreview");

        Document base = systematicReview.getBase().toJson();

        Document filter = new Document("id", systematicReview.getId().toString());

        Document update = new Document("$set", new Document()
                .append("base", base)
        );

        UpdateResult updateResult = collection.updateOne(filter, update);
        return updateResult.wasAcknowledged() && updateResult.getModifiedCount() > 0;
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

        document.append("bases", systematicReview.getBase());
        collection.insertOne(document);

        return systematicReview.getId();
    }

    @Override
    public Optional<SystematicReview> findOne(UUID key) {
//        MongoClient mongoClient = MongoConnectionFactory.getMongoClient();
//        MongoDatabase database = mongoClient.getDatabase("systematic");
//        MongoCollection<Document> collection = database.getCollection("systematicreview");
//
//
//        Document found = (Document) collection.find(new Document("id", key.toString())).first();
//        if (found != null){
//            SystematicReview systematicReview = (SystematicReview) new SystematicReview(UUID.fromString(found.getString("id")),
//                    found.getString("name"),
//                    found.getString("description"));
//
//            systematicReview.setProtocol();
//
//
//        }
        return Optional.empty();
    }

    @Override
    public List<SystematicReview> findAll() {
        return null;
    }

    @Override
    public boolean update(SystematicReview systematicReview) {
        MongoClient mongoClient = MongoConnectionFactory.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("systematic");
        MongoCollection<Document> collection = database.getCollection("systematicreview");

        List<Document> studiesDocuments = systematicReview.getStudies().stream()
                .map(StudyReview::toJson)
                .collect(Collectors.toList());

//        List<Document> statisticsDocuments = systematicReview.getStatistics().stream()
//                .map(Statistic::toJson)
//                .collect(Collectors.toList());
//        document.append("statistics", statisticsDocuments);

        Document base = systematicReview.getBase().toJson();

        Document filter = new Document("id", systematicReview.getId().toString());

        Document update = new Document("$set", new Document()
                .append("name", systematicReview.getName())
                .append("description", systematicReview.getDescription())
                .append("protocol", systematicReview.getProtocol().toJson())
                .append("studies", studiesDocuments)
                .append("base", base)
        );

        UpdateResult updateResult = collection.updateOne(filter, update);
        return updateResult.wasAcknowledged() && updateResult.getModifiedCount() > 0;
    }

    @Override
    public boolean deleteById(UUID key) {
        MongoClient mongoClient = MongoConnectionFactory.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("systematic");
        MongoCollection<Document> collection = database.getCollection("systematicreview");

        Document filter = new Document("id", key.toString());
        DeleteResult deleteResult = collection.deleteOne(filter);

        return  deleteResult.wasAcknowledged() && deleteResult.getDeletedCount() > 0;
    }

    @Override
    public boolean delete(SystematicReview systematicReview) {
        MongoClient mongoClient = MongoConnectionFactory.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("systematic");
        MongoCollection<Document> collection = database.getCollection("systematicreview");

        Document filter = new Document("id", systematicReview.getId().toString());
        DeleteResult deleteResult = collection.deleteOne(filter);

        return  deleteResult.wasAcknowledged() && deleteResult.getDeletedCount() > 0;
    }
}

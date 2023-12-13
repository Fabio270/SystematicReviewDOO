package com.systematic.doosystematic.connection;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;

public class QuickStart {
    public static void main( String[] args ) {

        // Replace the placeholder with your MongoDB deployment's connection string


        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("systematic");
            MongoCollection<Document> collection = database.getCollection("systematicreview");

//            Document document = new Document("name","Daeshan");
//            document.append("sex", "male");
//            document.append("age", "21");
//            document.append("Race","asian");

//            collection.insertOne(document);
//            Document found = (Document) collection.find(new Document("name","Steven")).first();
//            if (found!=null){
//                System.out.println("Found user");
//
//                Bson updatedvalue = new Document("age", 46);
//                Bson updateoperation = new Document("$set", updatedvalue);
//                collection.updateOne(found, updateoperation);
//                System.out.println("user updated");

            }
        }
    }
}
package com.systematic.doosystematic.application.repository.MongoDb;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoConnectionFactory {
    private static final Logger logger = Logger.getLogger(MongoConnectionFactory.class.getName());
    private static MongoClient mongoClient;

    private MongoConnectionFactory(){

    }

    public static synchronized MongoClient getMongoClient(){
        if (mongoClient == null){
            String uri = "mongodb+srv://aguiar:doo123>@clustervitor.wr2o7ko.mongodb.net/?retryWrites=true&w=majority";
            try {
                mongoClient = MongoClients.create(uri);
            } catch (MongoException e) {
                logger.log(Level.SEVERE, "Erro ao criar a conexão com o MongoDB", e);
            }
        }
        return mongoClient;
    }

}

package org.bcit.comp2522.dui.client;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.eq;

public class DatabaseHandler {

    MongoDatabase database;
    String Collection;
    public DatabaseHandler(String username, String password) {
        ConnectionString connectionString = new ConnectionString(String.format("mongodb+srv://pavanbrar73:KFmJyFJrTM6Dd7c2@dui-infinite.67uhycx.mongodb.net/?retryWrites=true&w=majority", username, password));
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("test");
        this.Collection = "playerScores";
        try{
            database.createCollection("playerScores");
        } catch (Exception e){
            System.out.println("already exists");
        }
//        database.createCollection("playerScores");

//        Document document = new Document();
//        document.append("name", "Pavan");
//        document.append("score", 1100);
//        database.getCollection("playerScores").insertOne(document);
//
//        Document found = database
//                .getCollection("playerScores")
//                .find(eq("name", "Ram"))
//                .first();
//            System.out.println(found);


    }
    public void put(String key1, String val1, String key2, long val2){
        Document document = new Document();
        document.append(key1, val1);
        document.append(key2, val2);
        new Thread(() -> database.getCollection("playerScores").insertOne(document)).start();
    };

    public ArrayList<Document> getHighestScores() {
        ArrayList<Document> highestScores = new ArrayList<>();

        database.getCollection(Collection)
                .find()
                .sort(new Document("score", -1))
                .limit(10)
                .forEach((Consumer<Document>) highestScores::add);

        return highestScores;
    }


    public static void main(String[] args) {
        DatabaseHandler dbh = new DatabaseHandler("pavanbrar73", "KFmJyFJrTM6Dd7c2");
//        dbh.put("hello", "f");
//        Document found = dbh.database
//                .getCollection("playerScores")
//                .find(eq("hello", "f"))
//                .first();
//        System.out.println(found);

//        ArrayList<Document> highestScores = dbh.getHighestScores();
//        System.out.println("Top 10 scores:");
//        for (Document doc : highestScores) {
//            String name = doc.getString("name");
//            long score = doc.getLong("score");
//            System.out.println("Name: " + name + ", Score: " + score);
//        }

        // Temporary Leaderboard
        ArrayList<Document> highestScores = dbh.getHighestScores();

        // Sort the scores in descending order
        highestScores.sort((doc1, doc2) -> doc2.getLong("score").compareTo(doc1.getLong("score")));

        System.out.println("Top 10 Leaderboard:");
        System.out.println("Rank\tName\t   Score");
        int rank = 1;
        for (Document doc : highestScores) {
            String name = doc.getString("name");
            long score = doc.getLong("score");
            System.out.printf("%d\t%s\t%d\n", rank, name, score);
            rank++;
            if (rank > 10) {
                break;  // Only print the top 10 scores
            }
        }

    }
}

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

/**
 * Database Handler class manages the database and creates a top 10 list of scores.
 */
public class DatabaseHandler {

    /**
     * The Database.
     */
    MongoDatabase database;
    /**
     * The Collection.
     */
    String collection;


    /**
     * Database Handler connects the database.
     *
     * @param username the username
     * @param password the password
     */
    public DatabaseHandler(String username, String password) {
        ConnectionString connectionString = new ConnectionString(
                String.format("mongodb+srv://erictatch:1UCQfffWKdXM6Aom@"
                        + "cluster0.rlhe8nt.mongodb.net/", username, password));
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("test");
        this.collection = "playerScores";


    }

    /**
     * Puts name and score key value pairs in a document in a collection.
     *
     * @param key1 String
     * @param val1 String
     * @param key2 String
     * @param val2 long
     */
    public void put(String key1, String val1, String key2, long val2) {
        Document document = new Document();
        document.append(key1, val1);
        document.append(key2, val2);
        new Thread(() -> database.getCollection("playerScores").insertOne(document)).start();
    }

    /**
     * Filters and sorts the documents from highest to lowest and adds 10 to an ArrayList.
     *
     * @return highestScores highest scores
     */
    public ArrayList<Document> getHighestScores() {
        ArrayList<Document> highestScores = new ArrayList<>();

        database.getCollection(collection)
                .find()
                .sort(new Document("score", -1))
                .limit(10)
                .forEach((Consumer<Document>) highestScores::add);

        return highestScores;
    }


    /**
     * Main method creates an object for the database.
     * It also prints a leaderboard
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        DatabaseHandler dbh = new DatabaseHandler("erictatch", "1UCQfffWKdXM6Aom");

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

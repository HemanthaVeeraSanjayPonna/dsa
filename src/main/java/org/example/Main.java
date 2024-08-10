package org.example;

import java.util.*;

public class Main {
    public static String[][] getStatForRequests(int m, String[] database, String[] requests) {
        // Maps to store short URLs to actual URLs and user IDs
        Map<String, String> shortUrlToActualUrl = new HashMap<>();
        Map<String, Integer> shortUrlToUserId = new HashMap<>();

        // Populate the maps from the database
        for (String entry : database) {
            String[] parts = entry.split(" ");
            String userId = parts[0];
            String shortUrl = parts[1];
            String actualUrl = parts[2];

            shortUrlToActualUrl.put(shortUrl, actualUrl);
            shortUrlToUserId.put(shortUrl, Integer.parseInt(userId));
        }

        // Map to count requests per user
        int[] userRequestCount = new int[m];
        String[][] results = new String[requests.length][2];

        // Process each request
        for (int i = 0; i < requests.length; i++) {
            String shortUrl = requests[i];
            String actualUrl = shortUrlToActualUrl.get(shortUrl);
            int userId = shortUrlToUserId.get(shortUrl);

            // Increment the count of requests for the corresponding user
            userRequestCount[userId]++;

            // Prepare the result for the current request
            results[i][0] = actualUrl;
            results[i][1] = Integer.toString(userRequestCount[userId]);
        }

        return results;
    }

    public static void main(String[] args) {
        // Example usage
        int m = 3;
        String[] database = {
                "0 sdsf www.google.com",
                "1 juytf www.google.com",
                "0 opoit www.kaggle.com"
        };
        String[] requests = {"juytf", "sdsf", "opoit"};

        String[][] results = getStatForRequests(m, database, requests);
        for (String[] result : results) {
           Arrays.stream(result).forEach(System.out::println);
        }
    }

}
package org.example.challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Challenge_01 {
    public void searchPatterns() {

        String message = readTextFile("URL/challenge_01.txt");

        Map<String, Integer> wordFrequency = countWordFrequency(message);

        String result = buildResultString(wordFrequency, message);

        System.out.println(result);
    }

    private String readTextFile(String filePath) {

        String fileMessage = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                fileMessage += line + " ";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileMessage;
    }

    private Map<String, Integer> countWordFrequency(String message) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        String[] words = message.toLowerCase().split("\\s");

        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        return wordFrequency;
    }

    private String buildResultString(Map<String, Integer> wordFrequency, String message) {
        StringBuilder result = new StringBuilder();
        TreeMap<Integer, String> sortedMap = new TreeMap<>();
        wordFrequency.forEach((word, frequency) -> sortedMap.putIfAbsent(message.indexOf(word), word));

        sortedMap.forEach((position, word) ->
                result.append(word).append(wordFrequency.get(word)));

        return result.toString();
    }

}




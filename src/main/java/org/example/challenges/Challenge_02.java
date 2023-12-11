package org.example.challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Challenge_02 {

    public void miniCompiler() {

        String message = readTextFile("URL/challenge_02.txt");
        String output = executeProgram(message);
        System.out.println(output);
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

    public String executeProgram(String program) {
        int value = 0;
        StringBuilder result = new StringBuilder();

        for (char symbol : program.toCharArray()) {
            switch (symbol) {
                case '#':
                    value++;
                    break;
                case '@':
                    value--;
                    break;
                case '*':
                    value *= value;
                    break;
                case '&':
                    result.append(value);
                    break;
                default:
            }
        }

        return result.toString();
    }
}



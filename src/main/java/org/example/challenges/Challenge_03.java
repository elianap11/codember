package org.example.challenges;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Challenge_03 {
    public void validPasswordCounter() {
        String filePath = "URL/challenge_03.txt";
        List<String> passwords = readPasswordsFromFile(filePath);

        if (passwords != null) {
            int validPasswords = countValidPasswords(passwords);
            System.out.println("Número de claves válidas: " + validPasswords);

            String invalidPassword = getInvalidPasswordAtIndex(passwords, 42);
            System.out.println("Clave inválida número 42: " + invalidPassword);
        } else {
            System.out.println("Error al leer las claves del archivo.");
        }
    }

    private static List<String> readPasswordsFromFile(String filePath) {
        List<String> passwords = new ArrayList<>();
        Path path = Paths.get(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                passwords.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return passwords;
    }

    private static boolean isValidPassword(String policy, String password) {
        String[] parts = policy.split(" ");
        String[] range = parts[0].split("-");
        int minCount = Integer.parseInt(range[0]);
        int maxCount = Integer.parseInt(range[1]);
        char letter = parts[1].charAt(0);

        long count = password.chars().filter(ch -> ch == letter).count();
        return count >= minCount && count <= maxCount;
    }

    private static int countValidPasswords(List<String> passwords) {
        int validCount = 0;
        for (String entry : passwords) {
            String[] parts = entry.split(": ");
            String policy = parts[0];
            String password = parts[1];

            if (isValidPassword(policy, password)) {
                validCount++;
            }
        }
        return validCount;
    }

    private static String getInvalidPasswordAtIndex(List<String> passwords, int index) {
        int count = 0;
        for (String entry : passwords) {
            String[] parts = entry.split(": ");
            String policy = parts[0];
            String password = parts[1];

            if (!isValidPassword(policy, password)) {
                count++;
                if (count == index) {
                    return password;
                }
            }
        }
        return "No se encontró la clave inválida número " + index;
    }
}

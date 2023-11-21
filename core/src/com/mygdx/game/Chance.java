package com.mygdx.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Chance {

    public static void main(String[] args) {
        String filePath = "assets/kartySzansy.txt";
        try {
            String fileContent = readFile(filePath);
            ;
            System.out.println(fileContent);
            System.out.println("Zawartość" + filePath);
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas odczytu pliku: " + e.getMessage());
        }
    }

    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

}

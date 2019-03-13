package by.training.task03.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    String text;

    //todo; change method to the better one.
    String read(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            text = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;

    }
}

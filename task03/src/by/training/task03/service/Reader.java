package by.training.task03.service;

import by.training.task03.exception.ReadFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Reader {
    private static final Logger LOGGER = LogManager.getLogger();
    String text;

    //todo; change method to the better one.
    public String read(String path) {
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

//    public List<String> read(String path) throws ReadFileException {
//        LOGGER.info("Reading from file " + path);
//        try {
////           text = Files.lines(Paths.get(path)).collect(Collectors.toList());
//            text = Files.readAllLines(Paths.get(path));
//        } catch (IOException e) {
//            throw new ReadFileException("Error while reading file ", e);
//        }
//        return text;
//    }

    public static void write(String string, String filePath) throws IOException {
//        LOGGER.debug("Writing data to " + filePath);
        FileWriter writer = new FileWriter(filePath, true);
        BufferedWriter bufWriter = new BufferedWriter(writer);
        bufWriter.write(string);
        bufWriter.close();
    }
}

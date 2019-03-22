package by.training.task03.reader;

import by.training.task03.exception.ReadFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
//todo; change method to the better one.

public class Reader {
    private static final Logger LOGGER = LogManager.getLogger();

    public String read(final String path) throws ReadFileException {
        LOGGER.info("Reading from file " + path);
        String text;
        try {
            text = new String(Files.readAllBytes(Paths.get(path)),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ReadFileException("Error while reading file ", e);
        }
        return text;
    }

}

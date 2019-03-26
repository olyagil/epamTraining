package by.training.task03.reader;

import by.training.task03.exception.ReadFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The {@code DataReader} class is used for reading the data from the file.
 */
public class DataReader {
    /**
     * The constant for logging.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * The method is used for reading the data from the given path to the file.
     *
     * @param path to the file
     * @return the text
     * @throws ReadFileException is thrown if error is occurred while reading
     *                           from the file.
     */
    public String readFromFile(final String path) throws ReadFileException {
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

/**
 * The reader package is used for reading from user
 */
package by.training.task01.reader;

import by.training.task01.exception.ReadFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The {@code DataReader} class is used for reading data from user.
 *
 * @author Gil Olga
 */
public class DataReader {

    private static final Logger logger = LogManager.getLogger();

    /**
     * Used for reading data from file.
     *
     * @param path entered path for the file
     * @return list of the string data
     * @throws ReadFileException is thrown when an error accrued while
     *                           reading file
     */
    public List<String> readDataFromFile(String path) throws ReadFileException {

        logger.info("Reading from file " + path);
        List<String> list;
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            list = stream.collect(Collectors.toList());
            System.out.println(list);
        } catch (IOException e) {
            throw new ReadFileException("Error while reading file ", e);
        }
        return list;
    }
}
package by.training.task02.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The {@code DataParser} class is used to parse the data.
 *
 * @author Gil Olga
 */
public class DataParser {

    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * The regex for identifying spaces.
     */
    public static final String REGEX_SPACE = "\\s+";

    /**
     * For parsing the data from the line.
     *
     * @param line of the file
     * @return list of the Circle type
     */
    public List<Integer> parseData(final String line) {

        LOGGER.info("Parsing the data ");
        List<Integer> data = new ArrayList<>();
        List<String> numbers = Arrays.asList(line.split(REGEX_SPACE));
        for (String number : numbers) {
            data.add(Integer.parseInt(number));
        }
        return data;
    }
}


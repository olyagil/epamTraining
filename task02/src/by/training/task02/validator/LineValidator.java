package by.training.task02.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The {@code LineValidator} class checks if entered data is correct.
 *
 * @author Gil Olga
 */
public class LineValidator {

    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * The REGEX_NUMBERS_FOR_DATA is used for checking entered coordinates.
     */
    private static final String REGEX_NUMBERS_FOR_DATA = "\\+?[\\d]+\\s+\\+?"
            + "[\\d]+\\s+\\+?[\\d]+\\s+\\+?[\\d]+";

    /**
     * Checks if the entered line is correct.
     *
     * @param line The line of the file that needed to be checked
     * @return true if the line matches the template
     */
    public boolean checkLine(final String line) {
        boolean flag = false;
        if (line.matches(REGEX_NUMBERS_FOR_DATA)) {
            flag = true;
        } else {
            LOGGER.warn(" The line is wrong: " + line);

        }
        return flag;
    }
}

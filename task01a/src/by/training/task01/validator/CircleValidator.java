package by.training.task01.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The {@code CircleValidator} class checks if entered coordinates is right.
 *
 * @author Gil Olga
 */
public class CircleValidator {

    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * The REGEX_COORDINATES is used for checking entered coordinates.
     */
    public static final String REGEX_COORDINATES = "[\\d]+[.][\\d]+\\s+[\\d]+["
            + ".][\\d]+\\s+[1-9][.][\\d]+";

    /**
     * Checks if the entered line is correct.
     *
     * @param line The line of the file that needed to be checked
     * @return true if the line matches the template
     */
    public boolean checkCircle(final String line) {
        boolean flag = false;
        if (line.matches(REGEX_COORDINATES)) {
            flag = true;
        } else {
            LOGGER.warn(" The line is wrong: " + line);

        }
        return flag;
    }
}

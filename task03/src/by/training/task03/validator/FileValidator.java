package by.training.task03.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * The {@code FileValidator} class checks if entered file is right.
 *
 * @author Gil Olga
 */
public class FileValidator {

    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Checks if file is exist.
     *
     * @param file entered file
     * @return true if file is exist
     */
    public boolean checkFile(File file) {
        if (file == null) {
            LOGGER.error("The file is null.");
        } else if (!file.exists()) {
            LOGGER.error("The file doesn't exist: " + file);
        } else if (file.length() == 0) {
            LOGGER.error("The file is empty: " + file);
        } else {
            return true;
        }
        return false;
    }
}

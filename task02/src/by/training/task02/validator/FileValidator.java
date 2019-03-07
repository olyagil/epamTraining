/**
 * The validator package is used to validate initial data
 */
package by.training.task02.validator;

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
    public boolean checkFile(final File file) {
        boolean flag = false;
        if (file != null || file.exists() || file.length() != 0) {
            flag = true;
        } else {
            LOGGER.warn("The file is wrong or doesn't exist" + file);
        }
        return flag;
    }


}


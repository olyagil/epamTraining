/**
 * The validator package is used to validate initial data
 */
package by.training.task01.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * The {@code FileValidator} class checks if entered file is right.
 *
 * @author Gil Olga
 */
public class FileValidator {

    private static final Logger logger = LogManager.getLogger();

    /**
     * Checks if file is exist.
     *
     * @param file entered file
     * @return true if file is exist
     */
    public boolean checkFile(File file) {
        boolean flag = false;
        if (file != null || file.exists() || file.length() != 0) {
            flag = true;
        } else {
            logger.warn("The file is wrong or doesn't exist" + file);
        }
        return flag;
    }


}

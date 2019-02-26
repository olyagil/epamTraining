package by.training.task01.exception;

/**
 * Exceptions occur when trying to read data file.
 */
public class ReadFileException extends Exception {

    /**
     * The constructor without parameters.
     */
    public ReadFileException() {
    }

    /**
     * The constructor with string parameter.
     *
     * @param message of the exceptions
     */
    public ReadFileException(final String message) {
        super(message);
    }

    /**
     * The constructor with two parameters.
     *
     * @param message of the exceptions
     * @param cause   of the exceptions
     */
    public ReadFileException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * The constructor with one parameter.
     * @param cause of the exceptions
     */
    public ReadFileException(final Throwable cause) {
        super(cause);
    }
}

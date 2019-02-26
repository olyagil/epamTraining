package by.training.task01.generator;

/**
 * The {@code IdGenerator} class is used for generating identification number.
 */
public class IdGenerator {
    /**
     * The id.
     */
    private static Integer id;

    /**
     * Constructor.
     */
    protected IdGenerator() {
        id = 0;
    }

    /**
     * The method for generating id.
     *
     * @return id
     */
    public static Integer generateId() {
        return ++id;
    }
}

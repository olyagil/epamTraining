package by.training.task03.interpreter;

/**
 * The {@code Expression} functional interface is used for interpreting the
 * data.
 */
@FunctionalInterface
interface Expression {
    /**
     * Method for interpreting the expresion in the polish notation.
     *
     * @param context context
     */
    void interpret(Context context);
}

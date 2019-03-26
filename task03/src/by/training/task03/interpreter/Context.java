package by.training.task03.interpreter;

import java.util.ArrayDeque;

/**
 * The {@code Context} class for the folding and picking up the value of the
 * expression.
 */
class Context {
    /**
     * List of the values.
     */
    private ArrayDeque<Integer> contextValues = new ArrayDeque<>();

    /**
     * Method for picking up the data.
     *
     * @return the value
     */
    Integer popValue() {
        return contextValues.pop();
    }

    /**
     * Method for folding the data.
     *
     * @param value which to fold
     */
    void pushValue(final Integer value) {
        this.contextValues.push(value);
    }
}

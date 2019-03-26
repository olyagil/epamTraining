package by.training.task03.interpreter;

/**
 * The enum {@code OperationType} is storing the operation and the priority.
 */
public enum OperationType {

    /**
     * Constant for the ~ operation with priority 5.
     */
    NOT("~", 5),
    /**
     * Constant for the << operation with priority 4.
     */
    LEFT_SHIFT("<<", 4),
    /**
     * Constant for the >> operation with priority 4.
     */
    RIGHT_SHIFT(">>", 4),
    /**
     * Constant for the >>> operation with priority 4.
     */
    UNSIGNED_RIGHT_SHIFT(">>>", 4),
    /**
     * Constant for the & operation with priority 3.
     */
    AND("&", 3),
    /**
     * Constant for the ^ operation with priority 2.
     */
    XOR("^", 2),
    /**
     * Constant for the | operation with priority 1.
     */
    OR("|", 1),
    /**
     * Constant for the ) operation with priority 0.
     */
    OPEN_BRACKET("(", 0),
    /**
     * Constant for the ) operation with priority 0.
     */
    CLOSE_BRACKET(")", 0);

    /**
     * The operation.
     */
    private String operation;
    /**
     * The priority.
     */
    private int priority;

    /**
     * The constructor with two parameters.
     *
     * @param operationOfExpression operation
     * @param priorityOfOperation   priority of the operation
     */
    OperationType(final String operationOfExpression,
                  final int priorityOfOperation) {
        this.operation = operationOfExpression;
        this.priority = priorityOfOperation;
    }

    /**
     * Method to get the priority.
     *
     * @return priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Method to get the operation.
     *
     * @return operation
     */
    public String getOperation() {
        return operation;
    }
}

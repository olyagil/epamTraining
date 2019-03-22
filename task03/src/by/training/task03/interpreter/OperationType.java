package by.training.task03.interpreter;

public enum OperationType {

    NOT("~", 5),
    LEFT_SHIFT("<<", 4),
    RIGHT_SHIFT(">>", 4),
    UNSIGNED_RIGHT_SHIFT(">>>", 4),
    AND("&", 3),
    XOR("^", 2),
    OR("|", 1),
    OPEN_BRACKET("(", 0),
    CLOSE_BRACKET(")", 0);


    private String operation;
    private int priority;

    OperationType(final String operation, final int priority) {
        this.operation = operation;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getOperation() {
        return operation;
    }
}

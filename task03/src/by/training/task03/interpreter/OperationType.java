package by.training.task03.interpreter;

public enum OperationType {

    OPEN_BRACKET("(", 0),
    CLOSE_BRACKET(")", 0),
    OR("|", 1),
    XOR("^", 2),
    AND("&", 3),
    LEFT_SHIFT("<<", 4),
    RIGHT_SHIFT(">>", 4),
    UNSIGNED_RIGHT_SHIFT(">>>", 4),
    NOT("~", 5);

    String operation;
    int priority;

    OperationType(String operation, int priority) {
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

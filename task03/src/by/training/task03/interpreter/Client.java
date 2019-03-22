package by.training.task03.interpreter;

import java.util.ArrayList;

public class Client {

    private static final String REGEX_EXPRESSION = "\\p{Blank}+";
    private ArrayList<Expression> expressionList;

    public Client(final String expression) {
        expressionList = new ArrayList<>();
        parse(expression);
    }

    private void parse(final String expression) {
        for (String lexeme : expression.trim().split(REGEX_EXPRESSION)) {
            if (Character.isDigit(lexeme.charAt(0))) {
                expressionList.add(c -> c.pushValue(Integer.parseInt(lexeme)));
            } else {
                for (OperationType operation : OperationType.values()) {
                    if (operation.getOperation().equals(lexeme)) {
                        switch (operation) {
                            case NOT:
                                expressionList.add(c -> c.pushValue(~c.popValue()));
                                break;
                            case AND:
                                expressionList.add(c ->
                                        c.pushValue(c.popValue() & c.popValue()));
                                break;
                            case OR:
                                expressionList.add(c ->
                                        c.pushValue(c.popValue() | c.popValue()));
                                break;
                            case XOR:
                                expressionList.add(c ->
                                        c.pushValue(c.popValue() ^ c.popValue()));
                                break;
                            case RIGHT_SHIFT:
                                expressionList.add(c -> {
                                    int first = c.popValue();
                                    int second = c.popValue();
                                    c.pushValue(second >> first);
                                });
                                break;
                            case UNSIGNED_RIGHT_SHIFT:
                                expressionList.add(c -> {
                                    int first = c.popValue();
                                    int second = c.popValue();
                                    c.pushValue(second >>> first);
                                });
                                break;
                            case LEFT_SHIFT:
                                expressionList.add(c -> {
                                    int first = c.popValue();
                                    int second = c.popValue();
                                    c.pushValue(second << first);
                                });
                                break;
                        }
                    }
                }
            }
        }
    }

    public Number calculate() {
        Context context = new Context();
        expressionList.forEach(c -> c.interpret(context));
        return context.popValue();
    }
}


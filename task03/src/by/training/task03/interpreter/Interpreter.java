package by.training.task03.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * The {@code Interpreter} class for the interpreting the expression.
 */
public class Interpreter {
    /**
     * The constant for logging.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * List of expressions.
     */
    private ArrayList<Expression> expressionList;
    /**
     * Functional interface for the ~ operation.
     */
    private UnaryOperator<Integer> not = number -> ~number;
    /**
     * Functional interface for the & operation.
     */
    private BinaryOperator<Integer> and = (number1, number2)
            -> number1 & number2;
    /**
     * Functional interface for the | operation.
     */
    private BinaryOperator<Integer> or = (number1, number2)
            -> number1 | number2;
    /**
     * Functional interface for the ^ operation.
     */
    private BinaryOperator<Integer> xor = (number1, number2)
            -> number1 ^ number2;
    /**
     * Functional interface for the >> operation.
     */
    private BinaryOperator<Integer> rightShift = (number1, number2)
            -> number1 >> number2;
    /**
     * Functional interface for the << operation.
     */
    private BinaryOperator<Integer> leftShift = (number1, number2)
            -> number1 << number2;
    /**
     * Functional interface for the >>> operation.
     */
    private BinaryOperator<Integer> unspecifiedRightShift =
            (number1, number2) -> number1 >>> number2;

    /**
     * The constructor with one parameter.
     *
     * @param expression given expression
     */
    public Interpreter(final String expression) {
        expressionList = new ArrayList<>();
        parse(expression);
    }

    /**
     * Method for parsing the expression.
     *
     * @param expression given expression
     */
    private void parse(final String expression) {
        for (String symbol : expression.split(" ")) {
            if (Character.isDigit(symbol.charAt(0))) {
                expressionList.add(c -> c.pushValue(Integer.parseInt(symbol)));
            } else {
                for (OperationType operation : OperationType.values()) {
                    if (operation.getOperation().equals(symbol)) {
                        switch (operation) {
                            case NOT:
                                expressionList.add(c ->
                                        c.pushValue(not.apply(c.popValue())));
                                break;
                            case AND:
                                expressionList.add(c ->
                                        c.pushValue(and.apply(c.popValue(),
                                                c.popValue())));
                                break;
                            case OR:
                                expressionList.add(c ->
                                        c.pushValue(or.apply(c.popValue(),
                                                c.popValue())));
                                break;
                            case XOR:
                                expressionList.add(c ->
                                        c.pushValue(xor.apply(c.popValue(),
                                                c.popValue())));
                                break;
                            case RIGHT_SHIFT:
                                expressionList.add(c -> {
                                    int first = c.popValue();
                                    int second = c.popValue();
                                    c.pushValue(rightShift.apply(second,
                                            first));
                                });
                                break;
                            case UNSIGNED_RIGHT_SHIFT:
                                expressionList.add(c -> {
                                    int first = c.popValue();
                                    int second = c.popValue();
                                    c.pushValue(unspecifiedRightShift
                                            .apply(second, first));
                                });
                                break;
                            case LEFT_SHIFT:
                                expressionList.add(c -> {
                                    int first = c.popValue();
                                    int second = c.popValue();
                                    c.pushValue(leftShift.apply(second, first));
                                });
                                break;
                            default:
                                LOGGER.warn("Doesn't have this operation: "
                                        + operation);
                        }
                    }
                }
            }
        }
    }

    /**
     * Method  for calculating the each expression in the expression list.
     *
     * @return result
     */
    public int calculate() {
        Context context = new Context();
        expressionList.forEach(c -> c.interpret(context));
        return context.popValue();
    }
}


package by.training.task03.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

/**
 * The {@code ReversePolishNotation} class for creating the polish notation.
 */
public class ReversePolishNotation {
    /**
     * The constant for the < operation.
     */
    private static final Character LEFT_SHIFT_SYMBOL = '<';
    /**
     * The constant for the > operation.
     */
    private static final Character RIGHT_SHIFT_SYMBOL = '>';
    /**
     * The constant for logging.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * The constant for the space.
     */
    public static final String SPACE = " ";
    /**
     * The stack.
     */
    private Deque<String> stack = new ArrayDeque<>();
    /**
     * The expression in the polish notation form.
     */
    private StringBuilder polishNotation = new StringBuilder();
    /**
     * Map for the operation and his priority.
     */
    private Map<String, Integer> operationPrecedenceMap = new TreeMap<>();

    /**
     * The constructor with no parameters.
     */
    public ReversePolishNotation() {
        stack.clear();
        createMap();
    }

    /**
     * Method for creating the the map.
     */
    private void createMap() {
        for (OperationType operation : OperationType.values()) {
            operationPrecedenceMap.put(operation.getOperation(),
                    operation.getPriority());
        }
    }

    /**
     * Method for creating the polish notation form.
     *
     * @param expression expression
     * @return expression int the polish notation form
     */
    public String create(final String expression) {
        LOGGER.info("Converting the expression to the polish notation form.");
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                int current = i;
                while (current < expression.length()
                        && Character.isDigit(expression.charAt(current))) {
                    current++;
                }
                if (current != i) {
                    polishNotation.append(expression.substring(i, current))
                            .append(SPACE);
                    i = current - 1;
                }
            } else {
                String temp;
                if (RIGHT_SHIFT_SYMBOL.equals(expression.charAt(i))
                        && RIGHT_SHIFT_SYMBOL.equals(expression
                        .charAt(i + 2))) {
                    temp = OperationType.UNSIGNED_RIGHT_SHIFT.getOperation();
                    i = i + 2;
                } else if (RIGHT_SHIFT_SYMBOL.equals(expression.charAt(i))) {
                    temp = OperationType.RIGHT_SHIFT.getOperation();
                    i++;
                } else if (LEFT_SHIFT_SYMBOL.equals(expression.charAt(i))) {
                    temp = OperationType.LEFT_SHIFT.getOperation();
                    i++;
                } else {
                    temp = Character.toString(expression.charAt(i));
                }
                if (temp.equals(OperationType.CLOSE_BRACKET.getOperation())) {
                    String peek = stack.pop();
                    while (!peek.equals(OperationType
                            .OPEN_BRACKET.getOperation())) {
                        polishNotation.append(peek).append(SPACE);
                        peek = stack.pop();
                    }
                } else if (!stack.isEmpty()
                        && !temp.equals(OperationType
                        .OPEN_BRACKET.getOperation())
                        && operationPrecedenceMap.get(temp)
                        <= operationPrecedenceMap.get(stack.peek())) {
                    do {
                        polishNotation.append(stack.pop()).append(SPACE);
                    } while (!stack.isEmpty()
                            && operationPrecedenceMap.get(temp)
                            <= operationPrecedenceMap.get(stack.peek()));
                    stack.push(temp);
                } else {
                    stack.push(temp);
                }
            }
        }
        while (!stack.isEmpty()) {
            polishNotation.append(stack.pop()).append(SPACE);
        }
        return polishNotation.toString();
    }
}


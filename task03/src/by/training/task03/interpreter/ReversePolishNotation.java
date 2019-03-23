package by.training.task03.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

//todo: refactor completely
public class ReversePolishNotation {

    private static final Character LEFT_SHIFT_SYMBOL = '<';
    private static final Character RIGHT_SHIFT_SYMBOL = '>';
    private static final Logger LOGGER = LogManager.getLogger();
    private Deque<String> deque = new ArrayDeque<>();
    private StringBuilder polishNotation = new StringBuilder();

    public ReversePolishNotation() {
        deque.clear();
        for (OperationType operation : OperationType.values()) {
            operationMap.put(operation.getOperation(), operation.getPriority());
        }
    }

    private Map<String, Integer> operationMap = new TreeMap<>();

    public String create(String input) {

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                int start = i;
                int current = i;
                while (current < input.length() && Character.isDigit(input.charAt(i))) {
                    current++;
                    i++;
                }
                i--;
                polishNotation.append(input.substring(start, current) + " ");
            } else {
                int current = i;
                String temp;
                if (input.charAt(i) == RIGHT_SHIFT_SYMBOL
                        && input.charAt(i + 2) == RIGHT_SHIFT_SYMBOL) {
                    temp = OperationType.UNSIGNED_RIGHT_SHIFT.getOperation();
                    i = i + 2;
                } else if (input.charAt(i) == RIGHT_SHIFT_SYMBOL) {
                    temp = OperationType.RIGHT_SHIFT.getOperation();
                    i++;
                } else if (input.charAt(i) == LEFT_SHIFT_SYMBOL) {
                    temp = OperationType.LEFT_SHIFT.getOperation();
                    i++;
                } else {
                    temp = Character.toString(input.charAt(current));
                }
                if (temp.equals(OperationType.CLOSE_BRACKET.getOperation())) {
                    String peek = deque.pop();
                    while (!peek.equals(OperationType.OPEN_BRACKET.getOperation())) {
                        polishNotation.append(peek + " ");
                        peek = deque.pop();
                    }
                } else if (!deque.isEmpty()
                        && !temp.equals(OperationType.OPEN_BRACKET.getOperation())
                        && operationMap.get(temp) <= operationMap.get(deque.peek())) {
                    do {
                        polishNotation.append(deque.pop() + " ");
                    } while (!deque.isEmpty() && operationMap.get(temp)
                            <= operationMap.get(deque.peek()));
                    deque.push(temp);
                } else {
                    deque.push(temp);
                }
            }
        }
        while (!deque.isEmpty()) {
            polishNotation.append(deque.pop() + " ");
        }
        return polishNotation.toString();
    }

}


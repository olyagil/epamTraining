package by.training.task03.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

//TODO refactor completely
//TODO maiby объединить с другим классом
public class ReversePolishNotation {

    private static final Character LEFT_SHIFT_SYMBOL = '<';
    private static final Character RIGHT_SHIFT_SYMBOL = '>';
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String SPACE = " ";
    private Deque<String> stack = new ArrayDeque<>();
    private StringBuilder polishNotation = new StringBuilder();
    private Map<String, Integer> operationPrecedenceMap = new TreeMap<>();

    public ReversePolishNotation() {
        stack.clear();
        createMap();
    }

    private void createMap() {
        for (OperationType operation : OperationType.values()) {
            operationPrecedenceMap.put(operation.getOperation(),
                    operation.getPriority());
        }
    }

    public String create(String input) {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                int current = i;
                while (current < input.length()
                        && Character.isDigit(input.charAt(current))) {
                    current++;
                }
                if (current != i) {
                    polishNotation.append(input.substring(i, current)).append(SPACE);
                    i = current - 1;
                }
            } else {
                String temp;
                if (RIGHT_SHIFT_SYMBOL.equals(input.charAt(i))
                        && RIGHT_SHIFT_SYMBOL.equals(input.charAt(i + 2))) {
                    temp = OperationType.UNSIGNED_RIGHT_SHIFT.getOperation();
                    i = i + 2;
                } else if (RIGHT_SHIFT_SYMBOL.equals(input.charAt(i))) {
                    temp = OperationType.RIGHT_SHIFT.getOperation();
                    i++;
                } else if (LEFT_SHIFT_SYMBOL.equals(input.charAt(i))) {
                    temp = OperationType.LEFT_SHIFT.getOperation();
                    i++;
                } else {
                    temp = Character.toString(input.charAt(i));
                }
                if (temp.equals(OperationType.CLOSE_BRACKET.getOperation())) {
                    String peek = stack.pop();
                    while (!peek.equals(OperationType.OPEN_BRACKET.getOperation())) {
                        polishNotation.append(peek).append(SPACE);
                        peek = stack.pop();
                    }
                } else if (!stack.isEmpty()
                        && !temp.equals(OperationType.OPEN_BRACKET.getOperation())
                        && operationPrecedenceMap.get(temp)
                        <= operationPrecedenceMap.get(stack.peek())) {
                    do {
                        polishNotation.append(stack.pop()).append(SPACE);
                    } while (!stack.isEmpty() && operationPrecedenceMap.get(temp)
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
//    public String create(String input) {
//
//        for (int i = 0; i < input.length(); i++) {
//            char ch = input.charAt(i);
//            if (Character.isDigit(ch)) {
//                int start = i;
//                int current = i;
//                while (current < input.length() && Character.isDigit(input.charAt(i))) {
//                    current++;
//                    i++;
//                }
//                i--;
//                polishNotation.append(input.substring(start, current) + " ");
//            } else {
//                int current = i;
//                String temp;
//                if (RIGHT_SHIFT_SYMBOL.equals(input.charAt(i))
//                        && RIGHT_SHIFT_SYMBOL.equals(input.charAt(i + 2))) {
//                    temp = OperationType.UNSIGNED_RIGHT_SHIFT.getOperation();
//                    i = i + 2;
//                } else if (RIGHT_SHIFT_SYMBOL.equals(input.charAt(i))) {
//                    temp = OperationType.RIGHT_SHIFT.getOperation();
//                    i++;
//                } else if (LEFT_SHIFT_SYMBOL.equals(input.charAt(i))) {
//                    temp = OperationType.LEFT_SHIFT.getOperation();
//                    i++;
//                } else {
//                    temp = Character.toString(input.charAt(current));
//                }
//                if (temp.equals(OperationType.CLOSE_BRACKET.getOperation())) {
//                    String peek = stack.pop();
//                    while (!peek.equals(OperationType.OPEN_BRACKET.getOperation())) {
//                        polishNotation.append(peek + " ");
//                        peek = stack.pop();
//                    }
//                } else if (!stack.isEmpty()
//                        && !temp.equals(OperationType.OPEN_BRACKET.getOperation())
//                        && operationPrecedenceMap.get(temp) <= operationPrecedenceMap.get(stack.peek())) {
//                    do {
//                        polishNotation.append(stack.pop() + " ");
//                    } while (!stack.isEmpty() && operationPrecedenceMap.get(temp)
//                            <= operationPrecedenceMap.get(stack.peek()));
//                    stack.push(temp);
//                } else {
//                    stack.push(temp);
//                }
//            }
//        }
//        while (!stack.isEmpty()) {
//            polishNotation.append(stack.pop() + " ");
//        }
//        return polishNotation.toString();
//    }

}


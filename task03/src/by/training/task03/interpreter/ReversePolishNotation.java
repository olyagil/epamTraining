package by.training.task03.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

//todo: refactor completely
class ReversePolishNotation {

    private static final Character LEFT_SHIFT_SYMBOL = '<';
    private static final Character RIGHT_SHIFT_SYMBOL = '>';

    private Deque<String> deque = new ArrayDeque<>();
    private StringBuilder polishNotation = new StringBuilder();

    String create(String input) {
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
                if (input.charAt(i) == RIGHT_SHIFT_SYMBOL) {
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
                        && Character.toString(ch).equals(OperationType.CLOSE_BRACKET.getOperation())
                        && OperationType.valueOf(temp).getPriority() <= OperationType.valueOf(deque.peek()).getPriority()) {
                    do {
                        polishNotation.append(deque.pop() + " ");
                    } while (!deque.isEmpty() && OperationType.valueOf(temp).getPriority()
                            <= (OperationType.valueOf(deque.peek()).getPriority()));
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


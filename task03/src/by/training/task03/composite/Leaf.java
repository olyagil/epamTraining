package by.training.task03.composite;

import by.training.task03.interpreter.Client;
import by.training.task03.interpreter.ReversePolishNotation;

public class Leaf implements Component {
    private char symbol;
    private ComponentType type;

    public Leaf(final ComponentType type, final char symbol) {
        this.type = type;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(type.getDelimiter());
        result.append(symbol);
        return result.toString();
    }
}

package by.training.task03.composite;

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
        result.append(symbol);
        return result.toString();
    }
}

package by.training.task03.composite;

public class Leaf implements Component {
    private char symbol;

    public Leaf(final char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(symbol);
        return result.toString();
    }
}

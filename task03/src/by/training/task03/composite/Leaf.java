package by.training.task03.composite;

public class Leaf implements Component {

    private String symbol;
    private ComponentType type;

    public Leaf(final ComponentType type, final String symbol) {
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

package by.training.task03.composite;

/**
 * The {@code Leaf} class is used for the gathering the symbol.
 */
public class Leaf implements Component {
    /**
     * The given symbol.
     */
    private char symbol;

    /**
     * The constructor with ine parameter.
     *
     * @param componentSymbol the given symbol
     */
    public Leaf(final char componentSymbol) {
        this.symbol = componentSymbol;
    }

    /**
     * Overriding the method equals for comparison the components.
     *
     * @param o object
     * @return true if equals
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Leaf leaf = (Leaf) o;

        return symbol == leaf.symbol;
    }

    /**
     * Overriding the method hashCode for getting the hashcode.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return (int) symbol;
    }

    /**
     * Overriding the method toString for gathering the data back.
     *
     * @return string
     */

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(symbol);
        return result.toString();
    }
}

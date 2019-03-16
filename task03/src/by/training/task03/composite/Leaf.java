package by.training.task03.composite;

public class Leaf implements InterfaceComponent {

    String symbol;

    public Leaf() {
        this.symbol = symbol;
    }

    @Override
    public void gather() {
        System.out.println("Symbol (leaf) : " + symbol);
    }
}

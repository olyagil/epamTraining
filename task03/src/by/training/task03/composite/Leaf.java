package by.training.task03.composite;

import by.training.task03.service.Reader;

import java.io.IOException;

public class Leaf implements Component {

    String symbol;
    ComponentType type;

    public Leaf() {

    }

    public Leaf(ComponentType type, String symbol) {
        this.type = type;
        this.symbol = symbol;
    }

    @Override
    public void gather() {
        System.out.println("The symbol: " + symbol + " : " + type);
        try {
            Reader.write(symbol, "data//output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "symbol='" + symbol + '\'' +
                ", type=" + type +
                '}';
    }
}

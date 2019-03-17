package by.training.task03.composite;

import by.training.task03.service.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Leaf implements Component {

    private String symbol;
    private ComponentType type;
    private static final Logger LOGGER = LogManager.getLogger();

    public Leaf(final ComponentType type, final String symbol) {
        this.type = type;
        this.symbol = symbol;
    }

    @Override
    public void gather(String path) {
        LOGGER.info("The leaf: " + symbol + " : " + type);
        try {
            Reader.write(symbol, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Leaf{" + "symbol='" + symbol + '\''
                + ", type=" + type + '}';
    }
}

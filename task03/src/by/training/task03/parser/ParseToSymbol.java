package by.training.task03.parser;

import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import by.training.task03.composite.Leaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParseToSymbol extends Parser {

    private static final Logger LOGGER = LogManager.getLogger();

    public ParseToSymbol(final Parser nextParser) {
        super(nextParser);
    }

    @Override
    public CompositeText parseData(final String word,
                                   final CompositeText compositeWord) {
//        LOGGER.info("Parsing into the symbol");
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            compositeWord.add(new Leaf(ch));
        }
        return compositeWord;
    }
}

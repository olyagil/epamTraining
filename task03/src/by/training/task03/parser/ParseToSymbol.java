package by.training.task03.parser;

import by.training.task03.composite.CompositeText;
import by.training.task03.composite.Leaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The {@code ParseSymbol} class for the parsing the lexeme into the symbols.
 */
public class ParseToSymbol extends Parser {
    /**
     * The constant for logging.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * The constructor with one parameter.
     *
     * @param nextParser in line
     */
    public ParseToSymbol(final Parser nextParser) {
        super(nextParser);
    }

    /**
     * Overriding the method for parsing lexemes.
     *
     * @param text          text to parse
     * @param compositeWord composite
     * @return composite
     */
    @Override
    public CompositeText parseData(final String text,
                                   final CompositeText compositeWord) {
        LOGGER.info("Parsing into the symbol");
        char[] chars = text.toCharArray();
        for (char ch : chars) {
            compositeWord.add(new Leaf(ch));
        }
        return compositeWord;
    }
}

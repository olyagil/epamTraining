package by.training.task03.parser;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;

/**
 * The {@code Parser} abstract class for the implementing the chain of
 * responsibility pattern.
 */
public abstract class Parser {
    /**
     * The next parser in line of chain.
     */
    private Parser nextParser;

    /**
     * The constructor with one parameter.
     *
     * @param nextParserInChain next parser
     */
    Parser(final Parser nextParserInChain) {
        this.nextParser = nextParserInChain;
    }

    /**
     * Method for the beginning and deciding the next method.
     *
     * @param text          given text to parse
     * @param compositeText composite for gathering the data back
     * @return component
     */
    public Component parse(final String text,
                           final CompositeText compositeText) {
        if (compositeText.getType() == ComponentType.TEXT) {
            return parseData(text, compositeText);
        }
        return nextParser.parseData(text, compositeText);
    }

    /**
     * Abstract method witch need to be overriding for the specific parser.
     *
     * @param text          text to parse
     * @param compositeText composite for gathering the data back
     * @return composite text
     */
    public abstract CompositeText parseData(String text,
                                            CompositeText compositeText);


}




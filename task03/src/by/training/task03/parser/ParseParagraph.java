package by.training.task03.parser;

import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code ParseParagraph} class for the parsing the paragraph into the
 * sentence.
 */
public class ParseParagraph extends Parser {
    /**
     * The constant for logging.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * The constant pattern regex for the paragraph breakdown.
     */
    private static final Pattern PATTERN_FOR_SENTENCE = Pattern.compile("[A-Z]"
            + ".+?[.!?]+");

    /**
     * The constructor with one parameter.
     *
     * @param nextParser in line
     */
    public ParseParagraph(final Parser nextParser) {
        super(nextParser);
    }

    /**
     * Overriding the method for parsing paragraph.
     *
     * @param text               text to parse
     * @param compositeParagraph
     * @return
     */
    @Override
    public CompositeText parseData(final String text,
                                   final CompositeText compositeParagraph) {
        LOGGER.info("Parsing the paragraph into the sentences. ");
        Matcher matcher = PATTERN_FOR_SENTENCE.matcher(text);
        while (matcher.find()) {
            compositeParagraph.add(parse(matcher.group(),
                    new CompositeText(ComponentType.SENTENCE)));
        }

        return compositeParagraph;
    }
}

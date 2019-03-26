package by.training.task03.parser;

import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code ParseSentence} class for the parsing the sentence into the
 * lexeme.
 */
public class ParseSentence extends Parser {
    /**
     * The constant for logging.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * The constant pattern regex for the sentence breakdown.
     */
    private static final Pattern PATTERN_FOR_LEXEME = Pattern.compile(".+?[\\s"
            + ".,!?]+");

    /**
     * The constructor with one parameter.
     *
     * @param nextParser in line
     */
    public ParseSentence(final Parser nextParser) {
        super(nextParser);
    }

    /**
     * Overriding the method for parsing sentence.
     *
     * @param text              text to parse
     * @param compositeSentence
     * @return
     */
    @Override
    public CompositeText parseData(final String text,
                                   final CompositeText compositeSentence) {
        LOGGER.info("Parsing the sentence into the lexeme. ");

        Matcher matcher = PATTERN_FOR_LEXEME.matcher(text);
        while (matcher.find()) {
            compositeSentence.add(parse(matcher.group(),
                    new CompositeText(ComponentType.LEXEME)));
        }
        return compositeSentence;
    }
}

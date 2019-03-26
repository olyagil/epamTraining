package by.training.task03.parser;

import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code ParseText} class for the parsing the text into the paragraphs.
 */
public class ParseText extends Parser {
    /**
     * The constant for logging.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * The constant pattern regex for the text breakdown.
     */
    private static final Pattern PATTERN_FOR_PARAGRAPH = Pattern.compile("[\t"
            + "\r\n].+");

    /**
     * The constructor with one parameter.
     *
     * @param nextParser in line
     */
    public ParseText(final Parser nextParser) {
        super(nextParser);
    }

    /**
     * Overriding the method for parsing text.
     *
     * @param text          text to parse
     * @param compositeText composite for gathering the data back
     * @return composite
     */
    @Override
    public CompositeText parseData(final String text,
                                   final CompositeText compositeText) {

        LOGGER.info("Parsing the text into the paragraphs.");
        Matcher matcher = PATTERN_FOR_PARAGRAPH.matcher(text);
        while (matcher.find()) {
            compositeText.add(parse(matcher.group(),
                    new CompositeText(ComponentType.PARAGRAPH)));
        }
        return compositeText;
    }
}

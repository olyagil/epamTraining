package by.training.task03.parser;

import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseParagraph extends Parser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Pattern PATTERN_FOR_SENTENCE = Pattern.compile("[A-Z]"
            + ".+?[.!?]+");

    public ParseParagraph(Parser nextParser) {
        super(nextParser);
    }


    @Override
    public CompositeText parseData(final String paragraph,
                                   final CompositeText compositeParagraph) {
//        LOGGER.info("Parsing the paragraph into the sentences. ");
        Matcher matcher = PATTERN_FOR_SENTENCE.matcher(paragraph);
        while (matcher.find()) {
            compositeParagraph.add(parse(matcher.group(),
                    new CompositeText(ComponentType.SENTENCE)));
        }

        return compositeParagraph;
    }
}

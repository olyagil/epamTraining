package by.training.task03.parser;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseParagraph extends Parser {
    //todo: regex for ...
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Pattern PATTERN_FOR_SENTENCE = Pattern.compile("[A-Z]"
            + ".+?[.!?]|(\\.\\.\\.)");
    private List<String> listSentence;

    public ParseParagraph(Parser nextParser) {
        super(nextParser);
        listSentence = new ArrayList<>();
    }

    @Override
    public Component parseData(final String paragraph,
                               final CompositeText compositeParagraph) {

        LOGGER.info("Parsing the paragraph into the sentences. ");
        Matcher matcher = PATTERN_FOR_SENTENCE.matcher(paragraph);
        while (matcher.find()) {
            listSentence.add(matcher.group());
            CompositeText compositeSentence =
                    new CompositeText(ComponentType.SENTENCE);
            compositeParagraph.add(parse(matcher.group(), compositeSentence));
        }
        return compositeParagraph;
    }
}

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

public class ParseSentence extends Parser {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Pattern PATTERN_FOR_LEXEME = Pattern.compile(".+?[\\s"
            + ".,!?]+");
    private List<String> listLexeme;

    public ParseSentence(Parser nextParser) {
        super(nextParser);
        listLexeme = new ArrayList<>();
    }

    @Override
    public Component parseData(final String sentence,
                               final CompositeText compositeSentence) {

//        LOGGER.info("Parsing the sentence into the lexemes.");
        Matcher matcher = PATTERN_FOR_LEXEME.matcher(sentence);
        while (matcher.find()) {
            listLexeme.add(matcher.group());
            compositeSentence.add(parse(matcher.group(),
                    new CompositeText(ComponentType.LEXEME)));
        }
//        System.out.println("SENTENCE has " + compositeSentence.getSize()  +
//                " lexemes.");
        return compositeSentence;
    }
}

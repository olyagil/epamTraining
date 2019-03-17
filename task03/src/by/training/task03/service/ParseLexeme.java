package by.training.task03.service;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import by.training.task03.composite.Leaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseLexeme extends Parser {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String REGEX_LEXEME = ".+?[\\s.,!?]+";
    private static final String SPACE = " ";

    private List<String> listLexeme;

    ParseLexeme() {
        listLexeme = new ArrayList<>();
    }

    @Override
    public Component parseData(final String sentence) {
        LOGGER.info("Parsing the sentence into the lexemes.");

        CompositeText lexemeComponent = new CompositeText(ComponentType.LEXEME);
        Pattern pattern = Pattern.compile(REGEX_LEXEME);
        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()) {
            listLexeme.add(matcher.group());
            lexemeComponent.add(parse(matcher.group()),
                    new Leaf(ComponentType.SPACE, SPACE));
        }
        LOGGER.info("LEXEME COMPONENT: " + lexemeComponent);
        LOGGER.info(listLexeme.size() + " lexemes: " + listLexeme);
        return lexemeComponent;
    }
}

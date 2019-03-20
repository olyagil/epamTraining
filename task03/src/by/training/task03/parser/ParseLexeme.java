package by.training.task03.parser;


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

//todo:change method
public class ParseLexeme extends Parser {

    private static final Logger LOGGER = LogManager.getLogger();
    private List<String> listWords;
    private List<String> listExpressions;
    private List<String> listPunctuationMarks;

    public ParseLexeme(Parser nextParser) {
        super(nextParser);
        listWords = new ArrayList<>();
        listExpressions = new ArrayList<>();
        listPunctuationMarks = new ArrayList<>();
    }

    private static final Pattern PATTERN_FOR_WORD = Pattern.compile("\\" +
            "(*[A-Za-z'-]+\\)*");
    private static final Pattern PATTERN_FOR_EXPRESSION = Pattern.compile("[0-9~&|^><()]+");
    private static final Pattern PATTERN_FOR_PUNCTUATION_MARK = Pattern.compile("[,.!?]+");

    @Override
    public Component parseData(final String lexeme,
                               final CompositeText compositeLexeme) {
        LOGGER.info("Parsing the sentence into the words, expression or the "
                + "punctuation mark.");

        Matcher matcherWord = PATTERN_FOR_WORD.matcher(lexeme.trim());
        Matcher matcherExpression = PATTERN_FOR_EXPRESSION.matcher(lexeme.trim());
        Matcher matcherPunctuationMark =
                PATTERN_FOR_PUNCTUATION_MARK.matcher(lexeme.trim());

        if (matcherWord.find()) {
            listWords.add(matcherWord.group());
            compositeLexeme.add(parse(matcherWord.group(),
                    new CompositeText(ComponentType.WORD)));
            if (matcherPunctuationMark.find()) {
                listPunctuationMarks.add(matcherPunctuationMark.group());
                compositeLexeme.add(new Leaf(ComponentType.PUNCTUATION_MARK,
                        matcherPunctuationMark.group()));
            }
        } else if (matcherExpression.find()) {
            listExpressions.add(matcherExpression.group());
            compositeLexeme.add(new Leaf(ComponentType.EXPRESSION,
                    matcherExpression.group()));
        }
        return compositeLexeme;
    }
}

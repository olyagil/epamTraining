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

//todo:change method
public class ParseLexeme extends Parser {

    private static final Logger LOGGER = LogManager.getLogger();
    private List<String> listWords;
    private List<String> listExpressions;
    private List<String> listPunctuationMarks;

    public String getListExpression(final int index) {
        return listExpressions.get(index);
    }

    public int getSize() {
        return listExpressions.size();
    }

    public ParseLexeme(final Parser nextParser) {
        super(nextParser);
        listWords = new ArrayList<>();
        listExpressions = new ArrayList<>();
        listPunctuationMarks = new ArrayList<>();
    }

    private static final Pattern PATTERN_FOR_WORD = Pattern.compile("\\"
            + "(*[A-Za-z'-]+\\)*");
    private static final Pattern PATTERN_FOR_EXPRESSION = Pattern.compile("[0-9~&|^><()]+");
    private static final Pattern PATTERN_FOR_PUNCTUATION_MARK = Pattern.compile("[,.!?]+");

    @Override
    public Component parseData(final String lexeme,
                               final CompositeText compositeLexeme) {
//        LOGGER.info("Parsing the sentence into the words, expression or the "
//                + "punctuation mark.");

        Matcher matcherWord = PATTERN_FOR_WORD.matcher(lexeme.trim());
        Matcher matcherExpression = PATTERN_FOR_EXPRESSION.matcher(lexeme.trim());
        Matcher matcherPunctuationMark =
                PATTERN_FOR_PUNCTUATION_MARK.matcher(lexeme.trim());
//TODO change to one matcher
        if (matcherWord.find()) {
            listWords.add(matcherWord.group());
            compositeLexeme.add(parse(matcherWord.group(),
                    new CompositeText(ComponentType.WORD)));
        } else if (matcherExpression.find()) {
            listExpressions.add(matcherExpression.group());
            compositeLexeme.add(parse(matcherExpression.group(),
                    new CompositeText(ComponentType.EXPRESSION)));
        }
        if (matcherPunctuationMark.find()) {
            listPunctuationMarks.add(matcherPunctuationMark.group());
            compositeLexeme.add(parse(matcherPunctuationMark.group(),
                    new CompositeText(ComponentType.PUNCTUATION_MARK)));
        }
        return compositeLexeme;
    }
}

package by.training.task03.parser;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseLexeme extends Parser {

    private static final Logger LOGGER = LogManager.getLogger();

    public ParseLexeme(final Parser nextParser) {
        super(nextParser);
    }

    private static final Pattern PATTERN_FOR_WORD = Pattern.compile("\\"
            + "(*[A-Za-z'-]+\\)*");
    private static final Pattern PATTERN_FOR_EXPRESSION = Pattern.compile("[0-9~&|^><()]+");
    private static final Pattern PATTERN_FOR_PUNCTUATION_MARK = Pattern.compile("[,.!?]+");

    @Override
    public CompositeText parseData(final String lexeme,
                               final CompositeText compositeLexeme) {
//        LOGGER.info("Parsing the sentence into the words, expression or the "
//                + "punctuation mark.");

        Matcher matcherWord = PATTERN_FOR_WORD.matcher(lexeme.trim());
        Matcher matcherExpression = PATTERN_FOR_EXPRESSION.matcher(lexeme.trim());
        Matcher matcherPunctuationMark =
                PATTERN_FOR_PUNCTUATION_MARK.matcher(lexeme.trim());

        //TODO change to one matcher
        if (matcherWord.find()) {
            compositeLexeme.add(parse(matcherWord.group(),
                    new CompositeText(ComponentType.WORD)));
        } else if (matcherExpression.find()) {
            compositeLexeme.add(parse(matcherExpression.group(),
                    new CompositeText(ComponentType.EXPRESSION)));
        }
        if (matcherPunctuationMark.find()) {
            compositeLexeme.add(parse(matcherPunctuationMark.group(),
                    new CompositeText(ComponentType.PUNCTUATION_MARK)));
        }
        return compositeLexeme;
    }
}

package by.training.task03.parser;

import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code ParseText} class for the parsing the lexemes into the word,
 * punctuation mark and expression.
 */
public class ParseLexeme extends Parser {
    /**
     * The constant for logging.
     */
    private static final Logger LOGGER = LogManager.getLogger();


    /**
     * The constant pattern regex for the text breakdown into the word.
     */
    private static final Pattern PATTERN_FOR_WORD = Pattern.compile("\\"
            + "(*[A-Za-z'-]+\\)*");
    /**
     * The constant pattern regex for the text breakdown into the expression.
     */
    private static final Pattern PATTERN_FOR_EXPRESSION
            = Pattern.compile("[0-9~&|^><()]+");
    /**
     * The constant pattern regex for the text breakdown into the punctuation
     * mark.
     */
    private static final Pattern PATTERN_FOR_PUNCTUATION_MARK
            = Pattern.compile("[,.!?]+");

    /**
     * The constructor with one parameter.
     *
     * @param nextParser in line
     */
    public ParseLexeme(final Parser nextParser) {
        super(nextParser);
    }

    /**
     * Overriding the method for parsing lexeme into the word,
     * punctuation mark and expression.
     *
     * @param text            text to parse
     * @param compositeLexeme
     * @return
     */
    @Override
    public CompositeText parseData(final String text,
                                   final CompositeText compositeLexeme) {
        LOGGER.info("Parsing the sentence into the words, expression or the "
                + "punctuation mark.");

        Matcher matcherWord = PATTERN_FOR_WORD.matcher(text.trim());
        Matcher matcherExpression = PATTERN_FOR_EXPRESSION.matcher(text.trim());
        Matcher matcherPunctuationMark =
                PATTERN_FOR_PUNCTUATION_MARK.matcher(text.trim());

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

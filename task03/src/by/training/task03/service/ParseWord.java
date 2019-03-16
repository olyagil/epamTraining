package by.training.task03.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseWord extends Parser {
    //todo: кавычки куда? (слова, препинания)
    //todo: слово в скобочках

    private static final Logger LOGGER = LogManager.getLogger();
    private List<String> listWords;
    private List<String> listExpressions;
    private List<String> listPunctuationMarks;

    ParseWord() {
        listWords = new ArrayList<>();
        listExpressions = new ArrayList<>();
        listPunctuationMarks = new ArrayList<>();
    }

    private static final String REGEX_WORD = "[A-Za-z'\\-]+";
    private static final String REGEX_EXPRESSION = "[0-9~&|^><()]+";
    private static final String REGEX_PUNCTUATION_MARK = "[ ,.!?]+";

    @Override
    void parseData(String lexeme) {
        LOGGER.info("Parsing the sentence into the words, expression or the " +
                "punctuation mark.");
        Pattern patternWord = Pattern.compile(REGEX_WORD);
        Pattern patternExpression = Pattern.compile(REGEX_EXPRESSION);
        Pattern patternPunctuationMark = Pattern.compile(REGEX_PUNCTUATION_MARK);

        Matcher matcherWord = patternWord.matcher(lexeme.trim());
        Matcher matcherExpression = patternExpression.matcher(lexeme.trim());
        Matcher matcherPunctuationMark = patternPunctuationMark.matcher(lexeme.trim());

        if (matcherWord.find()) {
            listWords.add(matcherWord.group());
            if (matcherPunctuationMark.find()) {
                listPunctuationMarks.add(matcherPunctuationMark.group());
            }
        } else if (matcherExpression.find()) {
            listExpressions.add(matcherExpression.group());
        }

        LOGGER.info(listWords.size() + " words: " + listWords);
        LOGGER.info(listExpressions.size() + " expressions: " + listExpressions);
        LOGGER.info(listPunctuationMarks.size() + " punctuation marks: " + listPunctuationMarks);
        for (String word : listWords) {
            nextParser.parse(word);
        }
    }
}

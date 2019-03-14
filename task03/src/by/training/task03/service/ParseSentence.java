package by.training.task03.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseSentence extends Parser {
    //todo: regex for ...
    private static final Logger LOGGER = LogManager.getLogger();

    //    private static final String REGEX_SENTENCE = "[A-Z].+(\\.|!|\\?|" +
//            "\\.{3})";

    private static final String REGEX_SENTENCE = "[.!?]";
    private List<String> listSentence;

    ParseSentence() {
        listSentence = new ArrayList<>();
    }

    @Override
    void parseData(String paragraph) {

        LOGGER.info("Parsing the paragraph into the sentences. ");
        Pattern pattern = Pattern.compile(REGEX_SENTENCE);
        listSentence = Arrays.asList(pattern.split(paragraph.trim()));
        LOGGER.info(listSentence.size() + " sentences: " + listSentence);
//        for (String sentence : listSentence) {
//            nextParser.parse(sentence);
//        }
    }
}

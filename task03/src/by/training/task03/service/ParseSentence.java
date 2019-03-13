package by.training.task03.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ParseSentence extends Parser {
    private static final Logger LOGGER = LogManager.getLogger();

    //    private static final String REGEX_SENTENCE = "[A-Z].[.!?.{3}]";
    private static final String REGEX_SENTENCE = "[A-Z].+";

    List<String> listSentence;
    //    Parser next;
    Parser parseParagraph;

    ParseSentence(Parser parser) {
        listSentence = new ArrayList<>();
        this.parseParagraph = parser;
    }

    @Override
    void parseData(String text) {

        LOGGER.info("Parsing the paragraphs into the sentences. ");
        Pattern pattern = Pattern.compile(REGEX_SENTENCE);
        for (String paragraph : data) {
            Matcher matcher = pattern.matcher(paragraph);
            while (matcher.find()) {
                LOGGER.info(matcher.group());
                listSentence.add(matcher.group());
            }
        }
        LOGGER.info(listSentence);

    }
}

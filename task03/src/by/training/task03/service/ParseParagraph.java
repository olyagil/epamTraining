package by.training.task03.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParseParagraph extends Parser {
    private static final Logger LOGGER = LogManager.getLogger();
    private List<String> listParagraph;
    //    private static final String REGEX_PARAGRAPH = "^\t.$";
    private static final String REGEX_PARAGRAPH = "\t.+";

    public ParseParagraph() {
        listParagraph = new ArrayList<>();

    }

    @Override
    void parseData(String text) {
        LOGGER.info("Parsing the text into the paragraphs. ");
        Pattern pattern = Pattern.compile(REGEX_PARAGRAPH);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            listParagraph.add(matcher.group());
        }

        LOGGER.info(listParagraph.size() + " paragraphs: " + listParagraph);
        for (String paragraph : listParagraph) {
            nextParser.parse(paragraph);
        }
    }
}

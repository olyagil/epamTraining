package by.training.task03.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ParseLexeme extends Parser {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String REGEX_LEXEME = "\\s+";
    List<String> listLexeme;

    ParseLexeme() {
        listLexeme = new ArrayList<>();
    }

    @Override
    void parseData(String sentence) {
        LOGGER.info("Parsing the sentence into the lexemes.");
        Pattern pattern = Pattern.compile(REGEX_LEXEME);
        listLexeme = Arrays.asList(pattern.split(sentence.trim()));
        LOGGER.info(listLexeme.size() + " lexemes: " + listLexeme);

        for(String lexeme : listLexeme){
            nextParser.parse(lexeme);
        }
    }
}

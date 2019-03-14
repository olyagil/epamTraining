package by.training.task03.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ParseSymbol extends Parser {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String REGEX_SYMBOL = "";

    List<String> listSymbol;

    ParseSymbol() {
        listSymbol = new ArrayList<>();
    }

    @Override
    void parseData(String word) {
        LOGGER.info("Parsing the word into the symbol");
        Pattern pattern = Pattern.compile(REGEX_SYMBOL);
        listSymbol = Arrays.asList(pattern.split(word));
        LOGGER.info(listSymbol.size() + " symbols: " + listSymbol);
//        listSymbol =  Arrays.asList(word.toCharArray());
    }
}

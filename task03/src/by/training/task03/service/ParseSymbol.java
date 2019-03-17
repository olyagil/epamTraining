package by.training.task03.service;

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

public class ParseSymbol extends Parser {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String REGEX_SYMBOL = ".";
    private static final String REGEX_PUNC = ".!?";

    List<String> listSymbol;

    ParseSymbol() {
        listSymbol = new ArrayList<>();
    }

    @Override
    public Component parseData(String word) {
        LOGGER.info("Parsing the word into the symbol");

        CompositeText symbolComponent = new CompositeText(ComponentType.SYMBOL);
        Pattern pattern = Pattern.compile(REGEX_SYMBOL);
        Matcher matcher = pattern.matcher(word);

        while (matcher.find()) {
            listSymbol.add(matcher.group());
            symbolComponent.add(new Leaf(ComponentType.SYMBOL, matcher.group()));
        }
        LOGGER.info(listSymbol.size() + " symbols: " + listSymbol);
        System.out.println("SYMBOL COMPONENT: " + symbolComponent);
        return symbolComponent;
    }
}

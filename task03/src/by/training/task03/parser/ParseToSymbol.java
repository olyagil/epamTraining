package by.training.task03.parser;

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

public class ParseToSymbol extends Parser {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Pattern PATTERN_FOR_SYMBOL = Pattern.compile(".");

    private List<Character> listSymbol;

    public ParseToSymbol(final Parser nextParser) {
        super(nextParser);
        listSymbol = new ArrayList<>();
    }

    @Override
    public Component parseData(final String word,
                               final CompositeText compositeWord) {
//        LOGGER.info("Parsing into the symbol");
        Matcher matcher = PATTERN_FOR_SYMBOL.matcher(word);
        while (matcher.find()) {
            listSymbol.add((matcher.group().charAt(0)));
            compositeWord.add(new Leaf(ComponentType.SYMBOL,
                    (matcher.group().charAt(0))));
        }
//        LOGGER.info(listSymbol.size() + " symbols: " + listSymbol);
//        LOGGER.info("SYMBOL COMPONENT: " + compositeWord);
        return compositeWord;
    }
}

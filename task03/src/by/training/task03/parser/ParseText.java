package by.training.task03.parser;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseText extends Parser {
    private static final Logger LOGGER = LogManager.getLogger();
    List<String> paragraphList;
    private static final Pattern PATTERN_FOR_PARAGRAPH = Pattern.compile("[\t" +
            "\r\n].+");

    public ParseText(Parser nextParser) {
        super(nextParser);
        paragraphList = new ArrayList<>();
    }

    @Override
    public CompositeText parseData(final String text,
                                   final CompositeText compositeText) {

//        LOGGER.info("Parsing the text into the paragraphs.");
        Matcher matcher = PATTERN_FOR_PARAGRAPH.matcher(text);
        while (matcher.find()) {
            paragraphList.add(matcher.group());
            compositeText.add(parse(matcher.group(),
                    new CompositeText(ComponentType.PARAGRAPH)));
        }

        return compositeText;
    }

    public List<String> accept(Component component) {
        return paragraphList;
    }
}

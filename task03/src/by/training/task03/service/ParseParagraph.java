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

//todo: maybe change the view of the tad

public class ParseParagraph extends Parser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String TAB = "\n\t";
    private List<String> listParagraph;
    private static final String REGEX_PARAGRAPH = "[\t\r\n ]+.+";

    public ParseParagraph() {
        listParagraph = new ArrayList<>();
    }

    @Override
    public Component parseData(final String text) {

        LOGGER.info("Parsing the text into the paragraphs. ");
        CompositeText paragraphComponent =
                new CompositeText(ComponentType.PARAGRAPH);

        component.add(paragraphComponent);
        Pattern pattern = Pattern.compile(REGEX_PARAGRAPH);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            listParagraph.add(matcher.group());
            paragraphComponent.add(new Leaf(ComponentType.TAB, TAB),
                    parse(matcher.group()));
        }
        LOGGER.info("PARAGRAPH COMPONENT: " + paragraphComponent);
        LOGGER.info(listParagraph.size() + " paragraphs: " + listParagraph);
        return paragraphComponent;
    }
}

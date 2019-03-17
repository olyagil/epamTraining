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


public class ParseParagraph extends Parser {
    private static final Logger LOGGER = LogManager.getLogger();
    private List<String> listParagraph;
    //    private static final String REGEX_PARAGRAPH = "^.+?$";
    private static final String REGEX_PARAGRAPH = "[\t\r\n ]+.+";

    public ParseParagraph() {
        listParagraph = new ArrayList<>();

    }

    @Override
    public Component parseData(String text) {

        LOGGER.info("Parsing the text into the paragraphs. ");
        CompositeText paragraphComponent = new CompositeText(ComponentType.PARAGRAPH);

        component.add(paragraphComponent);
        Pattern pattern = Pattern.compile(REGEX_PARAGRAPH);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            listParagraph.add(matcher.group());
            paragraphComponent.add(new Leaf(ComponentType.TAB, "\n\t"),
                    parse(matcher.group()));
        }
        System.out.println("PARAGRAPH COMPONENT: " + paragraphComponent);
        LOGGER.info(listParagraph.size() + " paragraphs: " + listParagraph);
        return paragraphComponent;
    }
}

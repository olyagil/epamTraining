package by.training.task03.service;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ParseText extends Parser {
    private static final Logger LOGGER = LogManager.getLogger();
    private List<String> listParagraph;

    ParseText() {
        listParagraph = new ArrayList<>();
    }

    @Override
    public Component parseData(final String text) {
        LOGGER.info("Parsing the text. ");
        CompositeText textComponent = new CompositeText(ComponentType.TEXT);
        component.add(textComponent);

        textComponent.add(parse(text));

        LOGGER.info("TEXT COMPONENT: " + textComponent);
        LOGGER.info(listParagraph.size() + " text: " + listParagraph);
        return textComponent;
    }
}

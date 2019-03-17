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

public class ParseText extends Parser {
    private static final Logger LOGGER = LogManager.getLogger();
    private List<String> listParagraph;
    //    private static final String REGEX_PARAGRAPH = "^.+?$";
    private static final String REGEX_PARAGRAPH = "\t.+";

    public ParseText() {
        listParagraph = new ArrayList<>();

    }

    @Override
    public Component parseData(String text) {
                LOGGER.info("Parsing the text. ");
        CompositeText textComponent = new CompositeText(ComponentType.TEXT);
        component.add(textComponent);

        textComponent.add(parse(text));
        textComponent.add(new Leaf(ComponentType.TEXT, text));

        System.out.println("TEXT COMPONENT: "+textComponent);
        LOGGER.info(listParagraph.size()+" text: "+listParagraph);
        return textComponent;
}
}

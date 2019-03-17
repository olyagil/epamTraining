package by.training.task03.service;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import by.training.task03.composite.Leaf;
import javafx.css.Match;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseSentence extends Parser {
    //todo: regex for ...
    // todo: поменять, чтобы сохранялись знаки препинания в конце
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String REGEX_SENTENCE = "[A-Z].+?[.!?]";
    private List<String> listSentence;

    ParseSentence() {
        listSentence = new ArrayList<>();
    }

    @Override
    public Component parseData(String paragraph) {
        LOGGER.info("Parsing the paragraph into the sentences. ");

        CompositeText sentenceComponent = new CompositeText(ComponentType.SENTENCE);
        component.add(sentenceComponent);
        Pattern pattern = Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = pattern.matcher(paragraph);
        while (matcher.find()) {
            listSentence.add(matcher.group());
            sentenceComponent.add(parse(matcher.group()));
//            sentenceComponent.add(new Leaf(ComponentType.SENTENCE, matcher.group()));
        }
        LOGGER.info(listSentence.size() + " sentences: " + listSentence);
        System.out.println("SENTENCE COMPONENT: " + sentenceComponent);
        return sentenceComponent;
    }
}

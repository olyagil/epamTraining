package by.training.task03.action;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//TODO make 3 task
//TODO refactor 1 and 2 task
//TODO create test
//TODO consider visitor pattern
public class Action {

    private static final Logger LOGGER = LogManager.getLogger();


    public CompositeText sortParagraphByNumberOfSentence(CompositeText compositeText) {
        CompositeText newCompositeText = new CompositeText(ComponentType.TEXT);
        if (compositeText.getType() == ComponentType.TEXT) {
            CompositeText paragraph;
            List<Component> componentList = new ArrayList<>();
            LOGGER.info(compositeText.getSize());
            for (int i = 0; i < compositeText.getSize(); i++) {
                paragraph = (CompositeText) compositeText.getChildren().get(i);
                componentList.add(paragraph);
                LOGGER.info("Para #" + i + " : " + paragraph.getSize() +
                        " sentences");
            }
//            LOGGER.info(componentList);
            componentList.sort(Comparator.comparingInt(Component::getSize));
//            LOGGER.info(componentList);
            for (Component component : componentList) {
                newCompositeText.add(component);
            }
        } else {
            LOGGER.warn("The incorrect type " + compositeText.getType());
        }
        return newCompositeText;
    }

    //TODO change to sorting by lexeme, but not words
    public CompositeText sortSentencesByLengthOfLexeme(CompositeText compositeSentence) {
        CompositeText newCompositeSentence =
                new CompositeText(ComponentType.SENTENCE);
        List<Component> lexemeList = new ArrayList<>();
        if (compositeSentence.getType() == ComponentType.SENTENCE) {
            CompositeText lexeme;
            for (int i = 0; i < compositeSentence.getSize(); i++) {
                lexeme = (CompositeText) compositeSentence.getChildren(i);
                for (int j = 0; j < lexeme.getSize(); j++) {
                    if (lexeme.get(j).getType() == ComponentType.WORD) {
                        lexemeList.add(lexeme.get(j));
                    }
                }
            }
            lexemeList.sort(Comparator.comparing(Component::getSize));
            for (Component component : lexemeList) {
                newCompositeSentence.add(component);
            }
//            LOGGER.info(newCompositeSentence);
        } else {
            LOGGER.warn("The incorrect type " + compositeSentence.getType());
        }
        return newCompositeSentence;
    }

    public CompositeText sortLexeme(CompositeText compositeSentence, char ch) {
        CompositeText newCompositeText =
                new CompositeText(ComponentType.SENTENCE);
        List<CompositeText> lexemeList = new ArrayList<>();
        CompositeText lexeme;
        if (compositeSentence.getType() == ComponentType.SENTENCE) {
            for (int i = 0; i < compositeSentence.getSize(); i++) {
                lexeme = (CompositeText) compositeSentence.getChildren(i);
                lexemeList.add(lexeme);

            }
        } else {
            LOGGER.warn("The incorrect type " + compositeSentence.getType());
        }

        lexemeList.sort(((Comparator<CompositeText>)
                (o1, o2) -> Integer.compare(countOfSymbol(o1, ch),
                        countOfSymbol(o2, ch))).thenComparing(Comparator.comparing(o -> o.toString())));
        for (Component component : lexemeList) {
            newCompositeText.add(component);
        }
        LOGGER.info(newCompositeText);


        return newCompositeText;
    }

    public int countOfSymbol(CompositeText composite, Character ch) {
        int result = 0;
        for (int i = 0; i < composite.getSize(); i++) {
            result += countOfSymbol(composite.get(i), ch);
        }
        return result;
    }


}

package by.training.task03.action;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Action {
    private static final CompositeClone CLONE = new CompositeClone();

    private static final Logger LOGGER = LogManager.getLogger();

    public Component sortParagraphByNumberOfSentence(Component compositeText) {
        LOGGER.info("Sorting paragraphs by the number of sentence.");

        Component clonedComposite = CLONE.clone(compositeText);
        Component sortedCompositeText = new CompositeText(ComponentType.TEXT);
        List<Component> componentList = new ArrayList<>();

        for (int i = 0; i < clonedComposite.getSize(); i++) {
            componentList.add(clonedComposite.getChild(i));
        }
        componentList.sort(Comparator.comparingInt(Component::getSize));
        for (Component component : componentList) {
            sortedCompositeText.add(component);
        }
        return sortedCompositeText;
    }

    private List<Component> getLexeme(CompositeText compositeText) {

        List<Component> listLexeme = new ArrayList<>();

        if (ComponentType.SENTENCE.equals(compositeText.getType())) {
            for (int i = 0; i < compositeText.getSize(); i++) {
                listLexeme.add(compositeText.getChild(i));
            }
        } else {
            for (int i = 0; i < compositeText.getSize(); i++) {
                listLexeme.addAll(getLexeme((CompositeText) compositeText.getChild(i)));
            }
        }
        return listLexeme;
    }

    public Component sortSentencesByLengthOfLexeme(Component component) {

        Component clonedComposite = CLONE.clone(component);
        Component sortedCompositeSentence =
                new CompositeText(ComponentType.SENTENCE);
        List<Component> lexemeList = getLexeme((CompositeText) clonedComposite);
        lexemeList.sort(Comparator.comparingInt(lexeme ->
                lexeme.toString().length()));

        for (Component lexeme : lexemeList) {
            sortedCompositeSentence.add(lexeme);
        }
        return sortedCompositeSentence;
    }


    public Component sortLexeme(Component compositeText, char ch) {
        CompositeText sortedCompositeText =
                new CompositeText(ComponentType.SENTENCE);
        List<Component> lexemeList = getLexeme((CompositeText) compositeText);

        lexemeList.sort((lexeme1, lexeme2) -> {
            String str1 = lexeme1.toString();
            String str2 = lexeme2.toString();
            int count1 = countOfSymbol(str1, ch);
            int count2 = countOfSymbol(str2, ch);
            if (count1 > count2) {
                return -1;
            }
            if (count1 == count2) {
                return str1.compareToIgnoreCase(str2);
            }
            return 1;
        });

        for (Component component : lexemeList) {
            sortedCompositeText.add(component);
        }
        return sortedCompositeText;
    }

    private int countOfSymbol(String string, Character ch) {
        int result = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.toLowerCase().charAt(i) == ch) {
                result++;
            }
        }
        return result;
    }
}

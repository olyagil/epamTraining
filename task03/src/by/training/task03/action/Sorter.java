package by.training.task03.action;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The {@code Sorter} is used for sorting the composite text.
 */
public class Sorter {
    /**
     * The constant for cloning the composite text.
     */
    private static final ComponentCloner CLONE = new ComponentCloner();
    /**
     * The constant for logging.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Method for sorting paragraphs by the number of the sentences.
     *
     * @param compositeText text which needed to be sorted
     * @return sorted text
     */
    public Component sortParagraphByNumberOfSentence(final Component
                                                             compositeText) {
        LOGGER.info("Sorting paragraphs by the number of sentence.");

        Component clonedComposite = CLONE.clone(compositeText);
        List<Component> componentList = new ArrayList<>();
        Component sortedCompositeText = new CompositeText(ComponentType.TEXT);

        for (int i = 0; i < clonedComposite.getSize(); i++) {
            componentList.add(clonedComposite.getChild(i));
        }
        componentList.sort(Comparator.comparingInt(Component::getSize));
        for (Component component : componentList) {
            sortedCompositeText.add(component);
        }
        return sortedCompositeText;
    }

    /**
     * Method for getting the list of lexemes from the text.
     *
     * @param compositeText given text
     * @return list of lexemes
     */
    private List<Component> getLexeme(final Component compositeText) {
        LOGGER.info("Getting the list of lexemes from the text.");
        List<Component> listLexeme = new ArrayList<>();

        if (ComponentType.SENTENCE.equals(compositeText.getType())) {
            for (int i = 0; i < compositeText.getSize(); i++) {
                listLexeme.add(compositeText.getChild(i));
            }
        } else {
            for (int i = 0; i < compositeText.getSize(); i++) {
                listLexeme.addAll(getLexeme(compositeText.getChild(i)));
            }
        }
        return listLexeme;
    }

    /**
     * Method for sorting lexemes by the length.
     *
     * @param component text which needed to be sorted
     * @return sorted text
     */
    public Component sortSentencesByLengthOfLexeme(final Component component) {
        LOGGER.info("Sorting lexemes by the length.");

        Component clonedComposite = CLONE.clone(component);
        Component sortedCompositeSentence =
                new CompositeText(ComponentType.SENTENCE);
        List<Component> lexemeList = getLexeme(clonedComposite);
        lexemeList.sort(Comparator.comparingInt(lexeme ->
                lexeme.toString().length()));

        for (Component lexeme : lexemeList) {
            sortedCompositeSentence.add(lexeme);
        }
        return sortedCompositeSentence;
    }

    /**
     * Method for sorting the lexemes by the number of entered symbol.
     * If the number of symbols is equals the sort alphabetically.
     *
     * @param compositeText text which needed to be sorted
     * @param ch            given symbol
     * @return sorted text
     */
    public Component sortLexeme(final Component compositeText, final char ch) {
        CompositeText sortedCompositeText =
                new CompositeText(ComponentType.SENTENCE);
        List<Component> lexemeList = getLexeme(compositeText);

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

    /**
     * Method which counts the number of given symbol.
     *
     * @param lexeme the lexeme which is viewed
     * @param symbol given symbol
     * @return the number of characters encountered
     */
    private int countOfSymbol(final String lexeme, final Character symbol) {
        LOGGER.info("Counting the number of symbol: " + symbol
                + " in the lexeme: " + lexeme);
        int count = 0;
        for (int i = 0; i < lexeme.length(); i++) {
            if (lexeme.toLowerCase().charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }
}

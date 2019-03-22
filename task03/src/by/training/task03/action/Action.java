package by.training.task03.action;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Action {

    private static final Logger LOGGER = LogManager.getLogger();


    public void sortParagraphByNumberOfSentence(CompositeText compositeText) {
        if (compositeText.getType() == ComponentType.TEXT) {

            CompositeText paragraph;
            List<Component> componentList = new ArrayList<>();
            CompositeText newCompositeText = new CompositeText(ComponentType.TEXT);
            LOGGER.info(compositeText.getSize());
            for (int i = 0; i < compositeText.getSize(); i++) {
                paragraph = (CompositeText) compositeText.getComponentList().get(i);
                componentList.add(paragraph);
                LOGGER.info("Para #" + i + " : " + paragraph.getSize() +
                        " sentences");
            }
            LOGGER.info(componentList);
            componentList.sort(Comparator.comparingInt(Component::getSize));
            LOGGER.info(componentList);
            for (Component component : componentList) {
                newCompositeText.add(component);
            }
            LOGGER.info(newCompositeText);
        }
    }


//    public void sortParagraphByNumberOfSentence(CompositeText compositeText) {
//
//        CompositeText newCompositeText = new CompositeText(ComponentType.TEXT);
//        LOGGER.info(compositeText.getSize());
//        for (int i = 0; i < compositeText.getSize(); i++) {
//            newCompositeText.add(compositeText.getChildren(i));
//        }
//        LOGGER.info(newCompositeText.getType() + " " + newCompositeText.getSize() +
//                " : " + newCompositeText);
////        for (int i = 0; i < compositeText.getSize(); i++) {
////            CompositeText paragraph =
////                    (CompositeText) newCompositeText.getComponentList().get(i);
////            System.out.println("Para #" + i + " : " + paragraph.getSize() +
////                    " sentences");
////            for (int j = 0; j < paragraph.getSize(); j++) {
////                CompositeText sentence =
////                        (CompositeText) paragraph.getChildren(j);
////                System.out.println(sentence);
////                for (int z = 0; z < sentence.getSize(); z++) {
////                    CompositeText lexeme =
////                            (CompositeText) sentence.getChildren(z);
////                    System.out.println(lexeme.getSize() + " : " + lexeme);
////                }
////            }
////        }
//
//        System.out.println(compositeText.getComponentList());
//
//    }
}

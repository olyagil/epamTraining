package by.training.task03.service;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import by.training.task03.composite.Leaf;

import java.util.List;

public abstract class Parser {
    CompositeText component = new CompositeText(ComponentType.TEXT);
    Parser nextParser;
    String data;

    Parser setNextParser(Parser parser) {
        nextParser = parser;
        return nextParser;
    }

    Component parse(String text) {
        if (nextParser == null) {
            return new Leaf(ComponentType.SYMBOL, text);
        }
//         parseData(text);
//        }
        return nextParser.parseData(text);
    }

    public abstract Component parseData(String data);

}

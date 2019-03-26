package by.training.task03.parser;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;

import java.util.List;

public abstract class Parser {
    private Parser nextParser;

    Parser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    public Component parse(String text, CompositeText compositeText) {
        if (compositeText.getType() == ComponentType.TEXT) {
            return parseData(text, compositeText);
        }
        return nextParser.parseData(text, compositeText);
    }

    public abstract CompositeText parseData(String data,
                                            CompositeText compositeText);

//    public abstract List<String> accept(Component component);

}




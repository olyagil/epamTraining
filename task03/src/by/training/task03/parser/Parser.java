package by.training.task03.parser;

//todo: изменить метод parse. Чтоб можно было удалить класс Text, при этом
// вызывая класс Paragraph первым.

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;

public abstract class Parser {
//    CompositeText component = new CompositeText(ComponentType.TEXT);
    private Parser nextParser;

    public void setNextParser(final Parser parser) {
        nextParser = parser;
    }

    Parser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    public Component parse(final String text, final CompositeText compositeText) {
        if (nextParser == null) {
        }
        return nextParser.parseData(text, compositeText);
    }

    public abstract Component parseData(String data, CompositeText compositeText);
}




package by.training.task03.service;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;

    //todo: изменить метод parse. Чтоб можно было удалить класс Text, при этом
    // вызывая класс Paragraph первым.
public abstract class Parser {
    CompositeText component = new CompositeText(ComponentType.TEXT);
    private Parser nextParser;

    void setNextParser(final Parser parser) {
        nextParser = parser;
    }

    Component parse(final String text) {
        return nextParser.parseData(text);
    }

    public abstract Component parseData(String data);

}

package by.training.task03.service;

public abstract class Parser {

    Parser nextParser;

    void setNextParser(Parser parser) {
        nextParser = parser;
    }

    void parse(String text) {
        parseData(text);
        if (nextParser != null) {
            nextParser.parse(text);
        }
    }

    abstract void parseData(String data);

}

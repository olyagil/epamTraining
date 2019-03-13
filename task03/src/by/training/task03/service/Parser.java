package by.training.task03.service;

import java.util.ArrayList;
import java.util.List;

public abstract class Parser {

    Parser nextParser;
    List<String> data;

    void setNextParser(Parser parser) {
        nextParser = parser;
    }

    void parse(String dataString) {
//        data = new ArrayList<>();
        parseData(dataString);
        if (nextParser != null) {
            nextParser.parse(dataString);
        }
    }

    abstract void parseData(String data);

}

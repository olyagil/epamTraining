//package by.training.task03.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ParseLexeme implements Parser {
//
//    private static final String REGEX_LEXEME = "\\s+";
//    List<String> listLexeme;
//    Parser next;
//
//    ParseLexeme(List<String> listSentence) {
//        listLexeme = new ArrayList<>();
//    }
//
//    @Override
//    public Parser setNext(String data) {
//        return next.setNextParser(data);
//    }
//
//    @Override
//    public String handleRequest() {
//        return null;
//    }
//}

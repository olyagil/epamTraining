package by.training.task03.composite;

public enum ComponentType {
    //todo: изменить конструктор
    TEXT(""),
    PARAGRAPH("\n\t"),
    SENTENCE(""),
    LEXEME(" "),
    WORD(""),
    EXPRESSION(""),
    PUNCTUATION_MARK(""),
    SYMBOL("");

    ComponentType() {

    }

    private String delimiter;

    public String getDelimiter() {
        return delimiter;
    }

    ComponentType(String delimiter) {
        this.delimiter = delimiter;
    }
}

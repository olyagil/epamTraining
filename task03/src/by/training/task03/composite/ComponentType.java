package by.training.task03.composite;

public enum ComponentType {
    //todo: изменить конструктор
    TEXT("\n\t"),
    PARAGRAPH(""),
    SENTENCE(" "),
    LEXEME(""),
    WORD(""),
    EXPRESSION(""),
    PUNCTUATION_MARK(""),
    SYMBOL("");

    private String delimiter;

    public String getDelimiter() {
        return delimiter;
    }

    ComponentType(final String delimiter) {
        this.delimiter = delimiter;
    }
}

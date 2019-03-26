package by.training.task03.parser;

import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import by.training.task03.exception.ReadFileException;
import by.training.task03.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.*;


public class ParseLexemeTest {

    private static final String PATH = "data//lab3-text.txt";
    private Parser parser;
    private DataReader dataReader;
    private CompositeText compositeText;

    /**
     * Composite of the first lexeme in the text
     */
    private CompositeText composite;

    @BeforeClass
    public void setUp() throws ReadFileException {
        dataReader = new DataReader();
        parser = new ParseLexeme(new ParseToSymbol(null));
        compositeText = new CompositeText(ComponentType.LEXEME);
        String text = dataReader.readFromFile(PATH);
        composite = parser.parseData(text, compositeText);
    }

    @AfterClass
    public void tearDown() {
        dataReader = null;
        parser = null;
        compositeText = null;
    }

    //parsing lexeme into word and punctuation mark
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][]{
                {composite.getChild(0), 2},
                {composite.getChild(1), 1},
        };
    }

    @Test(dataProvider = "data")
    public void testParseData(CompositeText compositeLexeme, int expected) {
        int actual = compositeLexeme.getSize();
        Assert.assertEquals(actual, expected);
    }
}
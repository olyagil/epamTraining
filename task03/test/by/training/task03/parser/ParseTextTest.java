package by.training.task03.parser;

import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import by.training.task03.exception.ReadFileException;
import by.training.task03.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParseTextTest {
    private Parser parser;
    private DataReader dataReader;
    private CompositeText compositeText;

    @BeforeMethod
    public void setUp() {
        dataReader = new DataReader();
        parser = new ParseText(new ParseParagraph(new ParseSentence
                (new ParseLexeme(new ParseToSymbol(null)))));
        compositeText = new CompositeText(ComponentType.TEXT);
    }

    @AfterClass
    public void tearDown() {
        dataReader = null;
        parser = null;
        compositeText = null;
    }

    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][]{
                {"data//lab3-text.txt", 4},
                {"data//test_data.txt", 1},
                {"data//test.txt", 2},
        };
    }

    @Test(dataProvider = "data")
    public void testParseData(String path, int expected) throws ReadFileException {
        String text = dataReader.readFromFile(path);
        CompositeText composite = parser.parseData(text, compositeText);
        int actual = composite.getSize();
        Assert.assertEquals(actual, expected);
    }
}
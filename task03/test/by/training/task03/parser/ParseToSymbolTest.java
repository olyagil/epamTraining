package by.training.task03.parser;

import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import by.training.task03.exception.ReadFileException;
import by.training.task03.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParseToSymbolTest {
    private Parser parser;
    private DataReader dataReader;
    private CompositeText compositeText;

    @BeforeMethod
    public void setUp() {
        dataReader = new DataReader();
        parser = new ParseToSymbol(null);
        compositeText = new CompositeText(ComponentType.SYMBOL);
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
                {"data//lab3-text.txt", 854},
                {"data//test_data.txt", 47},
                {"data//test.txt", 72},
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

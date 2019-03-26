package by.training.task03.action;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import by.training.task03.exception.ReadFileException;
import by.training.task03.parser.ParseLexeme;
import by.training.task03.parser.ParseParagraph;
import by.training.task03.parser.ParseSentence;
import by.training.task03.parser.ParseToSymbol;
import by.training.task03.parser.Parser;
import by.training.task03.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ComponentClonerTest {

    private Component component;
    private CompositeText compositeText;

    private ComponentCloner cloner;
    private Parser parser;
    private DataReader dataReader;

    @BeforeMethod
    public void setInitialComponent() {
        cloner = new ComponentCloner();
        compositeText = new CompositeText(ComponentType.TEXT);
        parser = new ParseParagraph(new ParseSentence
                (new ParseLexeme(new ParseToSymbol(null))));
        dataReader = new DataReader();
    }

    @AfterMethod
    public void tearDown() {
        cloner = null;
        compositeText = null;
        parser = null;
        dataReader = null;
    }

    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][]{
                {"data//lab3-text.txt"},
                {"data//test_data.txt"},
                {"data//test.txt"},
        };
    }


    @Test(dataProvider = "data")
    public void testClone(String path) throws ReadFileException {
        String text = dataReader.readFromFile(path);
        component = parser.parseData(text, compositeText);
        Component clonedComponent = cloner.clone(component);
        Assert.assertEquals(component, clonedComponent);
    }
}

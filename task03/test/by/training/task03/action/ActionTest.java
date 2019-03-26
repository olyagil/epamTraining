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

import static org.testng.Assert.*;

public class ActionTest {
    private Component component;
    private CompositeText compositeText;
    private Parser parser;
    private DataReader dataReader;
    private Action action;

    @BeforeMethod
    public void setInitialComponent() {
        compositeText = new CompositeText(ComponentType.TEXT);
        parser = new ParseParagraph(new ParseSentence
                (new ParseLexeme(new ParseToSymbol(null))));
        dataReader = new DataReader();
        action = new Action();
    }

    @AfterMethod
    public void tearDown() {
        compositeText = null;
        parser = null;
        dataReader = null;
        action = null;
    }

    @DataProvider(name = "dataForSortingParagraphByNumberOfSentence")
    public Object[][] dataForSortingParagraphByNumberOfSentence() {
        return new Object[][]{
                {"data//lab3-text.txt", "\n"
                        + "\t Bye.\n"
                        + "\t It is a 1274, established fact that a reader will "
                        + "be of a page when looking at its layout.\n"
                        + "\t It has survived - not only (five) centuries, but "
                        + "also the leap into 52 electronic typesetting, "
                        + "remaining 3 essentially 9 unchanged.\n"
                        + "\t It is a long established fact that a reader will "
                        + "be distracted by the readable content of a page when"
                        + " looking at its layout...\n"
                        + "\t The point of using 78 Ipsum is that it has a"
                        + " more-or-less normal distribution of letters, as "
                        + "opposed to using (Content here), content here', mak"
                        + "ing it look like readable English.\n"
                        + "\t It was popularised in the 5 with the release of "
                        + "Letraset sheets containing Lorem Ipsum passages, and"
                        + " more recently with desktop publishing software like"
                        + " Aldus PageMaker including versions of Lorem Ipsum."},
                {"data//test_data.txt", "\n"
                        + "\t This is a test for reading a text from file."},
                {"data//test.txt", "\n"
                        + "\t This is a test.\n"
                        + "\t The girl has 12 mouses.\n"
                        + "\t The boy loves dogs, cats."},
        };
    }

    @Test(dataProvider = "dataForSortingParagraphByNumberOfSentence")
    public void testSortParagraphByNumberOfSentence(String path,
                                                    String expected)
            throws ReadFileException {

        String text = dataReader.readFromFile(path);
        component = parser.parseData(text, compositeText);
        Component actual = action.sortParagraphByNumberOfSentence(component);
        Assert.assertEquals(actual.toString(), expected);
    }

    @DataProvider(name = "dataForSortingSentencesByLengthOfLexeme")
    public Object[][] dataForSortingSentencesByLengthOfLexeme() {
        return new Object[][]{
                {"data//lab3-text.txt", " - 3 9 5 a a a a a a a It 52 It in "
                        + "of of It is be by of at of 78 is it of as to it It "
                        + "is be of at has not but the was the the and the its "
                        + "The has its only also leap into with more with like"
                        + " long fact that will page when that look like fact"
                        + " that will page when Bye. Lorem Ipsum Aldus Lorem"
                        + " point using Ipsum using 1274, (five) sheets Ipsum."
                        + " reader normal here), here', making reader release"
                        + " desktop content looking opposed content looking"
                        + " layout. survived Letraset recently software versi"
                        + "ons readable letters, (Content readable English. "
                        + "remaining passages, PageMaker including layout... "
                        + "centuries, electronic unchanged. containing publish"
                        + "ing distracted essentially popularised established"
                        + " established typesetting, more-or-less distribution"},
                {"data//test_data.txt",
                        " a a is for This test text from file. reading"},
                {"data//test.txt", " a 12 is The has The boy girl This test."
                        + " loves dogs, cats. mouses."},
        };
    }

    @Test(dataProvider = "dataForSortingSentencesByLengthOfLexeme")
    public void testSortSentencesByLengthOfLexeme(String path,
                                                  String expected)
            throws ReadFileException {

        String text = dataReader.readFromFile(path);
        component = parser.parseData(text, compositeText);
        Component actual = action.sortSentencesByLengthOfLexeme(component);
        Assert.assertEquals(actual.toString(), expected);
    }

    @DataProvider(name = "dataForSortingLexeme")
    public Object[][] dataForSortingLexeme() {
        return new Object[][]{
                {"data//lab3-text.txt", 'q', " (Content (five) - 1274, 3 5 52"
                        + " 78 9 a a a a a a a Aldus also and as at at be be "
                        + "but by Bye. centuries, containing content content "
                        + "desktop distracted distribution electronic English."
                        + " essentially established established fact fact has "
                        + "has here', here), in including into Ipsum Ipsum Ips"
                        + "um. is is is It It It it it It its its layout. layo"
                        + "ut... leap Letraset letters, like like long look"
                        + " looking looking Lorem Lorem making more more-or-l"
                        + "ess normal not of of of of of of only opposed page "
                        + "page PageMaker passages, point popularised publishi"
                        + "ng readable readable reader reader recently release"
                        + " remaining sheets software survived that that that "
                        + "the the the the The to typesetting, unchanged. using"
                        + " using versions was when when will will with with"},
                {"data//test_data.txt", 'n',
                        " reading a a file. for from is test text This"},
                {"data//test.txt", 'a', " a cats. has 12 boy dogs, girl is"
                        +                        " loves mouses. test. The The This"},
        };
    }

    @Test(dataProvider = "dataForSortingLexeme")
    public void testSortLexeme(String path, char ch, String expected) throws ReadFileException {

        String text = dataReader.readFromFile(path);
        component = parser.parseData(text, compositeText);
        Component actual = action.sortLexeme(component, ch);
        System.out.println(actual);
        Assert.assertEquals(actual.toString(), expected);
    }

}
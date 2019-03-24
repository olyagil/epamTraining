package by.training.task03.action;

import by.training.task03.composite.Component;
import by.training.task03.composite.CompositeText;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ActionTest {

    @BeforeMethod
    public void setUp() {
        CompositeText compositeText;
    }

    @AfterMethod
    public void tearDown() {
    }

    @DataProvider(name = "dataForSorting")
    public Object[][] data() {
        return new Object[][]{
                {"\tIt has survived - not only (five) centuries, but also the"
                        + " leap into 13<<2 electronic typesetting, remaining "
                        + "30>>>3 essentially ~6&9|(3&4) unchanged. It was "
                        + "popularised in the 5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1)"
                        + " with the release of Letraset sheets containing "
                        + "Lorem Ipsum passages, and more recently with desktop"
                        + " publishing software like Aldus PageMaker including "
                        + "versions of Lorem Ipsum.\t\n"
                        + "\tIt is a long established fact that a reader will "
                        + "be distracted by the readable content of a page when "
                        + "looking at its layout... The point of using "
                        + "(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that "
                        + "it has a more-or-less normal distribution of letters,"
                        + " as opposed to using (Content here), content here', "
                        + "making it look like readable English.\n"
                        + "\tIt is a (111^5|1&2<<(2|5>>2&71))|1200, established"
                        + " fact that a reader will be of a page when looking "
                        + "at its layout.\n\tBye.\n",
                }};
    }

    @Test
    public void testSortParagraphByNumberOfSentence(String text,
                                                    String expected) {
//        String actual = ;
//                assertEquals(actual, expected);
        System.out.println();

    }
}
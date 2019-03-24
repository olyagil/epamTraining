package by.training.task03.reader;

import by.training.task03.exception.ReadFileException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataReaderTest {
    private DataReader dataReader;

    @BeforeClass
    public void setUp() {
        dataReader = new DataReader();
    }

    @DataProvider(name = "inputDataForReadingFile")
    public Object[][] createCorrectDataForArea() {
        return new Object[][]{
                {"\tIt has survived - not only (five) centuries, but also the"
                        + " leap into 13<<2 electronic typesetting, remaining"
                        + " 30>>>3 essentially ~6&9|(3&4) unchanged. It was "
                        + "popularised in the 5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1)"
                        + " with the release of Letraset sheets containing "
                        + "Lorem Ipsum passages, and more recently with desktop"
                        + " publishing software like Aldus PageMaker including"
                        + " versions of Lorem Ipsum.\n"
                        + "\tIt is a long established fact that a reader will "
                        + "be distracted by the readable content of a page when"
                        + " looking at its layout... The point of using "
                        + "(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that"
                        + " it has a more-or-less normal distribution of letter"
                        + "s, as opposed to using (Content here), content "
                        + "here', making it look like readable English.\n\t"
                        + "It is a (111^5|1&2<<(2|5>>2&71))|1200, established"
                        + " fact that a reader will be of a page when looking"
                        + " at its layout.\n\tBye.\n", "data//lab3-text.txt"},
                {"This is a test for reading a text from file.",
                        "data//test_data.txt"},
        };
    }

    /**
     * This test will check if the data is correctly read from file.
     *
     * @param expected string which holds a text from file
     * @param path     path tj the file
     * @throws ReadFileException thrown when can't read from file
     */
    @Test(description = "The wrong and positive scenario of reading file",
            dataProvider = "inputDataForReadingFile")
    public void testReadDataFromFile(String expected, String path) throws
            ReadFileException {
        String actual = dataReader.readFromFile(path);
        Assert.assertEquals(actual, expected);
    }
}
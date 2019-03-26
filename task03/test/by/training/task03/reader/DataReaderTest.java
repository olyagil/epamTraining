package by.training.task03.reader;

import by.training.task03.exception.ReadFileException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataReaderTest {
    private DataReader dataReader;

    @BeforeMethod
    public void setUp() {
        dataReader = new DataReader();
    }

    @AfterMethod
    public void tearDown() {
        dataReader = null;
    }

    @DataProvider(name = "inputDataForReadingFile")
    public Object[][] createCorrectDataForArea() {
        return new Object[][]{
                {"\tThis is a test for reading a text from file.\n",
                        "data//test_data.txt"},
                {"\tThe girl has 3<<2 mouses. This is a test."
                        + "\tThe boy loves dogs, cats.", "data//test.txt"},
        };
    }

    /**
     * This test will check if the data is correctly read from file.
     *
     * @param expected string which holds a text from file
     * @param path     path to the file
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
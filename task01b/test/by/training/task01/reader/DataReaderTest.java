package by.training.task01.generator.training.task01.reader;

import by.training.task01.generator.training.task01.exception.ReadFileException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private static final String TEST_DATA_FILE_PATH = "testdata//testdata.txt";
    private final DataReader dataReader = new DataReader();

    @DataProvider(name = "inputDataForReadingFile")
    public Object[][] createCorrectDataForArea() {
        return
                new Object[][]{
                        {Arrays.asList("1.0   2.0 3.0",
                                "5.0 6.0     7.0",
                                "test",
                                " t   e   s   t",
                                "6.0 7.0 0.0",
                                "7.0 9.0",
                                "2.0  6.0   4.0   9.0")}
                };
    }

    @Test(description = "The wrong and positive scenario of reading file",
            dataProvider = "inputDataForReadingFile")
    public void testReadDataFromFile(List<String> expected) throws
            ReadFileException {
        List<String> actual = dataReader.readDataFromFile(TEST_DATA_FILE_PATH);
        Assert.assertEquals(actual, expected);
    }
}
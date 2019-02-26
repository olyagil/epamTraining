package by.training.task01.parser;

import by.training.task01.exception.ReadFileException;
import by.training.task01.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParserTest {

    private static final String TEST_DATA_FILE_PATH = "testdata//testdata.txt";
    private final DataReader dataReader = new DataReader();
    DataParser dataParser = new DataParser();

    @DataProvider(name = "dataForParse")
    public Object[][] dataForParse() {
        return
                new Object[][]{
                        {Arrays.asList(new ArrayList<>
                                        (Arrays.asList(1.0, 2.0, 3.0)),
                                new ArrayList<>
                                        (Arrays.asList(5.0, 6.0, 7.0)),
                                new ArrayList<>
                                        (Arrays.asList(1.0, 15.0, 6.0)),
                                new ArrayList<>
                                        (Arrays.asList(0.0, 0.0, 1.0))
                        )}
                };
    }

    @Test(description = "The scenario of the data parsing", dataProvider =
            "dataForParse")
    public void testParser(List<List<Double>> expected) throws ReadFileException {
        List<List<Double>> actual = dataParser
                .parseData(dataReader.readDataFromFile(TEST_DATA_FILE_PATH));
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
    }
}
package by.training.task01.parser;

import by.training.task01.entity.Circle;
import by.training.task01.entity.Point;
import by.training.task01.exception.ReadFileException;
import by.training.task01.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DataParserTest {

    private static final String TEST_DATA_FILE_PATH = "testdata//testdata.txt";
    private final DataReader dataReader = new DataReader();
    DataParser dataParser = new DataParser();

    @DataProvider(name = "dataForParse")
    public Object[][] dataForParse() {
        // List<Circle> circles = new ArrayList<>();
        return new Object[][]{{Arrays.asList(new Circle(new Point(1.0, 2.0), 3.0),
                new Circle(new Point(5.0, 6.0), 7))
        }
        };
    }

    @Test(description = "The scenario of the data parsing", dataProvider =
            "dataForParse")
    public void testParser(List<String> expected) throws ReadFileException {
        List<String> data = dataReader.readDataFromFile(TEST_DATA_FILE_PATH);
        List<Circle> actual = dataParser.parseData(data);
        Assert.assertEquals(actual, expected);
    }
}
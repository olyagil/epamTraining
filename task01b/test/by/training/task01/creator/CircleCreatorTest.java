package by.training.task01.creator;

import by.training.task01.entity.Circle;
import by.training.task01.entity.Point;
import by.training.task01.exception.ReadFileException;
import by.training.task01.parser.DataParser;
import by.training.task01.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircleCreatorTest {

    private static final String TEST_DATA_FILE_PATH = "testdata//testdata.txt";
    private final DataReader dataReader = new DataReader();
    DataParser dataParser = new DataParser();
    CircleCreator circleCreator = new CircleCreator();

    @DataProvider(name = "dataForParsing")
    public Object[][] dataForParse() {
        return new Object[][]{{Arrays.asList(new Circle(new Point(1.0,
                        2.0), 3.0),
                new Circle(new Point(5.0, 6.0), 7),
                new Circle(new Point(1.0, 15.0), 6.0),
                new Circle(new Point(0.0, 0.0), 1.0)
        )
        }
        };
    }

    @Test(description = "The scenario of the circle creating", dataProvider =
            "dataForParsing")
    public void testCreateCircle(List<Circle> expected) throws ReadFileException {
        List<Circle> actual = circleCreator.createCircle(dataParser
                .parseData(dataReader.readDataFromFile(TEST_DATA_FILE_PATH)));
        Assert.assertEquals(actual, expected);
    }
}
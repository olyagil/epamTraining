/**
 * The parser package is used to parse the data.
 */
package by.training.task01.parser;

import by.training.task01.entity.Circle;
import by.training.task01.entity.Point;
import by.training.task01.validator.CircleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The {@code DataParser} class is used to parse the data.
 *
 * @author Gil Olga
 */
public class DataParser {

    private static final Logger logger = LogManager.getLogger();

    /**
     * The regex for identifying spaces.
     */
    public static final String REGEX_SPACE = "\\s+";

    /**
     * For parsing the data from list of Strings.
     *
     * @param lines of the file
     * @return list of the Circle type
     */
    public List<Circle> parseData(List<String> lines) {

        logger.info("Parsing the data ");
        CircleValidator circleValidator = new CircleValidator();
        List<Double> data2 = new ArrayList<>();
        List<Circle> circles = new ArrayList<>();
        for (String line : lines) {
            if (circleValidator.checkCircle(line)) {
                List<String> numbers = Arrays.asList(line.split(REGEX_SPACE));
                for (String number : numbers) {
                    data2.add(Double.parseDouble(number));
                }
                circles.add(new Circle(new Point(data2.get(0),
                        data2.get(1)), data2.get(2)));
                data2.clear();
            }
        }
        return circles;
    }
}

package by.training.task01.creator;

import by.training.task01.entity.Circle;
import by.training.task01.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code CircleCreator} class is used for creating a circle.
 *
 * @author Gil Olga
 */
public class CircleCreator {

    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Method for creating the list of circles.
     *
     * @param numbers list of the input data.
     * @return list of circles
     */
    public List<Circle> createCircle(final List<List<Double>> numbers) {
        List<Circle> circles = new ArrayList<>();
        LOGGER.info("Creating the list of circles.");
        for (List<Double> line : numbers) {
            circles.add(new Circle(new Point(line.get(0),
                    line.get(1)), line.get(2)));
        }
        return circles;
    }


}

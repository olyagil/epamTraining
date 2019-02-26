package by.training.task01.repository;

import by.training.task01.entity.Circle;
import by.training.task01.repository.specification.CircleSpecification;
import by.training.task01.repository.specification.FindCircleSpecification;
import by.training.task01.repository.specification.SortCircleSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code CircleRepository} class is used for adding, removing and
 * updating the circle objects.
 */
public class CircleRepository implements Repository {

    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * The list of the circle.
     */
    private List<Circle> circleList = new ArrayList<>();

    /**
     * Method for adding a circle in the circle list.
     *
     * @param circle
     */
    @Override
    public void add(final Circle circle) {
        if (circle != null) {
            circleList.add(circle);
            LOGGER.info("Added the circle " + circle + " to the circle list"
                    + circleList);
        }
    }

    /**
     * Method for removing a circle from the circle list.
     *
     * @param circle
     */
    @Override
    public void remove(final Circle circle) {
        if (circle != null && (!circleList.isEmpty())) {
            circleList.remove(circle);
            LOGGER.info("Removed the circle " + circle
                    + " from the circle list" + circleList);
        }
    }

    /**
     * Method for updating old circle with a new circle.
     *
     * @param oldCircle
     * @param newCircle
     */
    @Override
    public void update(final Circle oldCircle, final Circle newCircle) {
        if (circleList.contains(oldCircle) && newCircle != null) {
            circleList.set(circleList.indexOf(oldCircle), newCircle);
            LOGGER.info("Update the circle " + oldCircle + " with the new "
                    + "circle " + newCircle);
        }
    }

    /**
     * Method for finding or sorting the circle list.
     *
     * @param circleSpecification
     * @return circleList
     */
    @Override
    public List<Circle> query(final CircleSpecification circleSpecification) {

        List<Circle> circles = null;

        if (circleSpecification instanceof FindCircleSpecification) {
            LOGGER.info("Doing searching by circle specification: "
                    + circleSpecification);
            circles = new ArrayList<>();
            for (Circle circle : circleList) {
                if (((FindCircleSpecification) circleSpecification)
                        .specified(circle)) {
                    circles.add(circle);
                }
            }
        } else if (circleSpecification instanceof SortCircleSpecification) {
            LOGGER.info("Doing sorting by circle specification: "
                    + circleSpecification);
            circles = circleList;
            circles.sort(((SortCircleSpecification) circleSpecification)
                    .specifiedComparator());
        }
        return circles;
    }
}

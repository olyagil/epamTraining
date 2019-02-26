package by.training.task01.generator.training.task01.action;

import by.training.task01.generator.training.task01.entity.Circle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The {@code CircleAction} class calculate the area and the perimeter of the
 * circle. Checks if the figure is the circle. And if the circle is crossing
 * the coordinate axis.
 *
 * @author Gil Olga
 */
public class CircleAction {

    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Calculate the area of the circle.
     *
     * @param circle that's needed to be checked
     * @return area of the circle
     */
    public double calcArea(final Circle circle) {
        double area = Math.PI * circle.getRadius() * circle.getRadius();
        LOGGER.info("The area of the circle = " + area);
        return area;
    }

    /**
     * Calculate the perimeter of the circle.
     *
     * @param circle that's needed to be checked
     * @return perimeter of the circle
     */
    public double calcPerimeter(final Circle circle) {
        double perimeter = 2 * Math.PI * circle.getRadius();
        LOGGER.info("The perimeter of the circle = " + perimeter);
        return perimeter;
    }

    /**
     * Checks if the figure is a circle.
     *
     * @param circle that's needed to be checked
     * @return true, if the circle
     */
    public boolean isCircle(final Circle circle) {
        boolean isCircle = (circle.getRadius() > 0);
        LOGGER.info("It is a circle: " + isCircle);
        return isCircle;
    }

    /**
     * Checks if the circle is crossing the coordinate axis on given distance.
     *
     * @param circle   that's needed to be checked
     * @param distance given distance
     * @return true, if cross
     */
    public boolean isCross(final Circle circle, final int distance) {
        double absX = Math.abs(circle.getCenter().getX());
        double absY = Math.abs(circle.getCenter().getY());
        return (absX != absY)
                && (Double.compare(circle.getRadius() - absX, distance) == 0
                || Double.compare(circle.getRadius() - absY, distance) == 0);
    }
}

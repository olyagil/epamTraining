/**
 * The action package is used to calculate object's parameters
 */
package by.training.task01.action;

import by.training.task01.entity.Circle;
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

    private static final Logger logger = LogManager.getLogger();

    /**
     * Calculate the area of the circle.
     *
     * @param circle that's needed to be checked
     * @return area of the circle
     */
    public double calcArea(Circle circle) {
        double area = Math.PI * circle.getRadius() * circle.getRadius();
        logger.info("The area of the circle = " + area);
        return area;
    }

    /**
     * Calculate the perimeter of the circle.
     *
     * @param circle that's needed to be checked
     * @return perimeter of the circle
     */
    public double calcPerimeter(Circle circle) {
        double perimeter = 2 * Math.PI * circle.getRadius();
        logger.info("The perimeter of the circle = " + perimeter);
        return perimeter;
    }

    /**
     * Checks if the figure is a circle.
     *
     * @param circle that's needed to be checked
     * @return true, if the circle
     */
    public boolean isCircle(Circle circle) {
        boolean isCircle = (circle.getRadius() > 0);
        logger.info("It is a circle: " + isCircle);
        return isCircle;
    }

    /**
     * Checks if the circle is crossing the coordinate axis on given distance.
     *
     * @param circle   that's needed to be checked
     * @param distance given distance
     * @return true, if cross
     */
    public boolean isCross(Circle circle, int distance) {
        double absX = Math.abs(circle.getCenter().getX());
        double absY = Math.abs(circle.getCenter().getY());
        return (absX != absY)
                && (circle.getRadius() - absX == distance
                || circle.getRadius() - absY == distance);
    }
}

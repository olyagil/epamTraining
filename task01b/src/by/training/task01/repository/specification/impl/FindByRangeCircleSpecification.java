package by.training.task01.repository.specification.impl;

import by.training.task01.entity.Circle;
import by.training.task01.repository.specification.FindCircleSpecification;

/**
 * The {@code FindByRangeCircleSpecification} class finds circles on at a
 * distance in a given range from the origin.
 */
public class FindByRangeCircleSpecification implements FindCircleSpecification {
    /**
     * The distance.
     */
    private double distance;

    /**
     * The constructor with the perimeter of the circle.
     *
     * @param distanceAtRange of the circle
     */
    public FindByRangeCircleSpecification(final double distanceAtRange) {
        this.distance = distanceAtRange;
    }

    /**
     * Method that checking if equals.
     *
     * @param circle
     * @return
     */
    @Override
    public boolean specified(final Circle circle) {
        return (Double.compare(circle.getRadius() - circle.getCenter().getX(),
                distance) == 0)
                && (Double.compare(circle.getRadius()
                - circle.getCenter().getY(), distance) == 0);
    }
}

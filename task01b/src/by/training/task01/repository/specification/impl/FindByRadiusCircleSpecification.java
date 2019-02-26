package by.training.task01.repository.specification.impl;

import by.training.task01.entity.Circle;
import by.training.task01.repository.specification.FindCircleSpecification;

/**
 * The {@code FindByRadiusCircleSpecification} class is used for searching by
 * perimeter of the specific circle.
 */
public class FindByRadiusCircleSpecification
        implements FindCircleSpecification {
    /**
     * The radius of the circle.
     */
    private int radius;

    /**
     * The constructor with the perimeter of the circle.
     *
     * @param radiusOfCircle of the circle
     */
    public FindByRadiusCircleSpecification(final int radiusOfCircle) {
        this.radius = radiusOfCircle;
    }

    /**
     * Method that checking if equals.
     *
     * @param circle
     * @return
     */
    @Override
    public boolean specified(final Circle circle) {
        return radius == circle.getRadius();
    }
}

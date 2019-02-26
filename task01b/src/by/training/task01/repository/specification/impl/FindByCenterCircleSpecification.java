package by.training.task01.repository.specification.impl;

import by.training.task01.entity.Circle;
import by.training.task01.entity.Point;
import by.training.task01.repository.specification.FindCircleSpecification;

/**
 * The {@code FindByCenterCircleSpecification} class is used for searching by
 * specific center.
 */
public class FindByCenterCircleSpecification
        implements FindCircleSpecification {
    /**
     * The center og the circle.
     */
    private Point center;

    /**
     * The constructor with the parameter center.
     *
     * @param centerOfCircle of the circle
     */
    public FindByCenterCircleSpecification(final Point centerOfCircle) {
        this.center = centerOfCircle;
    }

    /**
     * Method that checking if equals.
     *
     * @param circle
     * @return
     */
    @Override
    public boolean specified(final Circle circle) {
        return center.equals(circle.getCenter());
    }
}

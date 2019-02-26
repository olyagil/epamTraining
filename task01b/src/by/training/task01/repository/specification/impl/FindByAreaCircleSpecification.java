package by.training.task01.repository.specification.impl;

import by.training.task01.action.CircleAction;
import by.training.task01.entity.Circle;
import by.training.task01.repository.specification.FindCircleSpecification;

/**
 * The {@code FindByAreaCircleSpecification} class is used for searching
 * specific area.
 */
public class FindByAreaCircleSpecification implements FindCircleSpecification {
    /**
     * The area of the circle.
     */
    private double area;
    /**
     * The instance of the {@code CircleAction} class.
     */
    private CircleAction circleAction;

    /**
     * The constructor.
     *
     * @param areaOfCircle given area.
     */
    public FindByAreaCircleSpecification(final double areaOfCircle) {
        this.area = areaOfCircle;
    }

    /**
     * Method for determining if even.
     *
     * @param circle
     * @return true if even
     */
    @Override
    public boolean specified(final Circle circle) {
        return Double.compare(area, circleAction.calcArea(circle)) == 0;
    }
}

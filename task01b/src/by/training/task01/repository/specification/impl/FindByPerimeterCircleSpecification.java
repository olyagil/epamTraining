package by.training.task01.repository.specification.impl;

import by.training.task01.action.CircleAction;
import by.training.task01.entity.Circle;
import by.training.task01.repository.specification.FindCircleSpecification;

/**
 * The {@code FindByPerimeterCircleSpecification} class is used for searching by
 * perimeter of the specific circle.
 */
public class FindByPerimeterCircleSpecification
        implements FindCircleSpecification {

    /**
     * The instance of the class CircleAction.
     */
    private CircleAction circleAction;

    /**
     * The perimeter of the circle.
     */
    private double perimeter;

    /**
     * The constructor with the perimeter of the circle.
     *
     * @param perimeterOfCircle of the circle
     */
    public FindByPerimeterCircleSpecification(final double perimeterOfCircle) {
        this.perimeter = perimeterOfCircle;
    }

    /**
     * Method that checking if equals.
     *
     * @param circle
     * @return
     */
    @Override
    public boolean specified(final Circle circle) {
        return Double.compare(perimeter,
                circleAction.calcPerimeter(circle)) == 0;
    }
}

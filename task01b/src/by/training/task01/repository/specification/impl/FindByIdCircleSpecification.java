package by.training.task01.repository.specification.impl;

import by.training.task01.entity.Circle;
import by.training.task01.repository.specification.FindCircleSpecification;

/**
 * The {@code FindByIdCircleSpecification} class is used for searching by
 * specific id.
 */
public class FindByIdCircleSpecification implements FindCircleSpecification {

    /**
     * The id of the circle.
     */
    private Integer id;

    /**
     * The constructor with the parameter id.
     *
     * @param circleId of the circle
     */
    public FindByIdCircleSpecification(final Integer circleId) {
        this.id = circleId;
    }

    /**
     * Method that checking if equals.
     *
     * @param circle
     * @return
     */
    @Override
    public boolean specified(final Circle circle) {
        return id.equals(circle.getCircleId());
    }
}

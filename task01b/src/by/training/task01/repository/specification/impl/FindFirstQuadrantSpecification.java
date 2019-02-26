package by.training.task01.repository.specification.impl;

import by.training.task01.entity.Circle;
import by.training.task01.repository.specification.FindCircleSpecification;

/**
 * The {@code FindFirstQuadrantSpecification} class finds circles that's
 * plased in the first quadrant.
 */
public class FindFirstQuadrantSpecification implements FindCircleSpecification {

    /**
     * Method that checking if equals.
     *
     * @param circle
     * @return
     */
    @Override
    public boolean specified(final Circle circle) {
        return circle.getCenter().getX() >= 0
                && circle.getCenter().getY() >= 0;
    }
}

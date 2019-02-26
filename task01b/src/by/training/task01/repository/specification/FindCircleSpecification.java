package by.training.task01.repository.specification;

import by.training.task01.entity.Circle;

/**
 * The {@code FindCircleSpecification} interface is used for searching.
 */
public interface FindCircleSpecification extends CircleSpecification {
    /**
     * Abstract method that checked if specified.
     *
     * @param circle given circle
     * @return true if specified
     */
    boolean specified(Circle circle);
}

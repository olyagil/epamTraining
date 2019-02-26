package by.training.task01.repository.specification.impl;

import by.training.task01.entity.Circle;
import by.training.task01.repository.specification.SortCircleSpecification;

import java.util.Comparator;

/**
 * The {@code SortByIdCircleSpecificationSpecification} class is used for
 * sorting by id.
 */
public class SortByIdCircleSpecificationSpecification
        implements SortCircleSpecification {

    /**
     * Method for sorting bi id.
     *
     * @return
     */
    @Override
    public Comparator<Circle> specifiedComparator() {
        return Comparator.comparing(Circle::getCircleId);
    }
}

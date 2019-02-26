package by.training.task01.repository.specification.impl;

import by.training.task01.entity.Circle;
import by.training.task01.repository.specification.SortCircleSpecification;

import java.util.Comparator;

/**
 * The {@code SortByRadiusCircleSpecificationSpecification} class is used for
 * sorting by radius.
 */
public class SortByRadiusCircleSpecificationSpecification
        implements SortCircleSpecification {

    /**
     * Method for sorting by Radius.
     *
     * @return
     */
    @Override
    public Comparator<Circle> specifiedComparator() {
        return Comparator.comparing(Circle::getRadius)
                .thenComparing(Circle::getCircleId);
    }
}

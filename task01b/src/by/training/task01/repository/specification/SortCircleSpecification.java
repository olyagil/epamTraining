package by.training.task01.repository.specification;

import by.training.task01.entity.Circle;

import java.util.Comparator;

/**
 * The class implements {@code SortCircleSpecification} interface when wants
 * to sort by parameter.
 */

public interface SortCircleSpecification extends CircleSpecification {
    /**
     * Abstract method for sorting.
     *
     * @return comparator
     */
    Comparator<Circle> specifiedComparator();


}

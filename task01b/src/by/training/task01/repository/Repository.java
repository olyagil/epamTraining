package by.training.task01.repository;

import by.training.task01.entity.Circle;
import by.training.task01.repository.specification.CircleSpecification;

import java.util.List;

/**
 * The class implements the {@code Repository} interface when it wants to
 * work with circle objects.
 */
public interface Repository {
    /**
     * Add object to the list.
     *
     * @param circle given circle
     */
    void add(Circle circle);

    /**
     * Remove object from circle list.
     *
     * @param circle given circle
     */
    void remove(Circle circle);

    /**
     * Update changes.
     *
     * @param oldCircle old circle
     * @param newCircle new given circle
     */
    void update(Circle oldCircle, Circle newCircle);

    /**
     * To make a query: find or sort for specification.
     *
     * @param circleSpecification find or sort
     * @return list of objects.
     */
    List<Circle> query(CircleSpecification circleSpecification);

}

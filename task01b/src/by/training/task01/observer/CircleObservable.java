package by.training.task01.observer;

import by.training.task01.entity.Circle;
import by.training.task01.entity.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code CircleObservable} class is used for data tracking and notifying
 * if they were changed.
 */
public class CircleObservable extends Circle implements Observable {

    /**
     * List of observers.
     */
    private List<Observer> observers = new ArrayList<>();

    /**
     * The constructor of specified observer.
     *
     * @param center of the circle
     * @param radius of th circle
     */
    public CircleObservable(final Point center, final double radius) {
        super(center, radius);
    }

    /**
     * Overriding method setCenter with notifying method.
     *
     * @param center of the circle
     */
    @Override
    public void setCenter(final Point center) {
        if (center != null) {
            super.setCenter(center);
        }
        notifyObserver();
    }

    /**
     * Overriding method setRadius with notifying method.
     *
     * @param radius of the circle
     */
    @Override
    public void setRadius(final double radius) {
        super.setRadius(radius);
        notifyObserver();
    }

    /**
     * Overriding method setCircleId with notifying method.
     *
     * @param id of the circle
     */
    public void setCircleId(final Integer id) {
        super.setCircleId(id);
        notifyObserver();
    }

    /**
     * Method for adding the observer in observer list.
     *
     * @param observer
     */
    @Override
    public void addObserver(final Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    /**
     * Method for removing the observer from observer list.
     *
     * @param observer
     */
    @Override
    public void removeObserver(final Observer observer) {
        if (observer != null && !observers.isEmpty()) {
            observers.remove(observer);
        }
    }

    /**
     * Method for notifying observers if specific action is made.
     */
    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.update(this));
    }
}

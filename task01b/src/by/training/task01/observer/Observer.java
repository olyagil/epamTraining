package by.training.task01.observer;

import by.training.task01.entity.Circle;

/**
 * A class can implement the {@code Observer} interface when it
 * wants to be informed of changes in observable objects.
 */
public interface Observer {
    /**
     * This method is called whenever the observed object is changed.
     *
     * @param circle observable circle
     */
    void update(Circle circle);
}

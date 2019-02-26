package by.training.task01.observer;

/**
 * The {@code Observable} interface is used for working with observers.
 */
public interface Observable {
    /**
     * Adds an observer to the list of observers.
     *
     * @param o observer
     */
    void addObserver(Observer o);

    /**
     * Deletes an observer from the set of observers of this object.
     *
     * @param o observer
     */
    void removeObserver(Observer o);

    /**
     * If this object has changed then notify all of its observers.
     */
    void notifyObserver();


}

package by.training.task01.observer;

import by.training.task01.action.CircleAction;
import by.training.task01.entity.Circle;
import by.training.task01.entity.CircleParameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code CircleObserver} class is used for specific implementation of
 * the Observer interface.
 */
public final  class CircleObserver implements Observer {

    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * The only one instance of the CircleObserver class.
     */
    private static CircleObserver instance;

    /**
     * The instance of the CircleAction class.
     */
    private CircleAction circleAction = new CircleAction();

    /**
     * The hashMap of the id and CircleParameters.
     */
    private Map<Integer, CircleParameters> circleMap = new HashMap<>();

    /**
     * The constructor.
     */
    private CircleObserver() {
    }

    /**
     * The realization of Singleton pattern.
     *
     * @return only one instance of the CircleObserver class
     */
    public static CircleObserver getInstance() {
        if (instance == null) {
            instance = new CircleObserver();
        }
        return instance;
    }

    /**
     * Method for getting specific parameter.
     *
     * @param itemId in the map
     * @return parameter of the specific id
     */
    public CircleParameters getCircleParametersById(final Integer itemId) {
        if (!circleMap.containsKey(itemId)) {
            LOGGER.warn("Doesn't have key with this id " + itemId);
        }
        return circleMap.get(itemId);
    }

    /**
     * Set the circle action.
     *
     * @param circleActionOfCircle what action can make
     */
    public void setCircleAction(final CircleAction circleActionOfCircle) {
        this.circleAction = circleActionOfCircle;
    }

    /**
     * Updating parameters for specific circle.
     *
     * @param item
     */
    @Override
    public void update(final Circle item) {
        double newArea = circleAction.calcArea(item);
        double newPerimeter = circleAction.calcPerimeter(item);
        circleMap.put(item.getCircleId(),
                new CircleParameters(newArea, newPerimeter));
    }
}

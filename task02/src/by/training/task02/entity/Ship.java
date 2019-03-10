package by.training.task02.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * The {@code Ship} method is used for loading and unloading the ship.
 *
 * @author Gil Olga
 */
public class Ship implements Callable<String> {
    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * The constant for loading action.
     */
    private static final int NUMBER_FOR_LOAD = 0;
    /**
     * The list of containers in the ship.
     */
    private List<Container> containersInShip;
    /**
     * The port storage.
     */
    private Storage storage;
    /**
     * The port.
     */
    private Port port;
    /**
     * The berth.
     */
    private Berth berth;
    /**
     * The name of the ship.
     */
    private String name;
    /**
     * The capacity of the ship.
     */
    private int capacityShip;
    /**
     * The action for the ship.
     */
    private int shipAction;

    /**
     * The constructor for initialization the ship.
     *
     * @param nameOfShip   of the ship
     * @param capacity     of the ship
     * @param action       for the ship
     * @param portForShips port
     */
    public Ship(final String nameOfShip, final int capacity, final int action,
                final Port portForShips) {
        this.name = nameOfShip;
        this.capacityShip = capacity;
        this.shipAction = action;
        this.port = portForShips;
        containersInShip = new ArrayList<>(capacity);
        storage = portForShips.getStorage();
    }

    /**
     * Overriding method for starting point in the thread.
     *
     * @return The statistics of action in the ship
     * @throws InterruptedException if thread is interrupted
     */
    @Override
    public String call() throws InterruptedException {
        try {
            port.mooreShip(this);
            berth = port.getBerth(this);
            LOGGER.info("\tThe ship " + getName().toUpperCase()
                    + " has been moored to the berth №" + berth.getBerthId());
            LOGGER.info("The capacity of the ship " + getName().toUpperCase()
                    + ": " + getFilledCapacityShip() + "/" + getCapacityShip());
            shipMoveAction();

        } finally {
            port.unmooreShip(this);
            LOGGER.info("The ship " + getName().toUpperCase()
                    + " is unmoored from the berth №" + berth.getBerthId());

        }
        return "The capacity of the ship " + getName().toUpperCase()
                + " : " + getFilledCapacityShip() + "/" + getCapacityShip();
    }

    /**
     * Method for choosing the action for the ship.
     */
    private void shipMoveAction() {
        if (shipAction == NUMBER_FOR_LOAD) {
            LOGGER.info(">>> Loading the ship " + getName().toUpperCase());
            loadShip();
        } else {
            LOGGER.info("<<< Unloading the ship " + getName().toUpperCase());
            unloadShip();
        }
        LOGGER.info("The ship " + getName().toUpperCase() + " was served.");
    }

    /**
     * The method for loading the containers onto the ship.
     */
    private void loadShip() {

        int freeCapacityShip = getCapacityShip() - getFilledCapacityShip();

        if (freeCapacityShip == 0) {
            LOGGER.info("The ship is full. Let's unload him.");
            unloadShip();

        } else if (freeCapacityShip < storage.getFilledCapacity()) {
            LOGGER.info("Need to load " + freeCapacityShip + " containers.");

            berth.moveContainersToShip(containersInShip, freeCapacityShip);

            LOGGER.info("The ship has been loaded with "
                    + freeCapacityShip + " containers.");

        } else if (freeCapacityShip > storage.getFilledCapacity()) {
            int filledCapacityStorage = storage.getFilledCapacity();
            LOGGER.info("The ship can be loaded partly. Not enough "
                    + "containers in the storage. Let's load "
                    + filledCapacityStorage + " containers.");

            berth.moveContainersToShip(containersInShip, filledCapacityStorage);

            LOGGER.info("The ship has been loaded with " + filledCapacityStorage
                    + " containers.");
        }
    }

    /**
     * The method for unloading the containers from the ship.
     */
    private void unloadShip() {

        int filledCapacityShip = getFilledCapacityShip();
        int freeCapacityStorage = storage.getCapacity()
                - storage.getFilledCapacity();

        if (filledCapacityShip < 1) {
            LOGGER.info("The ship does not need to be unloaded. He is "
                    + "empty. Let's load him.");
            loadShip();
        } else if (filledCapacityShip < freeCapacityStorage) {
            LOGGER.info("Need to unload " + filledCapacityShip
                    + " containers.");

            berth.moveContainersFromShip(containersInShip, filledCapacityShip);

            LOGGER.info("The ship has been unloaded with "
                    + filledCapacityShip + " containers.");
        } else {
            LOGGER.info("The ship can be unload partly. Not enough free "
                    + "space in the storage. Let's unload "
                    + freeCapacityStorage + " containers.");
            berth.moveContainersFromShip(containersInShip, freeCapacityStorage);

            LOGGER.info("The ship has been unloaded with "
                    + freeCapacityStorage + " containers.");
        }
    }

    /**
     * The method for getting the filled capacity of the ship.
     *
     * @return capacity of the ship
     */
    private int getFilledCapacityShip() {
        return containersInShip.size();
    }

    /**
     * The method for adding the container to the ship.
     *
     * @param container specific container
     */
    void addContainer(final Container container) {
        containersInShip.add(container);
    }

    /**
     * The getter for the capacity of the ship.
     *
     * @return capacityShip
     */
    int getCapacityShip() {
        return capacityShip;
    }

    /**
     * The getter for the name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * The overriding method toString.
     *
     * @return ship in the string
     */
    @Override
    public String toString() {
        return "\nName: '" + name + '\''
                + ", capacity = " + capacityShip
                + ", containers in ship = " + containersInShip.size();
    }
}


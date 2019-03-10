package by.training.task02.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class Ship implements Callable<String> {
    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int NUMBER_FOR_LOAD = 0;

    private List<Container> containersInShip;
    private Storage storage;
    private Port port;
    private Berth berth;
    private String name;
    private int capacityShip;
    private int shipAction;

    public Ship(String name, int capacityShip, int shipAction, Port port) {
        this.name = name;
        this.capacityShip = capacityShip;
        this.shipAction = shipAction;
        this.port = port;
        containersInShip = new ArrayList<>(capacityShip);
        storage = port.getStorage();
    }


    @Override
    public String call() throws InterruptedException {
        try {
            port.mooreShip(this);
            berth = port.getBerth(this);
            LOGGER.info("\tThe ship " + getName().toUpperCase()
                    + " has been moored to the berth №" + berth.getBerthId());
            LOGGER.info("The capacity of the ship " + getName().toUpperCase()
                    + " : " + getFilledCapacityShip() + "/" + getCapacityShip());
            shipMoveAction();

        } finally {
            port.unmooreShip(this);
            LOGGER.info("The ship " + getName().toUpperCase()
                    + " is unmoored from the berth №" + berth.getBerthId());

        }
        return "The capacity of the ship " + getName().toUpperCase()
                + " : " + getFilledCapacityShip() + "/" + getCapacityShip();
    }

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

    private void loadShip() {

        int freeCapacityShip = getCapacityShip() - getFilledCapacityShip();

        if (freeCapacityShip == 0) {
            LOGGER.info("The ship is full. Let's unload him.");
            unloadShip();

        } else if (freeCapacityShip < storage.getFilledCapacity()) {
            LOGGER.info("Need to load " + freeCapacityShip + " containers.");

            berth.moveContainersToShip(storage, containersInShip,
                    freeCapacityShip);

            LOGGER.info("The ship has been loaded with "
                    + freeCapacityShip + " containers.");

        } else if (freeCapacityShip > storage.getFilledCapacity()) {
            int filledCapacityStorage = storage.getFilledCapacity();
            LOGGER.info("The ship can be loaded partly. Not enough " +
                    "containers in the storage. Let's load " + filledCapacityStorage
                    + " containers.");

            berth.moveContainersToShip(storage, containersInShip,
                    filledCapacityStorage);

            LOGGER.info("The ship has been loaded with " + filledCapacityStorage +
                    " containers.");
        }
    }

    private void unloadShip() {

        int filledCapacityShip = getFilledCapacityShip();
        int freeCapacityStorage = storage.getCapacity() - storage.getFilledCapacity();

        if (filledCapacityShip < 1) {
            LOGGER.info("The ship does not need to be unloaded. He is "
                    + "empty. Let's load him.");
            loadShip();
        } else if (filledCapacityShip < freeCapacityStorage) {
            LOGGER.info("Need to unload " + filledCapacityShip
                    + " containers.");

            berth.moveContainersFromShip(storage, containersInShip,
                    filledCapacityShip);

            LOGGER.info("The ship has been unloaded with "
                    + filledCapacityShip + " containers.");
        } else {
            LOGGER.info("The ship can be unload partly. Not enough free "
                    + "space in the storage. Let's unload "
                    + freeCapacityStorage + " containers.");
            berth.moveContainersFromShip(storage, containersInShip,
                    freeCapacityStorage);

            LOGGER.info("The ship has been unloaded with "
                    + freeCapacityStorage + " containers.");
        }
    }

    public int getFilledCapacityShip() {
        return containersInShip.size();
    }

    public void addContainer(Container container) {
        containersInShip.add(container);
    }

    public int getCapacityShip() {
        return capacityShip;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nName: '" + name + '\''
                + ", capacity = " + capacityShip
                + ", containers in ship = " + containersInShip.size();
    }
}


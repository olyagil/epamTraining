package by.training.task02.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ship implements Runnable {
    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int LOAD = 0;
    private static final int UNLOAD = 1;

    private Semaphore semaphore;
    private Lock lock;

    private List<Container> containersInShip;
    private Storage storage;
    private Port port;
    private Berth berth;
    private String name;
    private int capacityShip;
    private int shipAction;

    public Ship(String name, int capacityShip,
                int shipAction, Port port) {
        // this.semaphore = semaphore;
        this.name = name;
        this.capacityShip = capacityShip;
        this.shipAction = shipAction;
        this.port = port;
        containersInShip = new ArrayList<>(capacityShip);
        storage = port.getStorage();
        lock = new ReentrantLock();
    }

    public void run() {
        try {
//            semaphore.acquire();
            port.mooreShip(this);
            LOGGER.info("\tThe ship " + getName().toUpperCase()
                    + " has been moored to the berth.");
            LOGGER.info("The capacity of the ship " + getName().toUpperCase()
                    + " : " + getFilledCapacityShip() + "/" + getCapacityShip());
            shipMoveAction();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
        } finally {
            port.unmooreShip(this);
            LOGGER.info("The ship " + getName().toUpperCase()
                    + " is unmoored from the berth.");
//            semaphore.release();
        }
    }

    private void shipMoveAction() {
        if (shipAction == LOAD) {
            LOGGER.info(">>> Loading the ship " + getName().toUpperCase());
            loadShip();
        } else {
            LOGGER.info("<<< Unloading the ship " + getName().toUpperCase());
            unloadShip();
        }
        LOGGER.info("The ship " + getName().toUpperCase() + " was served.");

    }

    private void loadShip() {
        lock.lock();
        berth = port.getBerth(this);
        int freeCapacityShip = getCapacityShip() - getFilledCapacityShip();
        try {
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
        } finally {
            lock.unlock();
        }
    }

    private void unloadShip() {
        lock.lock();
        try {
            berth = port.getBerth(this);
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
                        + "capacity of the storage. Let's unload "
                        + freeCapacityStorage + " containers.");
                berth.moveContainersFromShip(storage, containersInShip,
                        freeCapacityStorage);

                LOGGER.info("The ship has been unloaded with "
                        + freeCapacityStorage + " containers.");
            }
        } finally {
            lock.unlock();
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
        String action;
        switch (shipAction) {
            case LOAD:
                action = " load";
                break;
            case UNLOAD:
                action = " unload";
                break;
            default:
                action = " error";
        }
        return "\nName: '" + name + '\'' +
                ", capacity = " + capacityShip
                + ", containers in ship = " + containersInShip.size()
                + ", " + action;
    }

}


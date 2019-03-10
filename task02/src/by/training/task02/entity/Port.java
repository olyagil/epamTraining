package by.training.task02.entity;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The {@code Port} class is used for creating port with berths and ships.
 * For mooring and unmooring the ships from the berths.
 *
 * @author Gil Olga
 */
public final class Port {

    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * The constant for variety of the ship action.
     */
    private static final int SHIP_ACTION = 2;
    /**
     * Single instance of the port.
     */
    private static Port instance;
    /**
     * List of the berths.
     */
    private List<Berth> berthList;
    /**
     * The storage in the port.
     */
    private Storage storage;
    /**
     * The map of the ship and berths.
     */
    private Map<Ship, Berth> shipBerthMap;
    /**
     * Lock for synchronization.
     */
    private static Lock lock = new ReentrantLock();
    /**
     * The random initialization.
     */
    private Random random = new Random();

    /**
     * Singleton realization.
     *
     * @param berthAmount     amount of berths
     * @param storageCapacity capacity if the storage
     * @return the single instance of the port
     */
    public static Port getInstance(final int berthAmount,
                                   final int storageCapacity) {
        if (instance == null) {
            try {
                lock.lock();
                instance = new Port(berthAmount, storageCapacity);
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    /**
     * The constructor for initialization the port.
     *
     * @param berthAmount     amount of berths
     * @param storageCapacity capacity if the storage
     */
    private Port(final int berthAmount, final int storageCapacity) {
        int randomFilledCapacity = random.nextInt(storageCapacity);

        // creating the collection of the containers and fill it.
        List<Container> containerList = new ArrayList<>(storageCapacity);
        for (int i = 0; i < randomFilledCapacity; i++) {
            containerList.add(new Container(i + 1));
        }

        // создание склада в порту
        this.storage = new Storage(storageCapacity, containerList);

        berthList = new ArrayList<>(berthAmount);
        for (int i = 0; i < berthAmount; i++) {
            berthList.add(new Berth(i + 1, storage));
        }
        shipBerthMap = new HashMap<>();
        LOGGER.info("Port has been created with " + berthList.size()
                + " berth. \n\tAnd the capacity of the storage: "
                + storage.getCapacity() + ". \n\tThe filled capacity: "
                + storage.getFilledCapacity());
    }

    /**
     * The getter for the berth.
     *
     * @param ship current ship
     * @return the berth with the ship
     */
    Berth getBerth(final Ship ship) {
        return shipBerthMap.get(ship);
    }

    /**
     * Mooring the ship to the berths.
     *
     * @param ship current ship
     */
    void mooreShip(final Ship ship) {
        Berth berth;
        try {
            if (!berthList.isEmpty()) {
                lock.lock();
                berth = berthList.get(0);
                shipBerthMap.put(ship, berth);
                berthList.remove(berth);
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Unmooring the ship from the berth.
     *
     * @param ship current ship
     */
    void unmooreShip(final Ship ship) {
        Berth berth = shipBerthMap.get(ship);
        lock.lock();
        try {
            berthList.add(berth);
            shipBerthMap.remove(ship);

        } finally {
            lock.unlock();
        }
    }

    /**
     * Method for making the ships for the port.
     *
     * @param shipAmount      amount of the ship
     * @param maxShipCapacity maximum ship capacity
     * @return list of ships
     */
    public List<Ship> makeShips(final int shipAmount,
                                final int maxShipCapacity) {
        List<Ship> ships = new ArrayList<>(shipAmount);

        // создание кораблей
        for (int i = 0; i < shipAmount; i++) {
            ships.add(new Ship("ship" + (i + 1),
                    random.nextInt(maxShipCapacity) + 1,
                    random.nextInt(SHIP_ACTION), instance));
            fillShip(ships.get(i));
        }
        return ships;
    }

    //рандомоное наполнение кораблей

    /**
     * The method for random filling the capacity of the ship.
     *
     * @param ship current ship
     */
    private void fillShip(final Ship ship) {
        int randomFillShip = random.nextInt(ship.getCapacityShip());
        for (int i = 0; i < randomFillShip; i++) {
            ship.addContainer(new Container(i + 1));
        }
    }

    /**
     * The getter for storage.
     *
     * @return port storage
     */
    public Storage getStorage() {
        return storage;
    }
}

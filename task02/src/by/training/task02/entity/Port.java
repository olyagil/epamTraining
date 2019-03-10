package by.training.task02.entity;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Port {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final int SHIP_ACTION = 2; // разгрузка/загрузка РАНДОМ

    private static Port instance;
    private List<Berth> berthList;
    private Storage storage;
    private Map<Ship, Berth> shipBerthMap;
    private static Lock lock = new ReentrantLock();
    private List<Container> containerList;
    private Random random = new Random();

    public static Port getInstance(int berthAmount, int storageCapacity) {
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

    private Port(int berthAmount, int storageCapacity) {

        int randomFilledCapacity = random.nextInt(storageCapacity);

        // создание коллекции контейнеров для склада, наполняем склад
        containerList = new ArrayList<>(storageCapacity);
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
        LOGGER.info("Port has been created with " + berthList.size() +
                " berth. \n\tAnd the capacity of the storage: " + storage.getCapacity()
                + ". \n\tThe filled capacity: " + storage.getFilledCapacity());
    }

    public Berth getBerth(Ship ship) {
        return shipBerthMap.get(ship);
    }

    public void mooreShip(Ship ship) {
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

    public void unmooreShip(Ship ship) {
        Berth berth = shipBerthMap.get(ship);
        lock.lock();
        try {
            berthList.add(berth);
            shipBerthMap.remove(ship);

        } finally {
            lock.unlock();
        }
    }

    public List<Ship> makeShips(int shipAmount, int maxShipCapacity,
                                Port port) {
        List<Ship> ships = new ArrayList<>(shipAmount);

        // создание кораблей
        for (int i = 0; i < shipAmount; i++) {
            ships.add(new Ship("ship" + (i + 1),
                    random.nextInt(maxShipCapacity) + 1,
                    random.nextInt(SHIP_ACTION), port));
            fillShip(ships.get(i));
        }
        return ships;
    }

    //рандомоное наполнение кораблей
    private void fillShip(Ship ship) {
        int randomFillShip = random.nextInt(ship.getCapacityShip());
        for (int i = 0; i < randomFillShip; i++) {
            ship.addContainer(new Container(i + 1));
        }
    }

    public Storage getStorage() {
        return storage;
    }
}

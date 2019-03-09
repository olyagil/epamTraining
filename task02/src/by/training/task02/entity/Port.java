package by.training.task02.entity;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Port {

    private static final Logger LOGGER = LogManager.getLogger();
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
            berthList.add(new Berth(i + 1, this.storage));
        }
        shipBerthMap = new HashMap<>();
        LOGGER.info("Port has been created with " + berthList.size() +
                " berth. \n\tAnd the capacity of the storage: " + storage.getCapacity()
                + ". \n\tThe filled capacity: " + storage.getFilledCapacity());
    }


    public void mooreShip(Ship ship) {
        Berth berth;
        try {
            if (!berthList.isEmpty()) {
                lock.lock();
                berth = berthList.get(0);
                berthList.remove(berth);
                shipBerthMap.put(ship, berth);
            }
        } finally {
            lock.unlock();
        }
    }

    public void unmooreShip(Ship ship) {
        Berth berth = shipBerthMap.get(ship);
        lock.lock();
        try {
            shipBerthMap.remove(ship);
            berthList.add(berth);
        } finally {
            lock.unlock();
        }
    }



    public Berth getBerth(Ship ship) {
        return shipBerthMap.get(ship);
    }

    public Storage getStorage() {
        return storage;
    }
}

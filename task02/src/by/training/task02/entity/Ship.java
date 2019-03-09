package by.training.task02.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ship implements Runnable {
    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    Semaphore semaphore;
    private static final int LOAD = 0;
    private static final int UNLOAD = 1;
    private String name;
    private Storage storage;
    private int capacityShip;
     private int shipAction;
    Lock lock;
    Condition condition;
    Port port;
    private List<Container> containersInShip;


    public int getFilledCapacity() {
        return containersInShip.size();
    }

    public boolean addContainer(Container container) {
        return containersInShip.add(container);
    }

    public int getCapacityShip() {
        return capacityShip;
    }

    public String getName() {
        return name;
    }

    public Ship(Semaphore semaphore, String name, int capacityShip,
                int shipAction, Port port) {
        this.port = port;
        this.name = name;
        this.capacityShip = capacityShip;

        containersInShip = new ArrayList<>(capacityShip);
        this.shipAction = shipAction;
        storage = port.getStorage();
        this.semaphore = semaphore;
        lock = new ReentrantLock();
    }

    public void run() {
        try {
            semaphore.acquire();
            port.mooreShip(this);
            LOGGER.info("The ship " + getName().toUpperCase()
                    + " has been moored to the berth");
            shipMoveAction();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            port.unmoorShip(this);
            LOGGER.info("The ship " + getName().toUpperCase()
                    + " is unmoored from the berth.");
            semaphore.release();
        }
    }

    private void shipMoveAction() {
        if (shipAction == LOAD) {
            LOGGER.info("Loading the ship \"" + getName().toUpperCase() + "\".");
            loadShip();
        } else {
            LOGGER.info("Unloading the ship \"" + getName().toUpperCase() + "\".");
            unloadShip();
        }
        LOGGER.info("The ship \"" + getName().toUpperCase() + "\" was served.");

    }

    private void loadShip() {
        lock.lock();
        int freeCapacityShip = getCapacityShip() - getFilledCapacity();
        LOGGER.info("В корабль " + getName() + " необходимо загрузить "
                + freeCapacityShip + " контейнеров.");
        LOGGER.info("Емкость склада равна " + storage.getFilledCapacity() +
                " контейнеров.");
        int count = 0;
        try {
            if (freeCapacityShip == 0) {
                LOGGER.info("Емкость корабля " + getName() + " : "
                        + getFilledCapacity() + "/" + getCapacityShip()
                        + "Корабль заполнен. Загрузка ненужна. " +
                        "Разгружаем его.");
                unloadShip();
            } else if (freeCapacityShip < storage.getFilledCapacity()) {
                LOGGER.info(">> Емкость корабля " + getName() + " : "
                        + getFilledCapacity() + "/" + getCapacityShip()
                        + ". То есть можно загрузить ещё " + freeCapacityShip
                        + " контейнер (ов).");
                for (int i = 0; i < freeCapacityShip; i++) {
                    Container container = storage.getContainer();
                    containersInShip.add(container);
                    count++;
                    TimeUnit.MILLISECONDS.sleep(50);
                }
                LOGGER.info("Корабль " + getName() + " загрузил " + count
                        + " контейнер(ов). Всего в коробле " + containersInShip.size()
                        + " контейнер(ов). А на складе " + storage.getFilledCapacity()
                        + " контейнер (ов).");
            } else if (freeCapacityShip > storage.getFilledCapacity()) {
                LOGGER.info("Корабль " + getName() + " может "
                        + "загрузится частично, т.к. на складе "
                        + getFilledCapacity() + " контейнеров. А загрузить "
                        + "нужно " + freeCapacityShip + " контейнеров.");
                int filledCapacityStorage = storage.getFilledCapacity();
                for (int i = 0; i < filledCapacityStorage; i++) {
                    Container container = storage.getContainer();
                    containersInShip.add(container);
                    count++;
                }
                LOGGER.info("Корабль " + getName() + " загрузил " + count
                        + " контейнер(ов). Всего в коробле " + containersInShip.size()
                        + " контейнер(ов). А на складе " + storage.getFilledCapacity()
                        + " контейнер (ов).");
            }
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void unloadShip() {
        lock.lock();
        try {
            int count = 0; // кол-во выгружеенных контейнеров
            int size = containersInShip.size();
            if (size < 1) {
                LOGGER.info("Кораблю " + getName() + " разгружаться не" +
                        " надо. Он пуст. Загрузим его. Его емкость равна " + capacityShip);
                loadShip();
            } else {
                int freeCapacityStorage = storage.getCapacity() - storage.getFilledCapacity();
                if (size < freeCapacityStorage) {
                    LOGGER.info("<< Необходимо разгрузить корабль " + getName()
                            + ". Он содержит " + size + " контейнер (ов).");
                    for (int i = 0; i < size; i++) {
                        Container container = containersInShip.remove(0);
                        storage.addContainer(container);
                        count++;
                        TimeUnit.MILLISECONDS.sleep(50);
                    }
                    LOGGER.info("Корабль " + getName() + " выгрузил " + count
                            + " контейнер(ов). Всего в коробле " + containersInShip.size()
                            + " контейнер(ов). А на складе " + storage.getFilledCapacity()
                            + " контейнер(ов).");
                } else {
                    LOGGER.info("Корабль " + getName() + " может разгрузиться "
                            + "частично т.к. свободная емкость склада равна "
                            + freeCapacityStorage + ", а разгрузить нужно " + size
                            + " контейнер(ов).");

                    for (int i = 0; i < freeCapacityStorage; i++) {
                        Container container = containersInShip.remove(0);
                        storage.addContainer(container);
                        count++;
                    }
                    LOGGER.info("Корабль " + getName() + " выгрузил " + count
                            + " контейнер(ов). Всего в коробле " + containersInShip.size()
                            + " контейнер(ов). А на складе " + storage.getFilledCapacity()
                            + " контейнер(ов).");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
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


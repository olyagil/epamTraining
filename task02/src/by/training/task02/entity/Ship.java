package by.training.task02.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
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

    public int getFilledCapacity() {
        return containersInShip.size();
    }

    private Queue<Container> containersInShip;
    private int todo;
    Lock lock;
    Berth berth;
    Condition condition;
    Queue<Container> containers;


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
                int todo, Storage storage) {
        this.name = name;
        this.capacityShip = capacityShip;
        containersInShip = new LinkedBlockingQueue<>(capacityShip);
        this.todo = todo;
        this.storage = storage;
        this.semaphore = semaphore;
        // this.berth = berth;
        lock = new ReentrantLock();
        condition = lock.newCondition(); // получаем условие связанное сблокировкой
        containers = new LinkedBlockingQueue<>();
    }

    public void run() {
        try {
            switch (todo) {
                case LOAD:
                    semaphore.acquire();
                    loadShip();
                    TimeUnit.MILLISECONDS.sleep(200);
                    semaphore.release();
                    break;
                case UNLOAD:
                    semaphore.acquire();
                    TimeUnit.MILLISECONDS.sleep(20);
                    unloadShip();
                    semaphore.release();
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void atPier() {

    }

    //todo: если нужно загрузить в корабль ещё контейнеров, но их нет на складе.
    private void loadShip() {
        lock.lock();
        int freeCapacityShip = getCapacityShip() - getFilledCapacity();
        int count = 0;
        try {
            if (freeCapacityShip == 0) {
                LOGGER.info("Емкость корабля " + getName() + " : "
                        + getFilledCapacity() + "/" + getCapacityShip()
                        + "Корабль заполнен. Загрузка ненужна. " +
                        "Разгружаем его.");
                unloadShip();
            } else if (freeCapacityShip > storage.getFilledCapacity()) {
                LOGGER.info(">> Емкос+ть корабля " + getName() + " : "
                        + getFilledCapacity() + "/" + getCapacityShip()
                        + ". То есть можно загрузить ещё " + freeCapacityShip
                        + " контейнер(ов).");
                for (int i = 0; i < freeCapacityShip; i++) {
                    Container container = storage.getContainer();
//                    if (container == null) { // если в хранилище больше нет товара, загрузка корабля прерывается
//                        return;
//                    }
                    containersInShip.add(container);
                    count++;
                    TimeUnit.MILLISECONDS.sleep(50);
                }
                LOGGER.info("Корабль " + getName() + " загрузил " + count
                        + " контейнер(ов). Всего в коробле " + containersInShip.size()
                        + " контейнер(ов). А на складе " + storage.getFilledCapacity()
                        + " контейнер(ов).");
                LOGGER.info("!!!!!!!Корабль обслужен!!!!!!!!!!");
            } else if (capacityShip > storage.getFilledCapacity()) {
                LOGGER.info("Для загрузки корабля " + getName() + " c "
                        + freeCapacityShip + " контейнерами недостаточно " +
                        "контейнеров на складе(" + storage.getFilledCapacity()
                        + "). Корабль становится в конец очереди.");
            }
            // пока нет доступных контейнеров, ожидаем ограниченное число
            // времени. Если контейнеров не появляется, то добавляем
            // сколько есть.
            while (capacityShip > storage.getFilledCapacity()){
                condition.await();
            }
            condition.signalAll();
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //todo: если склад заполнен, но нужно разгрузить ещё контейнеров.
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
                LOGGER.info("<< Необходимо разгрузить корабль " + getName()
                        + ". Он содержит " + size + " контейнер(ов).");
                for (int i = 0; i < size; i++) {
                    Container container = containersInShip.poll();
                    storage.addContainer(container);
                    count++;
                    TimeUnit.MILLISECONDS.sleep(50);
                }
                LOGGER.info("Корабль " + getName() + " выгрузил " + count
                        + " контейнер(ов). Всего в коробле " + containersInShip.size()
                        + " контейнер(ов). А на складе " + storage.getFilledCapacity()
                        + " контейнер(ов).");
                LOGGER.info("!!!!!!!Корабль обслужен!!!!!!!!!!");
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "\nName: '" + name + '\'' +
                ", capacity = " + capacityShip
                + ", containers in ship = " + containersInShip.size();
    }
}


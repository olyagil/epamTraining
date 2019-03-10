package by.training.task02.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {

    private static final int DEFAULT_STORAGE_CAPACITY = 50;
    private int capacity;
    private Lock lock = new ReentrantLock();
    private List<Container> containerList;

    public Storage() {
        containerList = new ArrayList<>(DEFAULT_STORAGE_CAPACITY);
        setCapacity(DEFAULT_STORAGE_CAPACITY);
    }

    public Storage(int storageCapacity) {
        containerList = new ArrayList<>(storageCapacity);
        setCapacity(storageCapacity);
    }

    public Storage(int storageCapacity, List<Container> containers) {
        containerList = new ArrayList<>(storageCapacity);
        containerList.addAll(containers);
        setCapacity(storageCapacity);
    }

    public Container getContainer() {
        Container container;
        lock.lock();
        try {
            container = containerList.get(0);
            containerList.remove(0);
        } finally {
            lock.unlock();
        }
        return container;
    }

    public void addContainer(Container container) {
        containerList.add(container);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFilledCapacity() {
        return containerList.size();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

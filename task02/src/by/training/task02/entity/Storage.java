package by.training.task02.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The {@code Storage} class is used for creating storage, adding containers
 * to storage and removing them from storage.
 */
public class Storage {
    /**
     * The constant for default capacity value of the storage.
     */
    private static final int DEFAULT_STORAGE_CAPACITY = 50;
    /**
     * Capacity of the storage.
     */
    private int capacity;
    /**
     * Lock for synchronization.
     */
    private Lock lock = new ReentrantLock();
    /**
     * List of containers.
     */
    private List<Container> containerList;

    /**
     * The constructor with no parameters.
     */
    public Storage() {
        containerList = new ArrayList<>(DEFAULT_STORAGE_CAPACITY);
        setCapacity(DEFAULT_STORAGE_CAPACITY);
    }

    /**
     * The constructor with one parameter.
     *
     * @param storageCapacity capacity
     */
    public Storage(final int storageCapacity) {
        containerList = new ArrayList<>(storageCapacity);
        setCapacity(storageCapacity);
    }

    /**
     * The constructor with two parameters.
     *
     * @param storageCapacity capacity
     * @param containers      list of containers
     */
    public Storage(final int storageCapacity,
                   final List<Container> containers) {
        containerList = new ArrayList<>(storageCapacity);
        containerList.addAll(containers);
        setCapacity(storageCapacity);
    }

    /**
     * Method to get container from the storage.
     *
     * @return container
     */
    Container getContainer() {
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

    /**
     * Method for adding container to the storage.
     *
     * @param container to add
     */
    void addContainer(final Container container) {
        containerList.add(container);
    }

    /**
     * The getter for the capacity.
     *
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * The method to get filled capacity.
     *
     * @return filled capacity
     */
    public int getFilledCapacity() {
        return containerList.size();
    }

    /**
     * The setter of the capacity.
     *
     * @param capacityOfStorage capacity
     */
    public void setCapacity(final int capacityOfStorage) {
        this.capacity = capacityOfStorage;
    }
}

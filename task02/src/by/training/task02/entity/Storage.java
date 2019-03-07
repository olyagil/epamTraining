package by.training.task02.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Storage {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final int DEFAULT_STORAGE_CAPACITY = 50;
    private int capacity;

    private Queue<Container> containers = null;

    public Storage() {
        containers = new LinkedBlockingQueue<>(DEFAULT_STORAGE_CAPACITY);
        setCapacity(DEFAULT_STORAGE_CAPACITY);
    }

    public Storage(int capacity, List<Container> containerList) {
        containers = new LinkedBlockingQueue<>(capacity);
        containers.addAll(containerList);
        setCapacity(capacity);
    }

    public Container getContainer() {
        return containers.poll();
    }

    public boolean addContainer(Container container) {
        return containers.add(container);
    }

    public boolean addContainer(List<Container> containerList) {
        if (containers.size() + containerList.size() < getFilledCapacity()) {
            containers.addAll(containerList);
            return true;
        }
        return false;
    }


    public int getCapacity() {
        return capacity;
    }

    public int getFilledCapacity() {
        return containers.size();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Iterator<Container> iterator() {
        return containers.iterator();
    }
}

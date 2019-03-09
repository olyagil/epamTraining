package by.training.task02.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {
    //todo: change to ArrayList
    // todo: add method to getContainer from storage
    private static final int DEFAULT_STORAGE_CAPACITY = 50;
    private int capacity;
    private Lock lock = new ReentrantLock();
    List<Container> containerList;

//    private Queue<Container> containers;

    public Storage() {
        containerList = new ArrayList<>(DEFAULT_STORAGE_CAPACITY);
        setCapacity(DEFAULT_STORAGE_CAPACITY);
    }

    public Storage(int storageCapacity) {
        containerList = new ArrayList<>(storageCapacity);
        setCapacity(storageCapacity);
    }

    public Storage(int storageCapacity, List<Container> containers) {
//        containers = new LinkedBlockingQueue<>(capacity);
//        containers.addAll(containerList);
        containerList = new ArrayList<>(storageCapacity);
        containerList.addAll(containers);
        setCapacity(storageCapacity);
    }

//    public Container getContainer() {
//        return containers.poll();
//    }

    public Container getContainer() {
        Container container = containerList.get(0);
        containerList.remove(0);
        return container;

    }

    public boolean addContainer(List<Container> containers) {
        boolean result = false;
        if (containerList.size() + containers.size() <= capacity) {
            result = containerList.addAll(containers);
        }
        return result;
    }

    public boolean addContainer(Container container) {
        return containerList.add(container);
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

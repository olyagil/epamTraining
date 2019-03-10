package by.training.task02.entity;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The {@code Berth} class is used for creating the berth. And moving
 * containers from port's storage and back.
 */
public class Berth {
    /**
     * Number for caclulating the hashCode.
     */
    private static final int PRIME = 31;
    /**
     * Identification number of the berth.
     */
    private int berthId;

    /**
     * The storage in the port.
     */
    private Storage storage;

    /**
     * Lock for synchronization.
     */
    private Lock lock = new ReentrantLock();

    /**
     * The constructor for initialization the berth.
     *
     * @param id          identification number of the berth
     * @param portStorage the storage in the port
     */
    Berth(final int id, final Storage portStorage) {
        this.berthId = id;
        this.storage = portStorage;
    }

    /**
     * The method for moving the specific number of containers from the ship
     * to the port storage.
     *
     * @param containersInShip containers to move
     * @param capacityToMove   number of containers to move
     */
    void moveContainersFromShip(final List<Container> containersInShip,
                                final int capacityToMove) {
        lock.lock();
        try {
            for (int i = 0; i < capacityToMove; i++) {
                Container container = containersInShip.remove(0);
                storage.addContainer(container);
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * The method for moving the specific number of containers to the ship
     * from the port storage.
     *
     * @param containersInShip containers to move
     * @param capacityToMove   number of containers to move
     */
    void moveContainersToShip(final List<Container> containersInShip,
                              final int capacityToMove) {
        lock.lock();
        try {
            for (int i = 0; i < capacityToMove; i++) {
                Container container = storage.getContainer();
                containersInShip.add(container);
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Getter for berth id.
     *
     * @return bertID
     */
    int getBerthId() {
        return berthId;
    }

    /**
     * Overriding method equals for comparison.
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Berth berth = (Berth) o;

        if (getBerthId() != berth.getBerthId()) {
            return false;
        }
        return storage.equals(berth.storage);
    }

    /**
     * Overriding method to count hashCode.
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = getBerthId();
        result = PRIME * result + storage.hashCode();
        return result;
    }

    /**
     * Overriding method toString.
     *
     * @return
     */
    @Override
    public String toString() {
        return "berth Id: " + berthId;
    }
}


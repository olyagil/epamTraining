package by.training.task02.entity;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//должен хранить коллекцию кораблей и пускать к складу по одному
public class Berth {

    private Integer berthId;
    private Storage storage;
    private Lock lock = new ReentrantLock();

    public Berth(int berthId, Storage storage) {
        this.berthId = berthId;
        this.storage = storage;
    }

    protected void moveContainersFromShip(Storage storage,
                                          List<Container> containersInShip,
                                          int capacityToMove) {
        for (int i = 0; i < capacityToMove; i++) {
            Container container = containersInShip.remove(0);
            storage.addContainer(container);
        }
    }

    protected void moveContainersToShip(Storage storage,
                                        List<Container> containersInShip,
                                        int capacityToMove) {
        for (int i = 0; i < capacityToMove; i++) {
            Container container = storage.getContainer();
            containersInShip.add(container);
        }
    }

    public int getBerthId() {
        return berthId;
    }
}


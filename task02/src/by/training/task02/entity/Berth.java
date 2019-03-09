package by.training.task02.entity;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//должен хранить коллекцию кораблей и пускать к складу по одному
public class Berth {

    private int berthId;
    private Storage storage;
    private Lock lock = new ReentrantLock();

    public Berth(int berthId, Storage storage) {
        this.berthId = berthId;
        this.storage = storage;
    }

    public void addToPortStorage(Storage shipStorage, Container container) {
        storage.addContainer(container);
    }

    public void addToShipStorage(Storage shipStorage, Container container) {
        if (container != null) {
            shipStorage.addContainer(container);
        }
    }


}

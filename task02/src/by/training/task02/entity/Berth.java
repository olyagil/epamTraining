package by.training.task02.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//должен хранить коллекцию кораблей и пускать к складу по одному
public class Berth {

    private int berthId;
    private Storage storage;
    private Lock lock = new ReentrantLock();


    public void addShip(Storage storage, Ship ship) {
  }

    public Berth(int berthId, Storage storage) {
        this.berthId = berthId;
        this.storage = storage;
    }


}

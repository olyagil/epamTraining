package by.training.task02.entity;


import java.util.List;
import java.util.Random;

public class Port {

    private static Port instance;
    private List<Berth> berthList;
    private List<Ship> shipList;
    Random random = new Random();
    private int capacity;


    private Port(List<Berth> berths, int capacity) {
        this.berthList = berths;
    }

    public static Port getInstance(List<Berth> berths, int capacity) {
        if (instance == null) {
            instance = new Port(berths, capacity);
        }
        return instance;
    }
}

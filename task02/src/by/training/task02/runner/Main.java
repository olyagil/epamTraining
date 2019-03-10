package by.training.task02.runner;


import by.training.task02.creator.CreateData;
import by.training.task02.entity.*;
import by.training.task02.exception.ReadFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PATH = "data//data.txt";
    private static final int NUMBER_FOR_STORAGE_CAPACITY = 0;
    private static final int NUMBER_FOR_BERTH_AMOUNT = 1;
    private static final int NUMBER_FOR_SHIP_AMOUNT = 2;
    private static final int NUMBER_FOR_MAX_SHIP_CAPACITY = 3;


    public static void main(String[] args) throws ReadFileException {

        //todo: comments

        CreateData createData = new CreateData();
        List<Integer> data = createData.createData(PATH);
        int storageCapacity = data.get(NUMBER_FOR_STORAGE_CAPACITY);
        int berthAmount = data.get(NUMBER_FOR_BERTH_AMOUNT);
        int shipAmount = data.get(NUMBER_FOR_SHIP_AMOUNT);
        int maxShipCapacity = data.get(NUMBER_FOR_MAX_SHIP_CAPACITY);



        //создание порта
        Port port = Port.getInstance(berthAmount, storageCapacity);
        //создание кораблей
        List<Ship> shipList = port.makeShips(shipAmount, maxShipCapacity, port);

        LOGGER.info("The capacity of the storage: " + port.getStorage().getFilledCapacity()
                + "/" + storageCapacity);
        LOGGER.info("The Queue for the loading/unloading are " + shipList.size()
                + " ships: " + shipList);

        //создание потока для каждого корабля
        ExecutorService es = Executors.newFixedThreadPool(berthAmount);
        for (Ship ship : shipList) {
            Future<String> future = es.submit(ship);
            try {
                LOGGER.info(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        es.shutdown();

        LOGGER.info("* The capacity of the storage: "
                + port.getStorage().getFilledCapacity()
                + "/" + port.getStorage().getCapacity());
    }
}


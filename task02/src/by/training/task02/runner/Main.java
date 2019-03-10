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

    private static final int STORAGE_CAPACITY = 20; // емкость склада ФАЙЛ
    private static final int BERTH_AMOUNT = 2; //кол-во причалов у порта ФАЙЛ
    private static final int SHIP_AMOUNT = 3;// кол-во кораблей ФАЙЛ
    private static final int MAX_SHIP_CAPACITY = 15;//максимальная емкость
    // корабля ФАЙЛ

    public static void main(String[] args) throws ReadFileException {

        //todo: чтение из файла
        //todo: comments


        CreateData createData = new CreateData();
        createData.createData(PATH);


        //создание порта
        Port port = Port.getInstance(BERTH_AMOUNT, STORAGE_CAPACITY);
        //создание кораблей
        List<Ship> shipList = port.makeShips(SHIP_AMOUNT, MAX_SHIP_CAPACITY,
                port);

        LOGGER.info("The capacity of the storage: " + port.getStorage().getFilledCapacity()
                + "/" + STORAGE_CAPACITY);
        LOGGER.info("The Queue for the loading/unloading are " + shipList.size()
                + " ships: " + shipList);

        //создание потока для каждого корабля
       /* ExecutorService es = Executors.newFixedThreadPool(BERTH_AMOUNT);
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
                + "/" + port.getStorage().getCapacity());*/
    }
}


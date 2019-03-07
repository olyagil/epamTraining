package by.training.task02.runner;


import by.training.task02.creator.CreateData;
import by.training.task02.entity.Berth;
import by.training.task02.entity.Container;
import by.training.task02.entity.Ship;
import by.training.task02.entity.Storage;
import by.training.task02.exception.ReadFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {

    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PATH = "data//data.txt";

    public static final int STORAGE_CAPACITY = 20; // емкость склада ФАЙЛ
    public static final int BERTH_AMOUNT = 4; //кол-во причалов у порта ФАЙЛ
    public static final int SHIP_AMOUNT = 3;// кол-во кораблей ФАЙЛ
    public static final int MAX_SHIP_CAPACITY = 15;//максимальная емкость
    // корабля ФАЙЛ

    public static final int SHIP_ACTION = 2; // разгрузка/загрузка РАНДОМ
    public static final int CONTAINER_AMOUNT = 15;// заполненность склада РАНДОМ

    public static void main(String[] args) throws ReadFileException {

//        CreateData createData = new CreateData();
//        createData.createData(PATH);

        Semaphore sem = new Semaphore(1);
        Random random = new Random();

        // создание коллекции контейнеров для склада, наполняем склад
        List<Container> containerList = new ArrayList<>(CONTAINER_AMOUNT);
        for (int i = 0; i < CONTAINER_AMOUNT; i++) {
            containerList.add(new Container(i + 1));
        }

        // создание склада в порту
        Storage storage = new Storage(STORAGE_CAPACITY, containerList);

        List<Berth> berthList = new ArrayList<>(BERTH_AMOUNT);
        for (int i = 0; i < BERTH_AMOUNT; i++) {
            berthList.add(new Berth(i + 1, storage));
        }

        List<Ship> shipList = new ArrayList<>(SHIP_AMOUNT);
        // создание кораблей и распределние к причалу
        for (int i = 0; i < SHIP_AMOUNT; i++) {
            shipList.add(new Ship(sem, "ship" + (i + 1),
                    random.nextInt(MAX_SHIP_CAPACITY) + 1,
                    random.nextInt(SHIP_ACTION), storage));//random.nextInt(SHIP_ACTION)
            int randomFill = random.nextInt(shipList.get(i).getCapacityShip());
            for (int j = 0; j < randomFill; j++) {
                shipList.get(i).addContainer(new Container(i));
            }
        }


        LOGGER.info("Емкость склада: " + storage.getFilledCapacity()
                + "/" + STORAGE_CAPACITY);
        LOGGER.info("На очереди для загрузки/разгрузки стоит "
                + shipList.size() + " корабл-я(ей): " + shipList);

        //создание потока для каждого корабля
        for (int i = 0; i < shipList.size(); i++) {
            new Thread(shipList.get(i)).start();
        }


        try {
            TimeUnit.MILLISECONDS.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //Вывод на экран. Отчет in Future
        for (int i = 0; i < shipList.size(); i++) {
            Ship ship = shipList.get(i);
            LOGGER.info("Емкость корабля " + ship.getName() + " : "
                    + ship.getFilledCapacity() + "/" + ship.getCapacityShip());
        }
        LOGGER.info("* Емкость склада: " + storage.getFilledCapacity()
                + "/" + storage.getCapacity());
    }
}


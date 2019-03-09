package by.training.task02.runner;


import by.training.task02.creator.CreateData;
import by.training.task02.entity.*;
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

    private static final int STORAGE_CAPACITY = 20; // емкость склада ФАЙЛ
    private static final int BERTH_AMOUNT = 4; //кол-во причалов у порта ФАЙЛ
    private static final int SHIP_AMOUNT = 3;// кол-во кораблей ФАЙЛ
    private static final int MAX_SHIP_CAPACITY = 15;//максимальная емкость
    // корабля ФАЙЛ
    private static final int SHIP_ACTION = 2; // разгрузка/загрузка РАНДОМ
    private static Semaphore sem = new Semaphore(1);
    private static Random random = new Random();
    private static Port port;

    public static void main(String[] args) throws ReadFileException {
//todo: чтение из файла
//todo: Callable

//        CreateData createData = new CreateData();
//        createData.createData(PATH);

        //создание порта
        port = Port.getInstance(BERTH_AMOUNT, STORAGE_CAPACITY);
        //создание кораблей
        List<Ship> shipList = makeShips(SHIP_AMOUNT);

        LOGGER.info("Емкость склада: " + port.getStorage().getFilledCapacity()
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
        LOGGER.info("* Емкость склада: " + port.getStorage().getFilledCapacity()
                + "/" + port.getStorage().getCapacity());
    }

    private static List<Ship> makeShips(int SHIP_AMOUNT) {

        List<Ship> ships = new ArrayList<>(SHIP_AMOUNT);

        // создание кораблей
        for (int i = 0; i < SHIP_AMOUNT; i++) {
            ships.add(new Ship(sem, "ship" + (i + 1),
                    random.nextInt(MAX_SHIP_CAPACITY) + 1,
                    random.nextInt(SHIP_ACTION), port));
            fillShip(ships.get(i));

        }
        return ships;
    }

    //рандомоное наполнение кораблей
    private static void fillShip(Ship ship) {
        int randomFillShip = random.nextInt(ship.getCapacityShip());
        for (int i = 0; i < randomFillShip; i++) {
            ship.addContainer(new Container(i + 1));
        }
    }
}


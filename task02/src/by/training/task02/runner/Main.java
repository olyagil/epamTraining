package by.training.task02.runner;


import by.training.task02.creator.CreateData;
import by.training.task02.entity.Port;
import by.training.task02.entity.Ship;
import by.training.task02.exception.ReadFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * The {@code Main} class is used for running the program.
 *
 * @author Gil Olga
 */
class Main {

    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * The path to the file.
     */
    private static final String PATH = "data//data.txt";
    /**
     * The constant for storage capacity.
     */
    private static final int NUMBER_FOR_STORAGE_CAPACITY = 0;
    /**
     * The constant for amount of the berths.
     */
    private static final int NUMBER_FOR_BERTH_AMOUNT = 1;
    /**
     * The constant for amount of the ships.
     */
    private static final int NUMBER_FOR_SHIP_AMOUNT = 2;
    /**
     * The constant for the maximum ship capacity.
     */
    private static final int NUMBER_FOR_MAX_SHIP_CAPACITY = 3;

    /**
     * The main method.
     *
     * @param args arguments
     * @throws ReadFileException custom exception if can't read the file
     */
    public static void main(final String[] args) throws ReadFileException {

        //todo: UML
        //todo: README
        //todo: sonarLint

        CreateData createData = new CreateData();
        List<Integer> data = createData.createData(PATH);
        int storageCapacity = data.get(NUMBER_FOR_STORAGE_CAPACITY);
        int berthAmount = data.get(NUMBER_FOR_BERTH_AMOUNT);
        int shipAmount = data.get(NUMBER_FOR_SHIP_AMOUNT);
        int maxShipCapacity = data.get(NUMBER_FOR_MAX_SHIP_CAPACITY);


        //creating the port
        Port port = Port.getInstance(berthAmount, storageCapacity);
        //creating the ships
        List<Ship> shipList = port.createShips(shipAmount, maxShipCapacity);

        LOGGER.info("The capacity of the storage: "
                + port.getStorage().getFilledCapacity()
                + "/" + storageCapacity);
        LOGGER.info("The Queue for the loading/unloading are " + shipList.size()
                + " ships: " + shipList);

        //creating the threads for each ship
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


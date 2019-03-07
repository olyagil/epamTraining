//package by.training.task02.entity;
//
//import by.training.task02.entity.Container;
//import by.training.task02.entity.Storage;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.util.concurrent.TimeUnit;
//
//public class Unloader extends Thread {
//    private static final Logger LOGGER = LogManager.getLogger();
//    Storage storage;
//    int capacity = 5;
//
//    public Unloader(Storage storage) {
//        this.storage = storage;
//    }
//
//    @Override
//    public void run() {
//        try {
//            while (capacity > 0) { // пока у производителя имеются товары
//                capacity = capacity - storage.unload(); // кладем один товар на
//                // склад
//                System.out.println("Осталось разгрузить " + capacity);
//                TimeUnit.MILLISECONDS.sleep(100); // время простоя
//            }
//        } catch (InterruptedException e) {
//            System.out.println("поток производителя прерван");
//        }
//    }
//}
//
//

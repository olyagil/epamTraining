//package by.training.task02.entity;
//
//import by.training.task02.entity.Container;
//import by.training.task02.entity.Storage;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.util.concurrent.TimeUnit;
//
//public class Loader extends Thread {
//    private static final Logger LOGGER = LogManager.getLogger();
//    int capacity = 0;
//    Storage storage;
//
//    public Loader(Storage storage) {
//        this.storage = storage;
//    }
//
//    @Override
//    public void run() {
//        while (5 > capacity) {
//            try {
//                capacity = capacity + storage.load;
//                LOGGER.info("Загрузили на склад " + capacity);
//
//                TimeUnit.MILLISECONDS.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    }
//}

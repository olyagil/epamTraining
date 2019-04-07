package by.training.tourist_vouchers.runner;

import by.training.tourist_vouchers.builder.DOMBuilder;
import by.training.tourist_vouchers.builder.SAXBuilder;
import by.training.tourist_vouchers.builder.StAXBuilder;
import by.training.tourist_vouchers.creator.Creator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The main class for running the program.
 */
public class Main {
    /**
     * The path to the file.
     */
    private static final String PATH = "D://IdeaProjects//epamTraining"
            + "//task04//data//tourist-vouchers.xml";
    /**
     * The constant for logger.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * The main method.
     *
     * @param args arguments
     */
    public static void main(final String[] args) {

        Creator creator = new Creator();
//        System.out.println(creator.createVouchers(new SAXBuilder(),PATH));
        LOGGER.info(creator.createVouchers(new SAXBuilder(), PATH));
        LOGGER.info(creator.createVouchers(new DOMBuilder(), PATH));
        LOGGER.info(creator.createVouchers(new StAXBuilder(), PATH));
    }
}


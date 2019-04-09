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
public final class Main {
    /**
     * Default private constructor.
     */
    private Main() {
    }

    /**
     * The path to the file.
     */
    private static final String PATH = "data//tourist-vouchers.xml";
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

        LOGGER.info(createHead() + creator.createVouchers(new SAXBuilder(),
                PATH));

        LOGGER.info(createHead() + creator.createVouchers(new DOMBuilder(),
                PATH));

        LOGGER.info(createHead() + creator.createVouchers(new StAXBuilder(),
                PATH));
    }

    /**
     * Method for creating the head for the table.
     *
     * @return the head of the table
     */
    private static String createHead() {

        return "Id|\tBegin Data|\t\t\t\t\tNights|\tTransport|\tPrice"
                + "|\tCurrency|\tFlight|\tHotel|\tTv|\tFan|\tSafe|\tWi-Fi"
                + "|\tStars|\tRoom|\tMeal\tCountry|\n";
    }
}


package by.training.tourist_vouchers.runner;

import by.training.tourist_vouchers.builder.DOMBuilder;
import by.training.tourist_vouchers.builder.SAXBuilder;
import by.training.tourist_vouchers.builder.StAXBuilder;
import by.training.tourist_vouchers.creator.Creator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final String PATH = "D://IdeaProjects//epamTraining" +
            "//task04//data//tourist-vouchers.xml";
    private static final Logger LOGGER = LogManager.getLogger();


    public static void main(String[] args) {

        Creator creator = new Creator();
        System.out.println(creator.createVouchers(new SAXBuilder()));
        LOGGER.info(creator.createVouchers(new SAXBuilder()));
        LOGGER.info(creator.createVouchers(new DOMBuilder()));
        LOGGER.info(creator.createVouchers(new StAXBuilder()));
    }
}


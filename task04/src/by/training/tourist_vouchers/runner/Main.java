package by.training.tourist_vouchers.runner;

import by.training.tourist_vouchers.builder.BaseBuilder;
import by.training.tourist_vouchers.builder.DOMBuilder;
import by.training.tourist_vouchers.builder.SAXBuilder;
import by.training.tourist_vouchers.builder.StAXBuilder;
import by.training.tourist_vouchers.entity.Voucher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class Main {

    private static final String PATH = "data//tourist-vouchers.xml";
    private static final Logger LOGGER = LogManager.getLogger();

    private static Set<Voucher> createVouchers(BaseBuilder builder) {
        builder.buildVouchers(PATH);
        return builder.getVouchers();
    }

    public static void main(String[] args) {
        LOGGER.info(createVouchers(new SAXBuilder()));
        LOGGER.info(createVouchers(new DOMBuilder()));
        LOGGER.info(createVouchers(new StAXBuilder()));
    }
}


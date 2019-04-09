package by.training.tourist_vouchers.builder;

import by.training.tourist_vouchers.parser.SAXHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * The {@code SAXBuilder} class is used for creating the list of vouchers by
 * SAX parser.
 */
public class SAXBuilder extends BaseBuilder {
    /**
     * The constant for logger.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * The variable of the SAXHandler type.
     */
    private SAXHandler saxHandler;
    /**
     * The variable of the XMLReader type.
     */
    private XMLReader reader;

    /**
     * The constructor without parameters.
     */
    public SAXBuilder() {
        saxHandler = new SAXHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(saxHandler);
        } catch (SAXException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Overriding method to build the vouchers from file.
     *
     * @param path to file
     */
    @Override
    public void buildVouchers(final String path) {
        LOGGER.info("Parsing by the SAX parser. ");
        try {
            reader.parse(path);
        } catch (SAXException e) {
            LOGGER.error("Can't parse the text");
        } catch (IOException e) {
            LOGGER.error("Can't read the text");
        }
        for (int i = 0; i < saxHandler.getSize(); i++) {
            vouchers.add(saxHandler.getVoucher(i));
        }
    }
}

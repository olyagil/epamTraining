package by.training.tourist_vouchers.builder;

import by.training.tourist_vouchers.parser.SAXHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SAXBuilder extends BaseBuilder {
//    private static final Logger LOGGER = LogManager.getLogger();

    private SAXHandler saxHandler;
    private XMLReader reader;

    public SAXBuilder() {
        saxHandler = new SAXHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(saxHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildVouchers(String path) {
//        LOGGER.info("Parsing by the SAX parser. ");
        try {
            reader.parse(path);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < saxHandler.getSize(); i++)
            vouchers.add(saxHandler.getVoucher(i));
    }
}

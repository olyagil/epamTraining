package by.training.tourist_vouchers.builder;

import by.training.tourist_vouchers.parser.SAXHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SAXBuilder extends BaseBuilder {

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
        try {
            reader.parse(path);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        vouchers = saxHandler.getVouchers();
    }
}

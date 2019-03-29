package by.training.tourist_vouchers.builder;

import by.training.tourist_vouchers.entity.TouristVouchers;
import by.training.tourist_vouchers.entity.Voucher;
import by.training.tourist_vouchers.entity.VouchersEnum;
import by.training.tourist_vouchers.parser.SAXParser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

public class VoucherSAXBuilder {

    private Set<TouristVouchers> vouchers;

    private SAXParser saxParser;
    private XMLReader reader;

   public VoucherSAXBuilder() {
        saxParser = new SAXParser();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(saxParser);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public Set<TouristVouchers> getVouchers() {
        return vouchers;
    }

    public void buildSetVouchers(String filename) {
        try {
            reader.parse(filename);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        vouchers =getVouchers();
    }
}

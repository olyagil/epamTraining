package by.training.tourist_vouchers.runner;

import by.training.tourist_vouchers.builder.VoucherSAXBuilder;
import by.training.tourist_vouchers.parser.DomParser;
import by.training.tourist_vouchers.parser.SAXParser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Main {

    public static final String FILENAME = "data//tourist-vouchers.xml";

    public static void main(String[] args) {
//SAXParser

//            SAXParserFactory  factory = new SAXParserFactory.newInstance();
//            XMLReader reader = XMLReaderFactory.createXMLReader();
//            SAXParser parser = new SAXParser();
//            reader.setContentHandler(parser);
//            reader.parse("data//tourist-vouchers.xml");
//        VoucherSAXBuilder builder = new VoucherSAXBuilder();
//        builder.buildSetVouchers("data//tourist-vouchers.xml");


        //DOM
        DomParser domParser = new DomParser();
        domParser.buildSetVouchers(FILENAME);
        System.out.println(domParser.getVouchers());

    }
}


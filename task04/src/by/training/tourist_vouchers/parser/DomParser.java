package by.training.tourist_vouchers.parser;

import by.training.tourist_vouchers.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class DomParser {
    private static final Logger LOGGER = LogManager.getLogger();

    private Set<Voucher> vouchers;
    private DocumentBuilder documentBuilder;

    public DomParser() {
        vouchers = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public Set<Voucher> getVouchers() {
        return vouchers;
    }

    public void buildSetVouchers(String filename) {
        Document document;
        try {
            document = documentBuilder.parse(filename);
            Element root = document.getDocumentElement();

            for (VoucherType type : VoucherType.values()) {
                NodeList elements = root.getElementsByTagName(type.getType());
                Voucher voucher = null;
                for (int i = 0; i < elements.getLength(); i++) {
                    Element element = (Element) elements.item(i);
                    switch (type) {
                        case PILGRIMAGE_TOUR:
                            voucher = buildPilgrimageTour(element);
                            break;
                        case REST:
                            voucher = buildRestTour(element);
                            break;
                        case CITY_BREAK:
                            voucher = buildCityBreakTour(element);
                            break;
                        case GUIDED_TOUR:
                            voucher = buildGuidedTour(element);
                            break;
                        default:
                            LOGGER.error("Wrong type of the tour: " + type);
                    }
                    vouchers.add(voucher);
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    private Voucher buildGuidedTour(Element element) {
        Voucher guidedVoucher = new GuidedTour();
        buildVoucher(guidedVoucher, element);
        ((GuidedTour) guidedVoucher).setExcursionsNumber(Integer.parseInt(getElementTextContent(element,"excursions-number")));
        return guidedVoucher;
    }

    private Voucher buildCityBreakTour(Element element) {
        Voucher cityBreakVoucher = new CityBreak();
        buildVoucher(cityBreakVoucher, element);
        ((CityBreak) cityBreakVoucher).setShoppingCentersNumbers(Integer
                .parseInt(getElementTextContent(element, "shopping-centers-numbers")));
        return cityBreakVoucher;
    }

    private Voucher buildRestTour(Element element) {
        Voucher restVoucher = new Rest();

        return restVoucher;
    }

    private Voucher buildPilgrimageTour(Element element) {
        Voucher pilgrimageVoucher = new PilgrimageTour();
        return pilgrimageVoucher;
    }

    private Voucher buildVoucher(Voucher voucher, Element element) {
        voucher.setId(element.getAttribute("id"));
        voucher.setCountry(element.getAttribute("country"));
        voucher.setNumberNights(Integer.parseInt(element.getAttribute(
                "number-nights")));

        voucher.setBeginData(getElementTextContent(element, "begin-data"));
        voucher.setTransport(Transport.valueOf(getElementTextContent(element,
                "transport").toUpperCase()));

        Cost cost = new Cost();
        voucher.setCost(cost);
        Element costElement = (Element) element.getElementsByTagName(
                "cost").item(0);
        cost.setCurrency(Currency.valueOf(costElement.getAttribute("currency").toUpperCase()));
        cost.setPrice(BigDecimal.valueOf(Double.parseDouble(getElementTextContent(costElement,
                "price"))));
        cost.setHotelInclude(Boolean.valueOf(getElementTextContent(costElement,
                "hotel-include")));
        cost.setFlightInclude(Boolean.valueOf(getElementTextContent(costElement,
                "flight-include")));

        HotelCharacteristic hotelCharacteristic = new HotelCharacteristic();
        Element hotelElement = (Element) element.getElementsByTagName("hotel" +
                "-characteristic").item(0);
        voucher.setHotelCharacteristic(hotelCharacteristic);
        hotelCharacteristic.setRoomType(Integer.parseInt(hotelElement.getAttribute("room-type")));
        hotelCharacteristic.setMealType(Meal.valueOf(hotelElement.getAttribute("meal-type")));
        hotelCharacteristic.setNumberStars(BigInteger.valueOf(Integer.parseInt(hotelElement.getAttribute("number-stars"))));
        hotelCharacteristic.setWiFi(Boolean.valueOf(getElementTextContent(hotelElement, "wi-fi")));
        hotelCharacteristic.setSafe(Boolean.valueOf(getElementTextContent(hotelElement, "safe")));
        hotelCharacteristic.setFan(Boolean.valueOf(getElementTextContent(hotelElement, "fan")));
        hotelCharacteristic.setTv(Boolean.valueOf(getElementTextContent(hotelElement, "tv")));

        return voucher;

    }

    private String getElementTextContent(Element element, String name) {
        NodeList nodeList = element.getElementsByTagName(name);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }
}

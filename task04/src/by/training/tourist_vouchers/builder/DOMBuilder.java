package by.training.tourist_vouchers.builder;

import by.training.tourist_vouchers.entity.*;
import by.training.tourist_vouchers.entity.enumeration.Currency;
import by.training.tourist_vouchers.entity.enumeration.Meal;
import by.training.tourist_vouchers.entity.enumeration.Transport;
import by.training.tourist_vouchers.entity.enumeration.VoucherType;
import by.training.tourist_vouchers.entity.enumeration.VouchersEnum;
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

public class DOMBuilder extends BaseBuilder {
    private static final Logger LOGGER = LogManager.getLogger();
    private DocumentBuilder documentBuilder;

    public DOMBuilder() {
        vouchers = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void buildVouchers(String path) {
        Document document;
        try {
            document = documentBuilder.parse(path);
            Element root = document.getDocumentElement();

            for (VoucherType type : VoucherType.values()) {
                NodeList elements = root.getElementsByTagName(type.getValue());
                Voucher voucher = null;
                for (int i = 0; i < elements.getLength(); i++) {
                    Element element = (Element) elements.item(i);
                    LOGGER.info(element);
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
                    }
                    LOGGER.info(voucher);
                    vouchers.add(voucher);
                }
            }
        } catch (SAXException | IOException e) {
            LOGGER.error(e);
        }
    }

    private Voucher buildGuidedTour(Element element) {
        GuidedTour guidedVoucher = new GuidedTour();
        buildVoucher(guidedVoucher, element);
        LOGGER.info(element);

        guidedVoucher.setTourGuide(Boolean
                .valueOf(getElementTextContent(element,
                        VouchersEnum.TOUR_GUIDE.getValue())));
        guidedVoucher.setExcursionsNumber(Integer
                .parseInt(getElementTextContent(element,
                        VouchersEnum.EXCURSIONS_NUMBER.getValue())));
        return guidedVoucher;
    }

    private Voucher buildCityBreakTour(Element element) {
        CityBreak cityBreakVoucher = new CityBreak();
        buildVoucher(cityBreakVoucher, element);
        cityBreakVoucher.setShoppingCentersNumbers(Integer.parseInt(
                getElementTextContent(element,
                        VouchersEnum.SHOPPING_CENTERS_NUMBERS.getValue())));
        return cityBreakVoucher;
    }

    private Voucher buildRestTour(Element element) {
        Rest restVoucher = new Rest();
        buildVoucher(restVoucher, element);
        restVoucher.setResting(Boolean.valueOf(getElementTextContent(element,
                VouchersEnum.RESTING.getValue())));
        return restVoucher;
    }

    private Voucher buildPilgrimageTour(Element element) {
        PilgrimageTour pilgrimageVoucher = new PilgrimageTour();
        buildVoucher(pilgrimageVoucher, element);
        pilgrimageVoucher.setBethelNumber(Integer
                .parseInt(getElementTextContent(element,
                        VouchersEnum.BETHEL_NUMBER.getValue())));
        return pilgrimageVoucher;
    }

    private void buildVoucher(Voucher voucher, Element element) {
        voucher.setId(element.getAttribute(VouchersEnum.ID.getValue()));
        voucher.setCountry(element.getAttribute(VouchersEnum.COUNTRY.getValue()));
        if (!element.getAttribute(VouchersEnum.NUMBER_NIGHTS.getValue()).isEmpty()) {
            voucher.setNumberNights(Integer.parseInt(element.getAttribute(
                    VouchersEnum.NUMBER_NIGHTS.getValue())));
        } else {
            voucher.setNumberNights(0);
        }

        voucher.setBeginData(getElementTextContent(element,
                VouchersEnum.BEGIN_DATA.getValue()));
        voucher.setTransport(Transport.valueOf(getElementTextContent(element,
                VouchersEnum.TRANSPORT.getValue()).toUpperCase()));

        Cost cost = new Cost();
        voucher.setCost(cost);
        Element costElement = (Element) element.getElementsByTagName(
                VouchersEnum.COST.getValue()).item(0);
        if (!costElement.getAttribute(VouchersEnum.CURRENCY.getValue()).isEmpty()) {
            cost.setCurrency(Currency.valueOf(costElement
                    .getAttribute(VouchersEnum.CURRENCY.getValue()).toUpperCase()));
        } else {
            cost.setCurrency(Currency.EUR);
        }
        cost.setPrice(BigDecimal.valueOf(Double.parseDouble(
                getElementTextContent(costElement,
                        VouchersEnum.PRICE.getValue()))));
        cost.setHotelInclude(Boolean.valueOf(getElementTextContent(costElement,
                VouchersEnum.HOTEL_INCLUDE.getValue())));
        cost.setFlightInclude(Boolean.valueOf(getElementTextContent(costElement,
                VouchersEnum.FLIGHT_INCLUDE.getValue())));

        HotelCharacteristic hotelCharacteristic = new HotelCharacteristic();
        Element hotelElement = (Element) element.getElementsByTagName(
                VouchersEnum.HOTEL_CHARACTERISTIC.getValue()).item(0);
        voucher.setHotelCharacteristic(hotelCharacteristic);
        hotelCharacteristic.setRoomType(Integer
                .parseInt(hotelElement.getAttribute(VouchersEnum.ROOM_TYPE.getValue())));
        hotelCharacteristic.setMealType(Meal
                .valueOf(hotelElement.getAttribute(VouchersEnum.MEAL_TYPE.getValue())));
        hotelCharacteristic.setNumberStars(BigInteger.valueOf(Integer
                .parseInt(hotelElement.getAttribute(VouchersEnum.NUMBER_STARS.getValue()))));
        hotelCharacteristic.setWiFi(Boolean
                .valueOf(getElementTextContent(hotelElement,
                        VouchersEnum.WI_FI.getValue())));
        hotelCharacteristic.setSafe(Boolean
                .valueOf(getElementTextContent(hotelElement,
                        VouchersEnum.SAFE.getValue())));
        hotelCharacteristic.setFan(Boolean
                .valueOf(getElementTextContent(hotelElement,
                        VouchersEnum.FAN.getValue())));
        hotelCharacteristic.setTv(Boolean
                .valueOf(getElementTextContent(hotelElement,
                        VouchersEnum.TV.getValue())));
    }

    private String getElementTextContent(Element element, String name) {
        NodeList nodeList = element.getElementsByTagName(name);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}

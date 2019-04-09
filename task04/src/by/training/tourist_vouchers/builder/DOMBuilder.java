package by.training.tourist_vouchers.builder;

import by.training.tourist_vouchers.entity.CityBreak;
import by.training.tourist_vouchers.entity.Cost;
import by.training.tourist_vouchers.entity.GuidedTour;
import by.training.tourist_vouchers.entity.HotelCharacteristic;
import by.training.tourist_vouchers.entity.PilgrimageTour;
import by.training.tourist_vouchers.entity.Rest;
import by.training.tourist_vouchers.entity.Voucher;
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
import java.util.ArrayList;

/**
 * THe {@code DOMBuilder} is used for creating the list of vouchers by the
 * DOM parser.
 */
public class DOMBuilder extends BaseBuilder {
    /**
     * The constant for the logger.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * The variable of the DocumentBuilder type.
     */
    private DocumentBuilder documentBuilder;

    /**
     * The constructor with no parameters.
     */
    public DOMBuilder() {
        vouchers = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Overriding method for building vouchers by the DOM parser.
     *
     * @param path to file
     */
    @Override
    public void buildVouchers(final String path) {
        LOGGER.info("Parsing by the DOM parser. ");
        Document document;
        try {
            document = documentBuilder.parse(path);
            Element root = document.getDocumentElement();

            for (VoucherType type : VoucherType.values()) {
                NodeList elements = root.getElementsByTagName(type.getValue());
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
                            LOGGER.error("Doesn't have this type of "
                                    + "voucher.");
                            break;
                    }
                    vouchers.add(voucher);
                }
            }
        } catch (SAXException e) {
            LOGGER.error("Can parse the element");
        } catch (IOException e) {
            LOGGER.error("Can't read from text");
        }
    }

    /**
     * Method for building vouchers of the guided tour type.
     *
     * @param element of the nodeList
     * @return voucher
     */
    private Voucher buildGuidedTour(final Element element) {
        GuidedTour guidedVoucher = new GuidedTour();
        buildVoucher(guidedVoucher, element);

        guidedVoucher.setTourGuide(Boolean
                .valueOf(getElementTextContent(element,
                        VouchersEnum.TOUR_GUIDE.getValue())));
        guidedVoucher.setExcursionsNumber(Integer
                .parseInt(getElementTextContent(element,
                        VouchersEnum.EXCURSIONS_NUMBER.getValue())));
        return guidedVoucher;
    }

    /**
     * Method for building vouchers of the city break type.
     *
     * @param element of the nodeList
     * @return voucher
     */
    private Voucher buildCityBreakTour(final Element element) {
        CityBreak cityBreakVoucher = new CityBreak();
        buildVoucher(cityBreakVoucher, element);
        cityBreakVoucher.setShoppingCentersNumbers(Integer.parseInt(
                getElementTextContent(element,
                        VouchersEnum.SHOPPING_CENTERS_NUMBERS.getValue())));
        return cityBreakVoucher;
    }

    /**
     * Method for building vouchers of the rest tour type.
     *
     * @param element of the nodeList
     * @return voucher
     */
    private Voucher buildRestTour(final Element element) {
        Rest restVoucher = new Rest();
        buildVoucher(restVoucher, element);
        restVoucher.setResting(Boolean.valueOf(getElementTextContent(element,
                VouchersEnum.RESTING.getValue())));
        return restVoucher;
    }

    /**
     * Method for building vouchers of the pilgrimage tour type.
     *
     * @param element of the nodeList
     * @return voucher
     */
    private Voucher buildPilgrimageTour(final Element element) {
        PilgrimageTour pilgrimageVoucher = new PilgrimageTour();
        buildVoucher(pilgrimageVoucher, element);
        pilgrimageVoucher.setBethelNumber(Integer
                .parseInt(getElementTextContent(element,
                        VouchersEnum.BETHEL_NUMBER.getValue())));
        return pilgrimageVoucher;
    }

    /**
     * Method for building basic voucher.
     *
     * @param voucher to build
     * @param element of the nodeList
     */
    private void buildVoucher(final Voucher voucher, final Element element) {
        voucher.setId(element.getAttribute(VouchersEnum.ID.getValue()));
        voucher.setCountry(element
                .getAttribute(VouchersEnum.COUNTRY.getValue()));
        if (!element.getAttribute(VouchersEnum
                .NUMBER_NIGHTS.getValue()).isEmpty()) {
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
        if (!costElement
                .getAttribute(VouchersEnum.CURRENCY.getValue()).isEmpty()) {
            cost.setCurrency(Currency.valueOf(costElement
                    .getAttribute(VouchersEnum.CURRENCY.getValue())
                    .toUpperCase()));
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
        hotelCharacteristic.setRoomType(Integer.parseInt(hotelElement
                .getAttribute(VouchersEnum.ROOM_TYPE.getValue())));
        hotelCharacteristic.setMealType(Meal.valueOf(hotelElement
                .getAttribute(VouchersEnum.MEAL_TYPE.getValue())));
        hotelCharacteristic.setNumberStars(BigInteger.valueOf(Integer
                .parseInt(hotelElement.getAttribute(VouchersEnum.NUMBER_STARS
                        .getValue()))));
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

    /**
     * Method for getting the text of element.
     *
     * @param element of the node.
     * @param name    of the tag
     * @return parameter
     */
    private String getElementTextContent(final Element element,
                                         final String name) {
        NodeList nodeList = element.getElementsByTagName(name);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}

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

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * The {@code StAXBuilder} is used for creating the list of vouchers by the
 * DOM parser.
 */
public class StAXBuilder extends BaseBuilder {

    /**
     * The constant for logger.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * The variable of XMLInputFactory type.
     */
    private XMLInputFactory inputFactory;

    /**
     * The constructor without parameters.
     */
    public StAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    /**
     * Overriding method for building the vouchers from file.
     *
     * @param path to file
     */
    @Override
    public void buildVouchers(final String path) {
        LOGGER.info("Parsing by the StAX parser. ");
        try (FileInputStream inputStream =
                     new FileInputStream(new File(path))) {
            XMLStreamReader reader =
                    inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                if (reader.next() == XMLStreamConstants.START_ELEMENT) {
                    String name = reader.getLocalName();
                    if (VouchersEnum.CITY_BREAK.getValue().equals(name)
                            || VouchersEnum.GUIDED_TOUR.getValue().equals(name)
                            || VouchersEnum.PILGRIMAGE_TOUR.getValue()
                            .equals(name)
                            || VouchersEnum.REST.getValue().equals(name)
                    ) {
                        vouchers.add(buildVoucher(name, reader));
                    }
                }
            }
        } catch (XMLStreamException e) {
            LOGGER.error("StAX parsing error! ", e.getMessage());
        } catch (FileNotFoundException e) {
            LOGGER.error("File " + path + " not found! ", e);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Method for building the voucher.
     *
     * @param voucherType type
     * @param reader      reader
     * @return voucher
     * @throws XMLStreamException if don't have element
     */
    private Voucher buildVoucher(final String voucherType,
                                 final XMLStreamReader reader)
            throws XMLStreamException {
        Voucher voucher = null;
        switch (VouchersEnum.valueOf(voucherType.toUpperCase().replaceAll("-",
                "_"))) {
            case REST:
                voucher = new Rest();
                break;
            case CITY_BREAK:
                voucher = new CityBreak();
                break;
            case GUIDED_TOUR:
                voucher = new GuidedTour();
                break;
            case PILGRIMAGE_TOUR:
                voucher = new PilgrimageTour();
                break;
            default:
                break;
        }
        voucher.setId(reader.getAttributeValue(null,
                VouchersEnum.ID.getValue()));
        voucher.setCountry(reader.getAttributeValue(null,
                VouchersEnum.COUNTRY.getValue()));
        if (reader.getAttributeValue(null,
                VouchersEnum.NUMBER_NIGHTS.getValue()) != null) {
            voucher.setNumberNights(Integer.parseInt(reader.getAttributeValue(
                    null, VouchersEnum.NUMBER_NIGHTS.getValue())));
        } else {
            voucher.setNumberNights(0);
        }

        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    String name = reader.getLocalName();
                    switch (VouchersEnum.valueOf(name.toUpperCase()
                            .replaceAll("-", "_"))) {
                        case BEGIN_DATA:
                            voucher.setBeginData(getXMLText(reader));
                            break;
                        case TRANSPORT:
                            voucher.setTransport(Transport
                                    .valueOf(getXMLText(reader).toUpperCase()));
                            break;
                        case COST:
                            voucher.setCost(getXMLCost(reader));
                            break;
                        case HOTEL_CHARACTERISTIC:
                            voucher.setHotelCharacteristic(
                                    getXMLHotelCharacteristic(reader));
                            break;
                        case SHOPPING_CENTERS_NUMBERS:
                            ((CityBreak) voucher)
                                    .setShoppingCentersNumbers(Integer
                                            .parseInt(getXMLText(reader)));
                            break;
                        case TOUR_GUIDE:
                            ((GuidedTour) voucher).setTourGuide(Boolean
                                    .valueOf(getXMLText(reader)));
                            break;
                        case EXCURSIONS_NUMBER:
                            ((GuidedTour) voucher).setExcursionsNumber(Integer
                                    .parseInt(getXMLText(reader)));
                            break;
                        case RESTING:
                            ((Rest) voucher).setResting(Boolean
                                    .valueOf(getXMLText(reader)));
                            break;
                        case BETHEL_NUMBER:
                            ((PilgrimageTour) voucher).setBethelNumber(Integer
                                    .parseInt(getXMLText(reader)));
                            break;
                        default:
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (VoucherType.CITY_BREAK.getValue().equals(name)
                            || VoucherType.GUIDED_TOUR.getValue().equals(name)
                            || VoucherType.PILGRIMAGE_TOUR.getValue()
                            .equals(name)
                            || VoucherType.REST.getValue().equals(name)
                    ) {
                        return voucher;
                    }
                    break;
                default:
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }

    /**
     * Method for creating the hotel characteristic.
     *
     * @param reader reader
     * @return hotel characteristic
     * @throws XMLStreamException if can't create hotel characteristic
     */
    private HotelCharacteristic getXMLHotelCharacteristic(final XMLStreamReader
                                                                  reader)
            throws XMLStreamException {
        HotelCharacteristic hotelCharacteristic = new HotelCharacteristic();
        hotelCharacteristic.setNumberStars(BigInteger.valueOf(Integer
                .parseInt(reader.getAttributeValue(null,
                        VouchersEnum.NUMBER_STARS.getValue()))));
        hotelCharacteristic.setMealType(Meal.valueOf(reader.
                getAttributeValue(null,
                        VouchersEnum.MEAL_TYPE.getValue())));
        hotelCharacteristic.setRoomType(Integer.parseInt(reader.
                getAttributeValue(null,
                        VouchersEnum.ROOM_TYPE.getValue())));

        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    String name = reader.getLocalName();
                    switch (VouchersEnum.valueOf(name.toUpperCase()
                            .replaceAll("-", "_"))) {
                        case WI_FI:
                            hotelCharacteristic.setWiFi(Boolean
                                    .valueOf(getXMLText(reader)));
                            break;
                        case FAN:
                            hotelCharacteristic.setFan(Boolean
                                    .valueOf(getXMLText(reader)));
                            break;
                        case TV:
                            hotelCharacteristic.setTv(Boolean
                                    .valueOf(getXMLText(reader)));
                            break;
                        case SAFE:
                            hotelCharacteristic.setSafe(Boolean
                                    .valueOf(getXMLText(reader)));
                            break;
                        default:
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (VouchersEnum.HOTEL_CHARACTERISTIC.getValue()
                            .equals(reader.getLocalName())) {
                        return hotelCharacteristic;
                    }
                    break;
                default:
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag "
                + "Hotel characteristic");
    }

    /**
     * Method for creating the cost.
     *
     * @param reader reader
     * @return cost
     * @throws XMLStreamException is thrown if can't create cost
     */
    private Cost getXMLCost(final XMLStreamReader reader)
            throws XMLStreamException {
        Cost cost = new Cost();
        if (reader.getAttributeValue(null,
                VouchersEnum.CURRENCY.getValue()) != null) {
            cost.setCurrency(Currency.valueOf(reader
                    .getAttributeValue(null,
                            VouchersEnum.CURRENCY.getValue())));
        } else {
            cost.setCurrency(Currency.EUR);
        }

        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    String name = reader.getLocalName();
                    switch (VouchersEnum.valueOf(name.toUpperCase()
                            .replaceAll("-", "_"))) {
                        case PRICE:
                            cost.setPrice(BigDecimal.valueOf(Double
                                    .parseDouble(getXMLText(reader))));
                            break;
                        case HOTEL_INCLUDE:
                            cost.setHotelInclude(Boolean
                                    .valueOf(getXMLText(reader)));
                            break;
                        case FLIGHT_INCLUDE:
                            cost.setFlightInclude(Boolean
                                    .valueOf(getXMLText(reader)));
                            break;
                        default:
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (VouchersEnum.COST.getValue()
                            .equals(reader.getLocalName())) {
                        return cost;
                    }
                    break;
                default:
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Cost");
    }

    /**
     * Method for getting the xml text.
     *
     * @param reader reader
     * @return xml text
     * @throws XMLStreamException thrown if can't read
     */
    private String getXMLText(final XMLStreamReader reader)
            throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}



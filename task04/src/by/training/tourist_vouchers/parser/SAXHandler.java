package by.training.tourist_vouchers.parser;

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
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * The {@code SAXHandler} is used for handling the data.
 */
public class SAXHandler extends DefaultHandler {
    /**
     * The list of vouchers.
     */
    private List<Voucher> vouchers;
    /**
     * The current voucher.
     */
    private Voucher currentVoucher;
    /**
     * The current enum.
     */
    private VouchersEnum currentEnum;
    /**
     * The range of enum.
     */
    private EnumSet<VouchersEnum> withText;

    /**
     * The constructor without parameters.
     */
    public SAXHandler() {
        vouchers = new ArrayList<>();
        withText = EnumSet.range(VouchersEnum.BEGIN_DATA,
                VouchersEnum.BETHEL_NUMBER);
    }

    /**
     * The method for getting the the voucher by the specific index.
     *
     * @param index of the voucher int the list
     * @return voucher
     */
    public Voucher getVoucher(final int index) {
        return vouchers.get(index);
    }

    /**
     * The method foe getting the size of the voucher list.
     *
     * @return size
     */
    public int getSize() {
        return vouchers.size();
    }

    /**
     * Method for parsing the xml text.
     *
     * @param uri        of the element
     * @param localName  of the element
     * @param qName      of the element
     * @param attributes of the element
     */
    @Override
    public void startElement(final String uri, final String localName,
                             final String qName, final Attributes attributes) {

        if (VouchersEnum.CITY_BREAK.getValue().equals(localName)) {
            currentVoucher = new CityBreak();
        } else if (VouchersEnum.GUIDED_TOUR.getValue().equals(localName)) {
            currentVoucher = new GuidedTour();
        } else if (VouchersEnum.REST.getValue().equals(localName)) {
            currentVoucher = new Rest();
        } else if (VouchersEnum.PILGRIMAGE_TOUR.getValue().equals(localName)) {
            currentVoucher = new PilgrimageTour();
        } else if (VouchersEnum.COST.getValue().equals(localName)) {
            Cost cost = new Cost();
            if (attributes.getValue(VouchersEnum.CURRENCY.getValue()) != null) {
                cost.setCurrency(Currency.valueOf(attributes.getValue(
                        VouchersEnum.CURRENCY.getValue())));
            } else {
                cost.setCurrency(Currency.EUR);
            }
            currentVoucher.setCost(cost);
        } else if (VouchersEnum.HOTEL_CHARACTERISTIC.getValue()
                .equals(localName)) {
            HotelCharacteristic hotelCharacteristic = new HotelCharacteristic();
            hotelCharacteristic.setRoomType(Integer.parseInt(attributes
                    .getValue(VouchersEnum.ROOM_TYPE.getValue())));
            hotelCharacteristic.setMealType(Meal.valueOf(attributes.getValue(
                    VouchersEnum.MEAL_TYPE.getValue())));
            hotelCharacteristic.setNumberStars(BigInteger.valueOf(
                    Integer.parseInt(attributes.getValue(VouchersEnum
                            .NUMBER_STARS.getValue()))));
            currentVoucher.setHotelCharacteristic(hotelCharacteristic);
        } else {
            VouchersEnum temp =
                    VouchersEnum.valueOf(localName.toUpperCase().replaceAll(
                            "-", "_"));
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
        if (VoucherType.CITY_BREAK.getValue().equals(localName)
                || VoucherType.GUIDED_TOUR.getValue().equals(localName)
                || VoucherType.PILGRIMAGE_TOUR.getValue().equals(localName)
                || VoucherType.REST.getValue().equals(localName)
        ) {
            currentVoucher.setId(attributes.getValue(VouchersEnum
                    .ID.getValue()));
            currentVoucher.setCountry(attributes.getValue(VouchersEnum
                    .COUNTRY.getValue()));

            if (attributes
                    .getValue(VouchersEnum.NUMBER_NIGHTS.getValue()) != null) {
                currentVoucher.setNumberNights(Integer.parseInt(attributes
                        .getValue(VouchersEnum.NUMBER_NIGHTS.getValue())));
            } else {
                currentVoucher.setNumberNights(0);
            }
        }
    }

    /**
     * Method for getting the xml text.
     *
     * @param ch     text
     * @param start  of the element's text
     * @param length of the element's text
     */
    @Override
    public void characters(final char[] ch, final int start, final int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case BEGIN_DATA:
                    currentVoucher.setBeginData(s);
                    break;
                case TRANSPORT:
                    currentVoucher.setTransport(Transport
                            .valueOf(s.toUpperCase()));
                    break;
                case PRICE:
                    currentVoucher.getCost()
                            .setPrice(BigDecimal
                                    .valueOf(Double.parseDouble(s)));
                    break;
                case FLIGHT_INCLUDE:
                    currentVoucher.getCost()
                            .setFlightInclude(Boolean.valueOf(s));
                    break;
                case HOTEL_INCLUDE:
                    currentVoucher.getCost()
                            .setHotelInclude(Boolean.valueOf(s));
                    break;
                case TV:
                    currentVoucher.getHotelCharacteristic()
                            .setTv(Boolean.valueOf(s));
                    break;
                case FAN:
                    currentVoucher.getHotelCharacteristic()
                            .setFan(Boolean.valueOf(s));
                    break;
                case SAFE:
                    currentVoucher.getHotelCharacteristic()
                            .setSafe(Boolean.valueOf(s));
                    break;
                case WI_FI:
                    currentVoucher.getHotelCharacteristic()
                            .setWiFi(Boolean.valueOf(s));
                    break;
                case SHOPPING_CENTERS_NUMBERS:
                    ((CityBreak) currentVoucher)
                            .setShoppingCentersNumbers(Integer.parseInt(s));
                    break;
                case EXCURSIONS_NUMBER:
                    ((GuidedTour) currentVoucher)
                            .setExcursionsNumber(Integer.parseInt(s));
                    break;
                case TOUR_GUIDE:
                    ((GuidedTour) currentVoucher)
                            .setTourGuide(Boolean.valueOf(s));
                    break;
                case RESTING:
                    ((Rest) currentVoucher)
                            .setResting(Boolean.valueOf(s));
                    break;
                case BETHEL_NUMBER:
                    ((PilgrimageTour) currentVoucher)
                            .setBethelNumber(Integer.parseInt(s));
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum
                            .getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }

    /**
     * Method for action when elements is finished.
     *
     * @param uri       of the element
     * @param localName of the element
     * @param qName     of the element
     */
    @Override
    public void endElement(final String uri, final String localName,
                           final String qName) {
        switch (VouchersEnum.valueOf(localName.toUpperCase().replaceAll("-",
                "_"))) {
            case CITY_BREAK:
            case GUIDED_TOUR:
            case REST:
            case PILGRIMAGE_TOUR:
                vouchers.add(currentVoucher);
                break;
            default:
                break;
        }
    }

}

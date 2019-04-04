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

public class SAXHandler extends DefaultHandler {
    //    private static final Logger LOGGER = LogManager.getLogger();
    private List<Voucher> vouchers;
    private Voucher currentVoucher;
    private VouchersEnum currentEnum;
    private EnumSet<VouchersEnum> withText;

    public SAXHandler() {
        vouchers = new ArrayList<>();
        withText = EnumSet.range(VouchersEnum.BEGIN_DATA,
                VouchersEnum.BETHEL_NUMBER);
    }

    public Voucher getVoucher(int index) {
        return vouchers.get(index);
    }

    public int getSize() {
        return vouchers.size();
    }

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) {

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
        } else if (VouchersEnum.HOTEL_CHARACTERISTIC.getValue().equals(localName)) {
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
            currentVoucher.setId(attributes.getValue(VouchersEnum.ID.getValue()));
            currentVoucher.setCountry(attributes.getValue(VouchersEnum
                    .COUNTRY.getValue()));

            if (attributes.getValue(VouchersEnum.NUMBER_NIGHTS.getValue()) != null) {
                currentVoucher.setNumberNights(Integer.parseInt(attributes
                        .getValue(VouchersEnum.NUMBER_NIGHTS.getValue())));
            } else {
                currentVoucher.setNumberNights(0);
            }
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case BEGIN_DATA:
                    currentVoucher.setBeginData(s);
                    break;
                case TRANSPORT:
                    currentVoucher.setTransport(Transport.valueOf(s.toUpperCase()));
                    break;
                case PRICE:
                    currentVoucher.getCost()
                            .setPrice(BigDecimal.valueOf(Double.parseDouble(s)));
                    break;
                case FLIGHT_INCLUDE:
                    currentVoucher.getCost().setFlightInclude(Boolean.valueOf(s));
                    break;
                case HOTEL_INCLUDE:
                    currentVoucher.getCost().setHotelInclude(Boolean.valueOf(s));
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
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(),
                            currentEnum.name());
            }
        }
        currentEnum = null;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (VouchersEnum.valueOf(localName.toUpperCase().replaceAll("-",
                "_"))) {
            case CITY_BREAK:
            case GUIDED_TOUR:
            case REST:
            case PILGRIMAGE_TOUR:
                vouchers.add(currentVoucher);
                break;
        }
    }

}

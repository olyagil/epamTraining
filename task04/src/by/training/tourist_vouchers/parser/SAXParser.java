package by.training.tourist_vouchers.parser;

import by.training.tourist_vouchers.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class SAXParser extends DefaultHandler {
    private Set<Voucher> vouchers;
    private Voucher currentVoucher;
    private VouchersEnum currentEnum;

    public SAXParser() {
        vouchers = new HashSet<>();
    }

    public Set<Voucher> getVouchers() {
        return vouchers;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("tourist-vouchers".equals(localName)) {
            vouchers.add(currentVoucher);
        }
    }

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) throws SAXException {
        System.out.println(" ln " + localName + " qN " + qName);
        if ("city-break".equals(localName)) {
            currentVoucher = new CityBreak();
        }
        if ("guided-tour".equals(localName)) {
            currentVoucher = new GuidedTour();
        }
        if ("rest".equals(localName)) {
            currentVoucher = new Rest();
        }
        if ("pilgrimage-tour".equals(localName)) {
            currentVoucher = new PilgrimageTour();
        } else {
            currentVoucher = new Voucher();
        }

        System.out.println(currentVoucher);
        System.out.println(attributes.getValue(0));
        currentVoucher.setId(attributes.getValue("id"));
        currentVoucher.setCountry(attributes.getValue("country"));
        if (attributes.getValue("number-nights") == null) {
            currentVoucher.setNumberNights(Integer.parseInt(attributes.getValue("number-nights")));
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        if (currentEnum != null) {
            switch (currentEnum) {
                case BEGIN_DATA:
                   currentVoucher.setBeginData(s);
                    break;
                case TRANSPORT:
                    currentVoucher.setTransport(Transport.valueOf(s));
                    break;
                case CURRENCY:
                    currentVoucher.getCost().setCurrency(Currency.valueOf(s));
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
                case NUMBER_STARS:
                    currentVoucher.getHotelCharacteristic()
                            .setNumberStars(BigInteger.valueOf(Integer.parseInt(s)));
                    break;
                case MEAL_TYPE:
                    currentVoucher.getHotelCharacteristic().setMealType(Meal.valueOf(s));
                    break;
                case ROOM_TYPE:
                    currentVoucher.getHotelCharacteristic().setRoomType(Integer.parseInt(s));
                    break;
                case TV:
                    currentVoucher.getHotelCharacteristic().setTv(Boolean.valueOf(s));
                    break;
                case FAN:
                    currentVoucher.getHotelCharacteristic().setFan(Boolean.valueOf(s));
                    break;
                case SAFE:
                    currentVoucher.getHotelCharacteristic().setSafe(Boolean.valueOf(s));
                    break;
                case WI_FI:
                    currentVoucher.getHotelCharacteristic().setWiFi(Boolean.valueOf(s));
                    break;
//                default:
//                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(),
//                            currentEnum.name());
            }
        }
        currentEnum = null;

    }

    @Override
    public void endDocument() throws SAXException {
    }
}

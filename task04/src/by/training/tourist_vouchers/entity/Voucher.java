package by.training.tourist_vouchers.entity;

import by.training.tourist_vouchers.entity.enumeration.Transport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


/**
 * <p>Java class for Voucher complex type.
 *
 * <p>The following schema fragment specifies the expected
 * content contained within this class.
 * &lt;element name="begin-data" type="dateTime"/&gt;
 * &lt;element name="transport" type="Transport"/&gt;
 * &lt;element name="cost" type="Cost"/&gt;
 * &lt;element name="hotel-characteristic" type="HotelCharacteristic"/&gt;
 * &lt;attribute name="id" use="required" type="Identification" /&gt;
 * &lt;attribute name="country" use="required" type="string" /&gt;
 * &lt;attribute name="number-nights" type="nonNegativeInteger" default="0" ;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Voucher", propOrder = {
        "beginData",
        "transport",
        "cost",
        "hotelCharacteristic"
})
@XmlSeeAlso({
        CityBreak.class,
        Rest.class,
        GuidedTour.class,
        PilgrimageTour.class
})
public class Voucher {
    /**
     * The variable for hashCode.
     */
    private static final int PRIME = 31;
    /**
     * The variable for begin date.
     */
    @XmlElement(name = "begin-data", required = true)
    @XmlSchemaType(name = "dateTime")
    private XMLGregorianCalendar beginData;
    /**
     * The variable for transport.
     */
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    private Transport transport;
    /**
     * The variable for cost.
     */
    @XmlElement(required = true)
    private Cost cost;
    /**
     * The variable for hotel characteristic.
     */
    @XmlElement(name = "hotel-characteristic", required = true)
    private HotelCharacteristic hotelCharacteristic;
    /**
     * The variable for id.
     */
    @XmlAttribute(name = "id", required = true)
    private String id;
    /**
     * The variable for country.
     */
    @XmlAttribute(name = "country", required = true)
    private String country;
    /**
     * The variable for number nights..
     */
    @XmlAttribute(name = "number-nights")
    @XmlSchemaType(name = "nonNegativeInteger")
    private BigInteger numberNights;

    /**
     * Gets the value of the beginData property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getBeginData() {
        return beginData;
    }

    /**
     * Sets the value of the beginData property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setBeginData(String value) {
        GregorianCalendar calendar = new GregorianCalendar();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            calendar.setTime(format.parse(value));
            beginData =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the value of the transport property.
     *
     * @return possible object is
     * {@link Transport }
     */
    public Transport getTransport() {
        return transport;
    }

    /**
     * Sets the value of the transport property.
     *
     * @param value allowed object is
     *              {@link Transport }
     */
    public void setTransport(Transport value) {
        this.transport = value;
    }

    /**
     * Gets the value of the cost property.
     *
     * @return possible object is
     * {@link Cost }
     */
    public Cost getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     *
     * @param value allowed object is
     *              {@link Cost }
     */
    public void setCost(Cost value) {
        this.cost = value;
    }

    /**
     * Gets the value of the hotelCharacteristic property.
     *
     * @return possible object is
     * {@link HotelCharacteristic }
     */
    public HotelCharacteristic getHotelCharacteristic() {
        return hotelCharacteristic;
    }

    /**
     * Sets the value of the hotelCharacteristic property.
     *
     * @param value allowed object is
     *              {@link HotelCharacteristic }
     */
    public void setHotelCharacteristic(final HotelCharacteristic value) {
        this.hotelCharacteristic = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(final String value) {
        this.id = value;
    }

    /**
     * Gets the value of the country property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCountry(final String value) {
        this.country = value;
    }

    /**
     * Gets the value of the numberNights property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getNumberNights() {
        if (numberNights == null) {
            return new BigInteger("0");
        } else {
            return numberNights;
        }
    }

    /**
     * Sets the value of the numberNights property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setNumberNights(final int value) {
        this.numberNights = BigInteger.valueOf(value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Voucher voucher = (Voucher) o;

        if (getBeginData() != null
                ? !getBeginData().equals(voucher.getBeginData())
                : voucher.getBeginData() != null)
            return false;
        if (getTransport() != voucher.getTransport()) {
            return false;
        }
        if (getCost() != null ? !getCost().equals(voucher.getCost())
                : voucher.getCost() != null) {
            return false;
        }
        if (getHotelCharacteristic() != null
                ? !getHotelCharacteristic().equals(voucher.getHotelCharacteristic())
                : voucher.getHotelCharacteristic() != null) {
            return false;
        }
        if (getId() != null ? !getId().equals(voucher.getId())
                : voucher.getId() != null) {
            return false;
        }
        if (getCountry() != null ? !getCountry().equals(voucher.getCountry())
                : voucher.getCountry() != null) {
            return false;
        }
        return getNumberNights() != null
                ? getNumberNights().equals(voucher.getNumberNights())
                : voucher.getNumberNights() == null;
    }

    @Override
    public int hashCode() {
        int result = getBeginData() != null ? getBeginData().hashCode() : 0;
        result = PRIME * result + (getTransport() != null
                ? getTransport().hashCode() : 0);
        result = PRIME * result + (getCost() != null
                ? getCost().hashCode() : 0);
        result = PRIME * result + (getHotelCharacteristic() != null
                ? getHotelCharacteristic().hashCode() : 0);
        result = PRIME * result + (getId() != null ? getId().hashCode() : 0);
        result = PRIME * result + (getCountry() != null
                ? getCountry().hashCode() : 0);
        result = PRIME * result + (getNumberNights() != null
                ? getNumberNights().hashCode() : 0);
        return result;
    }

    /**
     * Method to represent class as a string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return " id = '" + id + '\'' + ", start: " + beginData
                + ", number of nights: " + numberNights + ", cost=" + cost
                + ", transport: " + transport + ", hotel characteristic:"
                + hotelCharacteristic + ", country: '" + country + '\'';
    }
}

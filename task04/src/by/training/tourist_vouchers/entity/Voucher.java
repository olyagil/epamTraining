package by.training.tourist_vouchers.entity;

import by.training.tourist_vouchers.entity.enumeration.Transport;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
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


/**
 * <p>Java class for Voucher complex type.
 *
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * &lt;element name="begin-data" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 * &lt;element name="transport" type="{http://www.training.by/tourist-vouchers}Transport"/&gt;
 * &lt;element name="cost" type="{http://www.training.by/tourist-vouchers}Cost"/&gt;
 * &lt;element name="hotel-characteristic" type="{http://www.training.by/tourist-vouchers}HotelCharacteristic"/&gt;
 * &lt;attribute name="id" use="required" type="{http://www.training.by/tourist-vouchers}Identification" /&gt;
 * &lt;attribute name="country" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 * &lt;attribute name="number-nights" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" default="0" /&gt;
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

    @XmlElement(name = "begin-data", required = true)
    @XmlSchemaType(name = "dateTime")
    private XMLGregorianCalendar beginData;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    private Transport transport;
    @XmlElement(required = true)
    protected Cost cost;
    @XmlElement(name = "hotel-characteristic", required = true)
    private HotelCharacteristic hotelCharacteristic;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "country", required = true)
    protected String country;
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
    public void setHotelCharacteristic(HotelCharacteristic value) {
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
    public void setId(String value) {
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
    public void setCountry(String value) {
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
    public void setNumberNights(int value) {
        this.numberNights = BigInteger.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voucher voucher = (Voucher) o;

        if (getBeginData() != null ? !getBeginData().equals(voucher.getBeginData()) : voucher.getBeginData() != null)
            return false;
        if (getTransport() != voucher.getTransport()) return false;
        if (getCost() != null ? !getCost().equals(voucher.getCost()) : voucher.getCost() != null)
            return false;
        if (getHotelCharacteristic() != null ? !getHotelCharacteristic().equals(voucher.getHotelCharacteristic()) : voucher.getHotelCharacteristic() != null)
            return false;
        if (getId() != null ? !getId().equals(voucher.getId()) : voucher.getId() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(voucher.getCountry()) : voucher.getCountry() != null)
            return false;
        return getNumberNights() != null ? getNumberNights().equals(voucher.getNumberNights()) : voucher.getNumberNights() == null;
    }

    @Override
    public int hashCode() {
        int result = getBeginData() != null ? getBeginData().hashCode() : 0;
        result = 31 * result + (getTransport() != null ? getTransport().hashCode() : 0);
        result = 31 * result + (getCost() != null ? getCost().hashCode() : 0);
        result = 31 * result + (getHotelCharacteristic() != null ? getHotelCharacteristic().hashCode() : 0);
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getNumberNights() != null ? getNumberNights().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return " id = '" + id + '\'' + ", start: " + beginData
                + ", number of nights: " + numberNights + ", cost=" + cost
                + ", transport: " + transport + ", hotel characteristic:"
                + hotelCharacteristic + ", country: '" + country + '\'';
    }
}

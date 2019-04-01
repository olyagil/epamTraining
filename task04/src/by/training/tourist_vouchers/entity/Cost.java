package by.training.tourist_vouchers.entity;

import by.training.tourist_vouchers.entity.enumeration.Currency;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Cost complex type.
 * <p>
 * &lt;complexType name="Cost"&gt;
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 * &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 * &lt;element name="flight-include" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 * &lt;element name="hotel-include" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 * &lt;attribute name="currency" type="{http://www.training.by/tourist-vouchers}Currency" default="EUR" /&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cost", propOrder = {
        "price",
        "flightInclude",
        "hotelInclude"
})
public class Cost {

    @XmlElement(required = true)
    private BigDecimal price;
    @XmlElement(name = "flight-include", defaultValue = "false")
    private boolean flightInclude;
    @XmlElement(name = "hotel-include", defaultValue = "true")
    private boolean hotelInclude;
    @XmlAttribute(name = "currency")
    private Currency currency;

    /**
     * Gets the value of the price property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the flightInclude property.
     */
    public boolean isFlightInclude() {
        return flightInclude;
    }

    /**
     * Sets the value of the flightInclude property.
     */
    public void setFlightInclude(boolean value) {
        this.flightInclude = value;
    }

    /**
     * Gets the value of the hotelInclude property.
     */
    public boolean isHotelInclude() {
        return hotelInclude;
    }

    /**
     * Sets the value of the hotelInclude property.
     */
    public void setHotelInclude(boolean value) {
        this.hotelInclude = value;
    }

    /**
     * Gets the value of the currency property.
     *
     * @return possible object is
     * {@link Currency }
     */
    public Currency getCurrency() {
        if (currency == null) {
            return Currency.EUR;
        } else {
            return currency;
        }
    }

    /**
     * Sets the value of the currency property.
     *
     * @param value allowed object is
     *              {@link Currency }
     */
    public void setCurrency(Currency value) {
        this.currency = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cost cost = (Cost) o;

        if (isFlightInclude() != cost.isFlightInclude()) return false;
        if (isHotelInclude() != cost.isHotelInclude()) return false;
        if (getPrice() != null ? !getPrice().equals(cost.getPrice()) : cost.getPrice() != null)
            return false;
        return getCurrency() == cost.getCurrency();
    }

    @Override
    public int hashCode() {
        int result = getPrice() != null ? getPrice().hashCode() : 0;
        result = 31 * result + (isFlightInclude() ? 1 : 0);
        result = 31 * result + (isHotelInclude() ? 1 : 0);
        result = 31 * result + (getCurrency() != null ? getCurrency().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "price=" + price +
                ", flightInclude=" + flightInclude +
                ", hotelInclude=" + hotelInclude +
                ", currency=" + currency +
                '}';
    }
}

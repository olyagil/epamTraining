package by.training.tourist_vouchers.entity;

import by.training.tourist_vouchers.entity.enumeration.Currency;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for Cost complex type.
 * <p>
 * &lt;complexType name="Cost"&gt;
 * &lt;element name="price" type="decimal"/&gt;
 * &lt;element name="flight-include" type="boolean"/&gt;
 * &lt;element name="hotel-include" type="boolean"/&gt;
 * &lt;attribute name="currency" type="Currency" default="EUR" /&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cost", propOrder = {
        "price",
        "flightInclude",
        "hotelInclude"
})
public class Cost {
    /**
     * The constant for hashCode.
     */
    private static final int PRIME = 31;
    /**
     * The variable for price.
     */
    @XmlElement(required = true)
    private BigDecimal price;
    /**
     * The variable indicating if flight is enabled.
     */
    @XmlElement(name = "flight-include", defaultValue = "false")
    private boolean flightInclude;
    /**
     * The variable indicating if hotel is enabled.
     */
    @XmlElement(name = "hotel-include", defaultValue = "true")
    private boolean hotelInclude;
    /**
     * The variable for currency.
     */
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
    public void setPrice(final BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the flightInclude property.
     *
     * @return true if flight is included
     */
    public boolean isFlightInclude() {
        return flightInclude;
    }

    /**
     * Sets the value of the flightInclude property.
     *
     * @param value which is needed to be set
     */
    public void setFlightInclude(final boolean value) {
        this.flightInclude = value;
    }

    /**
     * Gets the value of the hotelInclude property.
     *
     * @return true if hotel is included
     */
    public boolean isHotelInclude() {
        return hotelInclude;
    }

    /**
     * Sets the value of the hotelInclude property.
     *
     * @param value which is needed to be set
     */
    public void setHotelInclude(final boolean value) {
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
    public void setCurrency(final Currency value) {
        this.currency = value;
    }

    /**
     * Overriding equals method for proper comparison.
     *
     * @param o another object
     * @return true if equals
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cost cost = (Cost) o;

        if (isFlightInclude() != cost.isFlightInclude()) {
            return false;
        }
        if (isHotelInclude() != cost.isHotelInclude()) {
            return false;
        }
        if (getPrice() != null ? !getPrice().equals(cost.getPrice())
                : cost.getPrice() != null) {
            return false;
        }
        return getCurrency() == cost.getCurrency();
    }

    /**
     * Overriding method hashCode for determining hashcode.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int result = getPrice() != null ? getPrice().hashCode() : 0;
        result = PRIME * result + (isFlightInclude() ? 1 : 0);
        result = PRIME * result + (isHotelInclude() ? 1 : 0);
        result = PRIME * result + (getCurrency() != null
                ? getCurrency().hashCode() : 0);
        return result;
    }

    /**
     * Method to represent class as a string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Cost{ price=" + price + ", currency=" + currency
                + ", flightInclude=" + flightInclude + ", hotelInclude="
                + hotelInclude + '}';
    }
}

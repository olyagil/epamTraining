package by.training.tourist_vouchers.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for CityBreak complex type.
 * <p>
 * &lt;element name="shopping-centers-numbers"&gt;
 * &lt;maxInclusive value="15"/&gt;
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CityBreak", propOrder = {
        "shoppingCentersNumbers"
})
public class CityBreak extends Voucher {
    /**
     * The constant for the hashCode.
     */
    private static final int PRIME = 31;
    /**
     * The variable for number of shopping centers in the city break voucher.
     */
    @XmlElement(name = "shopping-centers-numbers")
    private int shoppingCentersNumbers;

    /**
     * Gets the value of the shoppingCentersNumbers property.
     *
     * @return number of shopping centers
     */
    public int getShoppingCentersNumbers() {
        return shoppingCentersNumbers;
    }

    /**
     * Sets the value of the shoppingCentersNumbers property.
     *
     * @param value another value
     */
    public void setShoppingCentersNumbers(final int value) {
        this.shoppingCentersNumbers = value;
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
        if (!super.equals(o)) {
            return false;
        }
        CityBreak cityBreak = (CityBreak) o;
        return getShoppingCentersNumbers()
                == cityBreak.getShoppingCentersNumbers();
    }

    /**
     * Overriding method hashCode for determining hashcode.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = PRIME * result + getShoppingCentersNumbers();
        return result;
    }

    /**
     * Method to represent class as a string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "\nCityBreak " + super.toString() + shoppingCentersNumbers
                + "|\t";
    }
}


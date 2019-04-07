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
     * Method to represent class as a string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "\nCityBreak { numbers of shopping centers: "
                + shoppingCentersNumbers + super.toString() + '}';
    }
}


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

    @XmlElement(name = "shopping-centers-numbers")
    protected int shoppingCentersNumbers;

    /**
     * Gets the value of the shoppingCentersNumbers property.
     */
    public int getShoppingCentersNumbers() {
        return shoppingCentersNumbers;
    }

    /**
     * Sets the value of the shoppingCentersNumbers property.
     */
    public void setShoppingCentersNumbers(int value) {
        this.shoppingCentersNumbers = value;
    }

    @Override
    public String toString() {
        return "CityBreak{" +
                "shoppingCentersNumbers=" + shoppingCentersNumbers +
                ", beginData=" + beginData +
                ", transport=" + transport +
                ", cost=" + cost +
                ", hotelCharacteristic=" + hotelCharacteristic +
                ", id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", numberNights=" + numberNights +
                '}';
    }
}

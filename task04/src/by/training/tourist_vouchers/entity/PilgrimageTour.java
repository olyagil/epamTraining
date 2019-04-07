package by.training.tourist_vouchers.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PilgrimageTour complex type.
 * &lt;element name="bethel-number"&gt;
 * &lt;maxInclusive value="15"/&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PilgrimageTour", propOrder = {
        "bethelNumber"
})
public class PilgrimageTour extends Voucher {
    /**
     * The variable for number of bethels.
     */
    @XmlElement(name = "bethel-number")
    private int bethelNumber;

    /**
     * Gets the value of the bethelNumber property.
     *
     * @return number of bethel
     */
    public int getBethelNumber() {
        return bethelNumber;
    }

    /**
     * Sets the value of the bethelNumber property.
     *
     * @param value specific value
     */
    public void setBethelNumber(final int value) {
        this.bethelNumber = value;
    }

    /**
     * Method to represent class as a string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "\nPilgrimageTour { number of bethel: " + bethelNumber
                + super.toString() + '}';
    }
}

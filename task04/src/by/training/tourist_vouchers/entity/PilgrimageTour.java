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
     * The constant for the hashCode.
     */
    private static final int PRIME = 31;
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
        PilgrimageTour that = (PilgrimageTour) o;
        return getBethelNumber() == that.getBethelNumber();
    }

    /**
     * Overriding method hashCode for determining hashcode.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = PRIME * result + getBethelNumber();
        return result;
    }

    /**
     * Method to represent class as a string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "\nPilgrimageTour " + super.toString() + "|\t" + bethelNumber
                + "|\t";
    }
}

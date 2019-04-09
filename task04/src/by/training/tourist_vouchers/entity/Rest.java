package by.training.tourist_vouchers.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Rest complex type.
 * &lt;complexType name="Rest"&gt;
 * &lt;element name="resting" type="boolean"/&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rest", propOrder = {
        "resting"
})
public class Rest extends Voucher {
    /**
     * The constant for the hashCode.
     */
    private static final int PRIME = 31;
    /**
     * The variable of the resting.
     */
    private boolean resting;

    /**
     * Gets the value of the resting property.
     *
     * @return true if it is resting.
     */
    public boolean isResting() {
        return resting;
    }

    /**
     * Sets the value of the resting property.
     *
     * @param value specific value
     */
    public void setResting(final boolean value) {
        this.resting = value;
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
        Rest rest = (Rest) o;
        return isResting() == rest.isResting();
    }

    /**
     * Overriding method hashCode for determining hashcode.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        if (isResting()) {
            result = PRIME * result + 1;
        } else {
            result = PRIME * result;
        }
        return result;
    }

    /**
     * Method to represent class as a string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "\nRest " + super.toString() + "|\t" + resting + "|\t";
    }
}

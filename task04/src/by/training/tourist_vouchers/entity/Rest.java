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
     * Method to represent class as a string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "\nRest { resting: " + resting + super.toString() + "} ";
    }
}

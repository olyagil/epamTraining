package by.training.tourist_vouchers.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Rest complex type.
 * &lt;complexType name="Rest"&gt;
 * &lt;element name="resting" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rest", propOrder = {
        "resting"
})
public class Rest
        extends Voucher {

    protected boolean resting;

    /**
     * Gets the value of the resting property.
     */
    public boolean isResting() {
        return resting;
    }

    /**
     * Sets the value of the resting property.
     */
    public void setResting(boolean value) {
        this.resting = value;
    }

    @Override
    public String toString() {
        return "\nRest { resting: " + resting + super.toString() + "} ";
    }
}

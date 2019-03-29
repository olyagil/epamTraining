package by.training.tourist_vouchers.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PilgrimageTour complex type.
 *         &lt;element name="bethel-number"&gt;
 *               &lt;maxInclusive value="15"/&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PilgrimageTour", propOrder = {
    "bethelNumber"
})
public class PilgrimageTour
    extends Voucher
{

    @XmlElement(name = "bethel-number")
    protected int bethelNumber;

    /**
     * Gets the value of the bethelNumber property.
     * 
     */
    public int getBethelNumber() {
        return bethelNumber;
    }

    /**
     * Sets the value of the bethelNumber property.
     * 
     */
    public void setBethelNumber(int value) {
        this.bethelNumber = value;
    }

    @Override
    public String toString() {
        return "PilgrimageTour{" +
                "bethelNumber=" + bethelNumber +
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

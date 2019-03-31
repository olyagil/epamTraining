package by.training.tourist_vouchers.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuidedTour complex type.
 * <p>
 * &lt;complexType name="GuidedTour"&gt;
 * &lt;extension base="{http://www.training.by/tourist-vouchers}Voucher"&gt;
 * &lt;element name="tour-guide" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 * &lt;element name="excursions-number"&gt;
 * &lt;maxExclusive value="20"/&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuidedTour", propOrder = {
        "tourGuide",
        "excursionsNumber"
})
public class GuidedTour
        extends Voucher {

    @XmlElement(name = "tour-guide")
    protected boolean tourGuide;
    @XmlElement(name = "excursions-number")
    protected int excursionsNumber;

    /**
     * Gets the value of the tourGuide property.
     */
    public boolean isTourGuide() {
        return tourGuide;
    }

    /**
     * Sets the value of the tourGuide property.
     */
    public void setTourGuide(boolean value) {
        this.tourGuide = value;
    }

    /**
     * Gets the value of the excursionsNumber property.
     */
    public int getExcursionsNumber() {
        return excursionsNumber;
    }

    /**
     * Sets the value of the excursionsNumber property.
     */
    public void setExcursionsNumber(int value) {
        this.excursionsNumber = value;
    }

    @Override
    public String toString() {
        return "\nGuidedTour { tour guide: " + tourGuide
                + ", number of excursions: " + excursionsNumber
                + super.toString() + '}';
    }
}

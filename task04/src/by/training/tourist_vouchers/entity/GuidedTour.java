package by.training.tourist_vouchers.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuidedTour complex type.
 * <p>
 * &lt;complexType name="GuidedTour"&gt;
 * &lt;extension base="Voucher"&gt;
 * &lt;element name="tour-guide" type="boolean"/&gt;
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
    /**
     * The variable for determining if it is a guided tour.
     */
    @XmlElement(name = "tour-guide")
    private boolean tourGuide;
    /**
     * The variable for number of excursions.
     */
    @XmlElement(name = "excursions-number")
    private int excursionsNumber;

    /**
     * Gets the value of the tourGuide property.
     *
     * @return true if it is a tour guide.
     */
    public boolean isTourGuide() {
        return tourGuide;
    }

    /**
     * Sets the value of the tourGuide property.
     *
     * @param value specific value
     */
    public void setTourGuide(final boolean value) {
        this.tourGuide = value;
    }

    /**
     * Gets the value of the excursionsNumber property.
     *
     * @return number of excursions
     */
    public int getExcursionsNumber() {
        return excursionsNumber;
    }

    /**
     * Sets the value of the excursionsNumber property.
     *
     * @param value specific value
     */
    public void setExcursionsNumber(final int value) {
        this.excursionsNumber = value;
    }

    /**
     * Method to represent class as a string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "\nGuidedTour { tour guide: " + tourGuide
                + ", number of excursions: " + excursionsNumber
                + super.toString() + '}';
    }
}

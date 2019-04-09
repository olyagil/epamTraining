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
public class GuidedTour extends Voucher {
    /**
     * The constant for the hashCode.
     */
    private static final int PRIME = 31;
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
        GuidedTour that = (GuidedTour) o;
        if (isTourGuide() != that.isTourGuide()) {
            return false;
        }
        return getExcursionsNumber() == that.getExcursionsNumber();
    }

    /**
     * Overriding method hashCode for determining hashcode.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        if (isTourGuide()) {
            result = PRIME * result + 1;
        } else {
            result = PRIME * result;
        }
        result = PRIME * result + getExcursionsNumber();
        return result;
    }

    /**
     * Method to represent class as a string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "\nGuidedTour " + super.toString() + "|\t" + tourGuide
                + "|\t" + excursionsNumber + "|\t";
    }
}

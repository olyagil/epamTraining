package by.training.tourist_vouchers.entity;

import by.training.tourist_vouchers.entity.enumeration.Meal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * <p>Java class for HotelCharacteristic complex type.
 * &lt;complexType name="HotelCharacteristic"&gt;
 * &lt;element name="tv" type="boolean"/&gt;
 * &lt;element name="fan" type="boolean"/&gt;
 * &lt;element name="safe" type="boolean"/&gt;
 * &lt;element name="wi-fi" type="boolean"/&gt;
 * &lt;attribute name="number-stars" use="required" type="positiveInteger" /&gt;
 * &lt;attribute name="room-type" use="required"&gt;
 * &lt;maxInclusive value="5"/&gt;
 * &lt;attribute name="meal-type" use="required" type="Meal" /&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelCharacteristic", propOrder = {
        "tv",
        "fan",
        "safe",
        "wiFi"
})
public class HotelCharacteristic {
    /**
     * The variable for hashcode.
     */
    private static final int PRIME = 31;
    /**
     * The variable for tv.
     */
    private boolean tv;
    /**
     * The variable for fan.
     */
    private boolean fan;
    /**
     * The variable for safe.
     */
    private boolean safe;
    /**
     * The variable for wi-fi.
     */
    @XmlElement(name = "wi-fi")
    private boolean wiFi;
    /**
     * The variable for number of stars.
     */
    @XmlAttribute(name = "number-stars", required = true)
    @XmlSchemaType(name = "positiveInteger")
    private BigInteger numberStars;
    /**
     * The variable for room type.
     */
    @XmlAttribute(name = "room-type", required = true)
    private int roomType;
    /**
     * The variable for meal type.
     */
    @XmlAttribute(name = "meal-type", required = true)
    private Meal mealType;

    /**
     * Gets the value of the tv property.
     *
     * @return true if tv is included
     */
    public boolean isTv() {
        return tv;
    }

    /**
     * Sets the value of the tv property.
     *
     * @param value which is needed to be set
     */
    public void setTv(final boolean value) {
        this.tv = value;
    }

    /**
     * Gets the value of the fan property.
     *
     * @return true if fan is included
     */
    public boolean isFan() {
        return fan;
    }

    /**
     * Sets the value of the fan property.
     *
     * @param value which is needed to be set
     */
    public void setFan(final boolean value) {
        this.fan = value;
    }

    /**
     * Gets the value of the safe property.
     *
     * @return true if safe is included
     */
    public boolean isSafe() {
        return safe;
    }

    /**
     * Sets the value of the safe property.
     *
     * @param value which is needed to be set
     */
    public void setSafe(final boolean value) {
        this.safe = value;
    }

    /**
     * Gets the value of the wiFi property.
     *
     * @return true if wi-fi is included
     */
    public boolean isWiFi() {
        return wiFi;
    }

    /**
     * Sets the value of the wiFi property.
     *
     * @param value which is needed to be set
     */
    public void setWiFi(final boolean value) {
        this.wiFi = value;
    }

    /**
     * Gets the value of the numberStars property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getNumberStars() {
        return numberStars;
    }

    /**
     * Sets the value of the numberStars property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setNumberStars(final BigInteger value) {
        this.numberStars = value;
    }

    /**
     * Gets the value of the roomType property.
     *
     * @return the type of the room
     */
    public int getRoomType() {
        return roomType;
    }

    /**
     * Sets the value of the roomType property.
     *
     * @param value which is needed to be set
     */
    public void setRoomType(final int value) {
        this.roomType = value;
    }

    /**
     * Gets the value of the mealType property.
     *
     * @return possible object is
     * {@link Meal }
     */
    public Meal getMealType() {
        return mealType;
    }

    /**
     * Sets the value of the mealType property.
     *
     * @param value allowed object is
     *              {@link Meal }
     */
    public void setMealType(final Meal value) {
        this.mealType = value;
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

        HotelCharacteristic other = (HotelCharacteristic) o;

        if (isTv() != other.isTv()) {
            return false;
        }
        if (isFan() != other.isFan()) {
            return false;
        }
        if (isSafe() != other.isSafe()) {
            return false;
        }
        if (isWiFi() != other.isWiFi()) {
            return false;
        }
        if (getRoomType() != other.getRoomType()) {
            return false;
        }
        if (getNumberStars() == null) {
            if (other.numberStars != null) {
                return false;
            }
        } else if (!getNumberStars().equals(other.numberStars)) {
            return false;
        }
        return getMealType() == other.getMealType();
    }

    /**
     * Overriding method hashCode for determining hashcode.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int result;
        if (isTv()) {
            result = 1;
        } else {
            result = 0;
        }
        if (isFan()) {
            result = PRIME * result + 1;
        } else {
            result = PRIME * result;
        }
        if (isSafe()) {
            result = PRIME * result + 1;
        } else {
            result = PRIME * result;
        }
        if (isWiFi()) {
            result = PRIME * result + 1;
        } else {
            result = PRIME * result;
        }
        if (getNumberStars() != null) {
            result = PRIME * result + getNumberStars().hashCode();
        } else {
            result = PRIME * result;
        }
        if (getMealType() != null) {
            result = PRIME * result + getMealType().hashCode();
        } else {
            result = PRIME * result;
        }
        result = PRIME * result + getRoomType();
        return result;
    }

    /**
     * Method to represent class as a string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "|\t" + tv + "|\t" + fan + "|\t" + safe + "|\t"
                + wiFi + "|\t" + numberStars + "|\t"
                + roomType + "|\t" + mealType;
    }
}

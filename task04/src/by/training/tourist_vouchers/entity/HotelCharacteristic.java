package by.training.tourist_vouchers.entity;

import by.training.tourist_vouchers.entity.enumeration.Meal;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelCharacteristic complex type.
 * &lt;complexType name="HotelCharacteristic"&gt;
 * &lt;element name="tv" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 * &lt;element name="fan" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 * &lt;element name="safe" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 * &lt;element name="wi-fi" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 * &lt;attribute name="number-stars" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" /&gt;
 * &lt;attribute name="room-type" use="required"&gt;
 * &lt;maxInclusive value="5"/&gt;
 * &lt;attribute name="meal-type" use="required" type="{http://www.training.by/tourist-vouchers}Meal" /&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelCharacteristic", propOrder = {
        "tv",
        "fan",
        "safe",
        "wiFi"
})
public class HotelCharacteristic {

    private boolean tv;
    protected boolean fan;
    protected boolean safe;
    @XmlElement(name = "wi-fi")
    protected boolean wiFi;
    @XmlAttribute(name = "number-stars", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger numberStars;
    @XmlAttribute(name = "room-type", required = true)
    protected int roomType;
    @XmlAttribute(name = "meal-type", required = true)
    protected Meal mealType;

    /**
     * Gets the value of the tv property.
     */
    public boolean isTv() {
        return tv;
    }

    /**
     * Sets the value of the tv property.
     */
    public void setTv(boolean value) {
        this.tv = value;
    }

    /**
     * Gets the value of the fan property.
     */
    public boolean isFan() {
        return fan;
    }

    /**
     * Sets the value of the fan property.
     */
    public void setFan(boolean value) {
        this.fan = value;
    }

    /**
     * Gets the value of the safe property.
     */
    public boolean isSafe() {
        return safe;
    }

    /**
     * Sets the value of the safe property.
     */
    public void setSafe(boolean value) {
        this.safe = value;
    }

    /**
     * Gets the value of the wiFi property.
     */
    public boolean isWiFi() {
        return wiFi;
    }

    /**
     * Sets the value of the wiFi property.
     */
    public void setWiFi(boolean value) {
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
    public void setNumberStars(BigInteger value) {
        this.numberStars = value;
    }

    /**
     * Gets the value of the roomType property.
     */
    public int getRoomType() {
        return roomType;
    }

    /**
     * Sets the value of the roomType property.
     */
    public void setRoomType(int value) {
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
    public void setMealType(Meal value) {
        this.mealType = value;
    }

    @Override
    public String toString() {
        return " tv=" + tv + ", fan=" + fan + ", safe=" + safe + ", wiFi="
                + wiFi + ", numberStars=" + numberStars + ", roomType="
                + roomType + ", mealType=" + mealType;
    }
}

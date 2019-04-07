package by.training.tourist_vouchers.entity.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Meal.
 * &lt;enumeration value="HB"/&gt;
 * &lt;enumeration value="BB"/&gt;
 * &lt;enumeration value="AL"/&gt;
 */
@XmlType(name = "Meal")
@XmlEnum
public enum Meal {
    /**
     * The constant for HB type of meal.
     */
    HB,
    /**
     * The constant for BB type of meal.
     */
    BB,
    /**
     * The constant for AL type of meal.
     */
    AL;

}

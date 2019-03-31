package by.training.tourist_vouchers.entity.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Meal.
 *     &lt;enumeration value="HB"/&gt;
 *     &lt;enumeration value="BB"/&gt;
 *     &lt;enumeration value="AL"/&gt;
 *
 */
@XmlType(name = "Meal")
@XmlEnum
public enum Meal {

    HB,
    BB,
    AL;

    public String value() {
        return name();
    }

    public static Meal fromValue(String v) {
        return valueOf(v);
    }

}

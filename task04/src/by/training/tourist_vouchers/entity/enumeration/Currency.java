package by.training.tourist_vouchers.entity.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for Currency.
 */
@XmlType(name = "Currency")
@XmlEnum
public enum Currency {

    USD,
    BYN,
    EUR;

    public String value() {
        return name();
    }

    public static Currency fromValue(String v) {
        return valueOf(v);
    }

}

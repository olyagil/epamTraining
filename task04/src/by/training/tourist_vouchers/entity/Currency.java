package by.training.tourist_vouchers.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for Currency.
 * 
 * &lt;simpleType name="Currency"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="USD"/&gt;
 *     &lt;enumeration value="BYN"/&gt;
 *     &lt;enumeration value="EUR"/&gt;
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

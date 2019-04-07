package by.training.tourist_vouchers.entity.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for Currency.
 */
@XmlType(name = "Currency")
@XmlEnum
public enum Currency {
    /**
     * The constant for USD currency.
     */
    USD,
    /**
     * The constant for BYN currency.
     */
    BYN,
    /**
     * The constant for EUR currency.
     */
    EUR;


    public String value() {
        return name();
    }

}

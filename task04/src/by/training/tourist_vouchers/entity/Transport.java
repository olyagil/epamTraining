package by.training.tourist_vouchers.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Transport.
 * <p>
 * &lt;simpleType name="Transport"&gt;
 * &lt;enumeration value="�������"/&gt;
 * &lt;enumeration value="����"/&gt;
 * &lt;enumeration value="����"/&gt;
 * &lt;enumeration value="�/�"/&gt;
 * &lt;enumeration value="������"/&gt;
 */
@XmlType(name = "Transport")
@XmlEnum
public enum Transport {

    @XmlEnumValue("\u0410\u0432\u0442\u043e\u0431\u0443\u0441")
    BUS("\u0410\u0432\u0442\u043e\u0431\u0443\u0441"),
    @XmlEnumValue("\u0410\u0432\u0438\u0430")
    АIR("Air"),
    @XmlEnumValue("\u0410\u0432\u0442\u043e")
    CAR("\u0410\u0432\u0442\u043e"),
    @XmlEnumValue("\u0436/\u0434")
    RAILWAY("Railway"),
    @XmlEnumValue("\u041b\u0430\u0439\u043d\u0435\u0440")
    LINER("\u041b\u0430\u0439\u043d\u0435\u0440");
    private final String value;

    Transport(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Transport fromValue(String v) {
        for (Transport c : Transport.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

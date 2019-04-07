package by.training.tourist_vouchers.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * <p>
 * &lt;restriction base="anyType"&gt;
 * &lt;element ref="voucher" maxOccurs="unbounded" minOccurs="0"/&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "voucher"
})
@XmlRootElement(name = "tourist-vouchers")
public class TouristVouchers {
    /**
     * List.
     */
    @XmlElementRef(name = "voucher",
            namespace = "http://www.training.by/tourist-vouchers",
            type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends Voucher>> voucher;

    /**
     * Gets the value of the voucher property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the
     * voucher property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVoucher().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link PilgrimageTour }{@code >}
     * {@link JAXBElement }{@code <}{@link GuidedTour }{@code >}
     * {@link JAXBElement }{@code <}{@link CityBreak }{@code >}
     * {@link JAXBElement }{@code <}{@link Rest }{@code >}
     * {@link JAXBElement }{@code <}{@link Voucher }{@code >}
     *
     * @return list
     */
    public List<JAXBElement<? extends Voucher>> getVoucher() {
        if (voucher == null) {
            voucher = new ArrayList<>();
        }
        return this.voucher;
    }

}

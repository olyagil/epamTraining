package by.training.tourist_vouchers.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;element ref="{http://www.training.by/tourist-vouchers}voucher" maxOccurs="unbounded" minOccurs="0"/&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "voucher"
})
@XmlRootElement(name = "tourist-vouchers")
public class TouristVouchers {

    @XmlElementRef(name = "voucher", namespace = "http://www.training.by/tourist-vouchers", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends Voucher>> voucher;

    /**
     * Gets the value of the voucher property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the voucher property.
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
     * 
     */
    public List<JAXBElement<? extends Voucher>> getVoucher() {
        if (voucher == null) {
            voucher = new ArrayList<>();
        }
        return this.voucher;
    }

}

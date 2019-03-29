package by.training.tourist_vouchers.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the by.training.tourist_vouchers package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _Voucher_QNAME = new QName("http://www" +
            ".training.by/tourist-vouchers", "voucher");
    private static final QName _CityBreak_QNAME = new QName("http://www" +
            ".training.by/tourist-vouchers", "city-break");
    private static final QName _Rest_QNAME = new QName("http://www.training" +
            ".by/tourist-vouchers", "rest");
    private static final QName _GuidedTour_QNAME = new QName("http://www" +
            ".training.by/tourist-vouchers", "guided-tour");
    private static final QName _PilgrimageTour_QNAME = new QName("http://www" +
            ".training.by/tourist-vouchers", "pilgrimage-tour");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.training.tourist_vouchers
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TouristVouchers }
     */
    public TouristVouchers createTouristVouchers() {
        return new TouristVouchers();
    }

    /**
     * Create an instance of {@link Voucher }
     */
    public Voucher createVoucher() {
        return new Voucher();
    }

    /**
     * Create an instance of {@link CityBreak }
     */
    public CityBreak createCityBreak() {
        return new CityBreak();
    }

    /**
     * Create an instance of {@link Rest }
     */
    public Rest createRest() {
        return new Rest();
    }

    /**
     * Create an instance of {@link GuidedTour }
     */
    public GuidedTour createGuidedTour() {
        return new GuidedTour();
    }

    /**
     * Create an instance of {@link PilgrimageTour }
     */
    public PilgrimageTour createPilgrimageTour() {
        return new PilgrimageTour();
    }

    /**
     * Create an instance of {@link Cost }
     */
    public Cost createCost() {
        return new Cost();
    }

    /**
     * Create an instance of {@link HotelCharacteristic }
     */
    public HotelCharacteristic createHotelCharacteristic() {
        return new HotelCharacteristic();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Voucher }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link Voucher }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.training.by/tourist-vouchers", name = "voucher")
    public JAXBElement<Voucher> createVoucher(Voucher value) {
        return new JAXBElement<Voucher>(_Voucher_QNAME, Voucher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CityBreak }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link CityBreak }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.training.by/tourist-vouchers", name = "city-break", substitutionHeadNamespace = "http://www.training.by/tourist-vouchers", substitutionHeadName = "voucher")
    public JAXBElement<CityBreak> createCityBreak(CityBreak value) {
        return new JAXBElement<CityBreak>(_CityBreak_QNAME, CityBreak.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rest }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link Rest }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.training.by/tourist-vouchers", name = "rest", substitutionHeadNamespace = "http://www.training.by/tourist-vouchers", substitutionHeadName = "voucher")
    public JAXBElement<Rest> createRest(Rest value) {
        return new JAXBElement<Rest>(_Rest_QNAME, Rest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuidedTour }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link GuidedTour }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.training.by/tourist-vouchers", name = "guided-tour", substitutionHeadNamespace = "http://www.training.by/tourist-vouchers", substitutionHeadName = "voucher")
    public JAXBElement<GuidedTour> createGuidedTour(GuidedTour value) {
        return new JAXBElement<GuidedTour>(_GuidedTour_QNAME, GuidedTour.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PilgrimageTour }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link PilgrimageTour }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.training.by/tourist-vouchers", name = "pilgrimage-tour", substitutionHeadNamespace = "http://www.training.by/tourist-vouchers", substitutionHeadName = "voucher")
    public JAXBElement<PilgrimageTour> createPilgrimageTour(PilgrimageTour value) {
        return new JAXBElement<PilgrimageTour>(_PilgrimageTour_QNAME, PilgrimageTour.class, null, value);
    }

}

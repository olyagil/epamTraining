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
    /**
     * The constant of the voucher qName.
     */
    private static final QName VOUCHER_QNAME
            = new QName("http://www.training.by/tourist-vouchers", "voucher");
    /**
     * The constant of the city break qName.
     */
    private static final QName CITY_BREAK_QNAME
            = new QName("http://www.training.by / tourist - vouchers",
            "city -break");
    /**
     * The constant of the rest qName.
     */
    private static final QName REST_QNAME
            = new QName("http://www.training.by/tourist-vouchers", "rest");
    /**
     * The constant of the guided tour qName.
     */
    private static final QName GUIDED_TOUR_QNAME
            = new QName("http://www.training.by/tourist-vouchers",
            "guided-tour");
    /**
     * The constant of the pilgrimage tour qName.
     */
    private static final QName PILGRIMAGE_TOUR_QNAME
            = new QName("http://www.training.by/tourist-vouchers",
            "pilgrimage-tour");

    /**
     * Create a new ObjectFactory that can be used to create new instances
     * of schema derived classes for package: by.training.tourist_vouchers.
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TouristVouchers }.
     *
     * @return TouristVouchers
     */
    public TouristVouchers createTouristVouchers() {
        return new TouristVouchers();
    }

    /**
     * Create an instance of {@link Voucher }.
     *
     * @return Voucher
     */
    public Voucher createVoucher() {
        return new Voucher();
    }

    /**
     * Create an instance of {@link CityBreak }.
     *
     * @return City Break
     */
    public CityBreak createCityBreak() {
        return new CityBreak();
    }

    /**
     * Create an instance of {@link Rest }.
     *
     * @return Rest tour.
     */
    public Rest createRest() {
        return new Rest();
    }

    /**
     * Create an instance of {@link GuidedTour }.
     *
     * @return Guided tour
     */
    public GuidedTour createGuidedTour() {
        return new GuidedTour();
    }

    /**
     * Create an instance of {@link PilgrimageTour }.
     *
     * @return Pilgrimage Tour
     */
    public PilgrimageTour createPilgrimageTour() {
        return new PilgrimageTour();
    }

    /**
     * Create an instance of {@link Cost }.
     *
     * @return Cost
     */
    public Cost createCost() {
        return new Cost();
    }

    /**
     * Create an instance of {@link HotelCharacteristic }.
     *
     * @return hotel characteristic
     */
    public HotelCharacteristic createHotelCharacteristic() {
        return new HotelCharacteristic();
    }

    /**
     * Create an instance of {@link JAXBElement }{@link Voucher }.
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@link Voucher }
     */
    @XmlElementDecl(namespace = "http://www.training.by/tourist-vouchers",
            name = "voucher")
    public JAXBElement<Voucher> createVoucher(final Voucher value) {
        return new JAXBElement<Voucher>(VOUCHER_QNAME, Voucher.class,
                null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@link CityBreak }.
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@link CityBreak }
     */
    @XmlElementDecl(namespace = "http://www.training.by/tourist-vouchers",
            name = "city-break", substitutionHeadNamespace = "http://www"
            + ".training.by/tourist-vouchers", substitutionHeadName = "voucher")
    public JAXBElement<CityBreak> createCityBreak(final CityBreak value) {
        return new JAXBElement<CityBreak>(CITY_BREAK_QNAME, CityBreak.class,
                null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@link Rest }.
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@link Rest }
     */
    @XmlElementDecl(namespace = "http://www.training.by/tourist-vouchers",
            name = "rest", substitutionHeadNamespace = "http://www."
            + "training.by/tourist-vouchers", substitutionHeadName = "voucher")
    public JAXBElement<Rest> createRest(final Rest value) {
        return new JAXBElement<Rest>(REST_QNAME, Rest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuidedTour }.
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@link GuidedTour }
     */
    @XmlElementDecl(namespace = "http://www.training.by/tourist-vouchers",
            name = "guided-tour", substitutionHeadNamespace =
            "http://www.training.by/tourist-vouchers",
            substitutionHeadName = "voucher")
    public JAXBElement<GuidedTour> createGuidedTour(final GuidedTour value) {
        return new JAXBElement<GuidedTour>(GUIDED_TOUR_QNAME, GuidedTour.class,
                null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@link PilgrimageTour }.
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@link PilgrimageTour }
     */
    @XmlElementDecl(namespace = "http://www.training.by/tourist-vouchers",
            name = "pilgrimage-tour", substitutionHeadNamespace
            = "http://www.training.by/tourist-vouchers",
            substitutionHeadName = "voucher")
    public JAXBElement<PilgrimageTour> createPilgrimageTour(final PilgrimageTour
                                                                        value) {
        return new JAXBElement<PilgrimageTour>(PILGRIMAGE_TOUR_QNAME,
                PilgrimageTour.class, null, value);
    }

}

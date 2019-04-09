package by.training.tourist_vouchers.entity.enumeration;

/**
 * The {@code VoucherType} is used for storing vouchers.
 */
public enum VoucherType {
    /**
     * The constant for the city-break voucher.
     */
    CITY_BREAK("city-break"),
    /**
     * The constant for the rest voucher.
     */
    REST("rest"),
    /**
     * The constant for the guided-tour voucher.
     */
    GUIDED_TOUR("guided-tour"),
    /**
     * The constant for the pilgrimage-tour voucher.
     */
    PILGRIMAGE_TOUR("pilgrimage-tour");
    /**
     * The type of the voucher.
     */
    private String type;

    /**
     * The constructor with one parameter.
     *
     * @param value value
     */
    VoucherType(final String value) {
        this.type = value;
    }

    /**
     * Method to get value.
     *
     * @return value
     */
    public String getValue() {
        return type;
    }
}







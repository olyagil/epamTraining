package by.training.tourist_vouchers.entity.enumeration;

public enum VoucherType {

    CITY_BREAK("city-break"),
    REST("rest"),
    GUIDED_TOUR("guided-tour"),
    PILGRIMAGE_TOUR("pilgrimage-tour");

    private String type;

    VoucherType(String value) {
        this.type = value;
    }

    public String getValue() {
        return type;
    }
}

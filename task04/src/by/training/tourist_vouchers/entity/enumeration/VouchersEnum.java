package by.training.tourist_vouchers.entity.enumeration;

public enum VouchersEnum {
    TOURIST_VOUCHERS("tourist-vouchers"),
    VOUCHER("voucher"),
    CITY_BREAK("city-break"),
    REST("rest"),
    GUIDED_TOUR("guided-tour"),
    PILGRIMAGE_TOUR("pilgrimage-tour"),

    ID("id"),
    COUNTRY("country"),
    NUMBER_NIGHTS("number-nights"),

    CURRENCY("currency"),
    COST("cost"),
    NUMBER_STARS("number-stars"),
    MEAL_TYPE("meal-type"),
    ROOM_TYPE("room-type"),
    HOTEL_CHARACTERISTIC("hotel-characteristic"),


    BEGIN_DATA("begin-data"),
    TRANSPORT("transport"),
    TV("tv"),
    FAN("fan"),
    SAFE("safe"),
    WI_FI("wi-fi"),

    PRICE("price"),
    FLIGHT_INCLUDE("flight-include"),
    HOTEL_INCLUDE("hotel-include"),

    SHOPPING_CENTERS_NUMBERS("shopping-centers-numbers"),
    TOUR_GUIDE("tour-guide"),
    EXCURSIONS_NUMBER("excursions-number"),
    RESTING("resting"),
    BETHEL_NUMBER("bethel-number");

    private String value;

    VouchersEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


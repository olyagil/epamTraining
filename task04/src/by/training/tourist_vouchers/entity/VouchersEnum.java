package by.training.tourist_vouchers.entity;

public enum VouchersEnum {
    TOURIST_VOUCHERS("tourist-vouchers"),
    VOUCHER("voucher"),
    CITY_BREAK("city-break"),
    REST("rest"),
    GUIDED_TOUR("guided-tour"),
    PILGRIMAGE_TOUR("pilgrimage-tour"),

    BEGIN_DATA("begin-data"),
    TRANSPORT("transport"),

    CURRENCY("currency"),
    PRICE("price"),
    FLIGHT_INCLUDE("flight-include"),
    HOTEL_INCLUDE("hotel-include"),
    COST("cost"),

    NUMBER_STARS("number-stars"),
    MEAL_TYPE("meal-type"),
    ROOM_TYPE("room-type"),
    TV("tv"),
    FAN("fan"),
    SAFE("safe"),
    WI_FI("wi-fi"),
    HOTEL_CHARACTERISTICS("hotel-characteristics"),

    ID("id"),
    COUNTRY("country"),
    NUMBER_NIGHTS("number-nights"),
    SHOPPING_CENTERS_NUMBERS("shopping-centers-numbers"),
    TOUR_GUIDE("tour-guide"),
    EXCURSIONS_NUMBER("excursions-numbers"),
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


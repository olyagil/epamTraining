package by.training.tourist_vouchers.entity.enumeration;

public enum VouchersEnum {
    /**
     * The constant for root tag
     */
    TOURIST_VOUCHERS("tourist-vouchers"),

    /**
     * The constant for the city-break tag
     */
    CITY_BREAK("city-break"),
    /**
     * The constant for rest tag
     */
    REST("rest"),
    /**
     * The constant for guided-tour tag
     */
    GUIDED_TOUR("guided-tour"),
    /**
     * The constant for pilgrimage-tour tag
     */
    PILGRIMAGE_TOUR("pilgrimage-tour"),
    /**
     * The constant for id tag
     */
    ID("id"),
    /**
     * The constant for country tag
     */
    COUNTRY("country"),
    /**
     * The constant for number-nights tag
     */
    NUMBER_NIGHTS("number-nights"),

    /**
     * The constant for currency tag
     */
    CURRENCY("currency"),
    /**
     * The constant for cost tag
     */
    COST("cost"),
    /**
     * The constant for number-stars tag
     */
    NUMBER_STARS("number-stars"),
    /**
     * The constant for meal-type tag
     */
    MEAL_TYPE("meal-type"),
    /**
     * The constant for room-type tag
     */
    ROOM_TYPE("room-type"),
    /**
     * The constant for hotel-characteristics tag
     */
    HOTEL_CHARACTERISTIC("hotel-characteristic"),

    /**
     * The constant for begin-data tag
     */
    BEGIN_DATA("begin-data"),
    /**
     * The constant for transport tag
     */
    TRANSPORT("transport"),
    /**
     * The constant for tv tag
     */
    TV("tv"),
    /**
     * The constant for fan tag
     */
    FAN("fan"),
    /**
     * The constant for safe tag
     */
    SAFE("safe"),
    /**
     * The constant for wi-fi tag
     */
    WI_FI("wi-fi"),
    /**
     * The constant for price tag
     */
    PRICE("price"),
    /**
     * The constant for flight-included tag
     */
    FLIGHT_INCLUDE("flight-include"),
    /**
     * The constant for hotel-included tag
     */
    HOTEL_INCLUDE("hotel-include"),
    /**
     * The constant for shopping-centers-numbers tag
     */
    SHOPPING_CENTERS_NUMBERS("shopping-centers-numbers"),
    /**
     * The constant for tour-guide tag
     */
    TOUR_GUIDE("tour-guide"),
    /**
     * The constant for excursions-number tag
     */
    EXCURSIONS_NUMBER("excursions-number"),
    /**
     * The constant for resting tag
     */
    RESTING("resting"),
    /**
     * The constant for bethel-number tag
     */
    BETHEL_NUMBER("bethel-number");
    /**
     * The variable for tag.
     */
    private String value;

    /**
     * The constructor of the enum
     *
     * @param tag tag
     */
    VouchersEnum(final String tag) {
        this.value = tag;
    }

    /**
     * The method for getting the tag
     */
    public String getValue() {
        return value;
    }
}


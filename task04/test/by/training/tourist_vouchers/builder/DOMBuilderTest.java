package by.training.tourist_vouchers.builder;

import by.training.tourist_vouchers.entity.CityBreak;
import by.training.tourist_vouchers.entity.Cost;
import by.training.tourist_vouchers.entity.HotelCharacteristic;
import by.training.tourist_vouchers.entity.Voucher;
import by.training.tourist_vouchers.entity.enumeration.Currency;
import by.training.tourist_vouchers.entity.enumeration.Meal;
import by.training.tourist_vouchers.entity.enumeration.Transport;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class DOMBuilderTest {

    private static final String PATH = "testdata//tourist-vouchers.xml";
    private DOMBuilder domBuilder;
    private Set<Voucher> expected;
    private Voucher voucher;
    private Cost cost;
    private HotelCharacteristic hotelCharacteristic;

    @BeforeMethod
    public void setUp() {
        domBuilder = new DOMBuilder();
        voucher = new CityBreak();
        hotelCharacteristic = new HotelCharacteristic();
        cost = new Cost();
        voucher.setHotelCharacteristic(hotelCharacteristic);
        voucher.setCost(cost);
        expected = new HashSet<>();

        voucher.setNumberNights(1);
        voucher.setBeginData("2019-03-20T15:30:00");
        voucher.setTransport(Transport.RAILWAY);
        voucher.setId("qwerty2345678");
        voucher.setCountry("Russia");
        ((CityBreak) voucher).setShoppingCentersNumbers(10);

        hotelCharacteristic.setNumberStars(BigInteger.valueOf(3));
        hotelCharacteristic.setMealType(Meal.AL);
        hotelCharacteristic.setRoomType(3);
        hotelCharacteristic.setSafe(false);
        hotelCharacteristic.setTv(true);
        hotelCharacteristic.setWiFi(true);
        hotelCharacteristic.setFan(true);

        cost.setCurrency(Currency.USD);
        cost.setFlightInclude(true);
        cost.setHotelInclude(true);
        cost.setPrice(BigDecimal.valueOf(100.));
        expected.add(voucher);
    }

    @AfterMethod
    public void tearDown() {
        domBuilder = null;
    }

    @Test
    public void testBuildVouchers() {
        domBuilder.buildVouchers(PATH);
        Set<Voucher> actual = domBuilder.getVouchers();

        Assert.assertEquals(actual, expected);
    }


//    @DataProvider(name = "dataForDOMBuilder")
//    public static Object[][] dataForDOMBuilder() {
//        return new Object[][]{
//                {},
//        };
//    }
}
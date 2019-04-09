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
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SAXBuilderTest {

    private static final String PATH = "testdata//tourist-vouchers.xml";
    private SAXBuilder saxBuilder;
    private List<Voucher> expected;

    @BeforeMethod
    public void setUp() {
        saxBuilder = new SAXBuilder();
        CityBreak voucher = new CityBreak();
        HotelCharacteristic hotelCharacteristic = new HotelCharacteristic();
        Cost cost = new Cost();
        voucher.setHotelCharacteristic(hotelCharacteristic);
        voucher.setCost(cost);
        expected = new ArrayList<>();

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
        saxBuilder = null;
    }

    @Test
    public void testBuildVouchers() {
        saxBuilder.buildVouchers(PATH);
        List<Voucher> actual = new ArrayList<>();
        for (int i = 0; i < saxBuilder.getSize(); i++) {
            actual.add(saxBuilder.getVoucher(i));
        }
        Assert.assertEquals(actual, expected);
    }
}
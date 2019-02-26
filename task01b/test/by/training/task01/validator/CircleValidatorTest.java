package by.training.task01.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CircleValidatorTest {
    CircleValidator circleValidator = new CircleValidator();

    @DataProvider(name = "doubleData")
    public Object[][] doubleData() {
        return new Object[][]{
                {"1.0 5.0 6.0", true},
                {"15", false},
                {"2.d 9.0", false},
                {"fgf", false},
                {"3.0 6.0 0.0", false},
                {"6.0 4.0 5.0 6.0", false},
        };
    }

    @Test(description = "Scenario of the value validation",
            dataProvider = "doubleData")
    public void testCheckPoint(String point, boolean expected) {
        boolean actual = circleValidator.checkCircle(point);
        Assert.assertEquals(actual, expected);

    }
}
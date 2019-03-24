package by.training.task03.interpreter;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ClientTest {

    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][]{
                {"13 2 <<", 52},
                {"30 3 >>> ", 3},
                {"6 ~ 9 & 3 4 & | ", 9},
                {"5 1 2 & 3 4 25 5 ^ 6 47 & | & 3 | | 2 | & 1 | | ", 5},
                {"71 ~ 2 3 & 3 2 1 2 >> & 2 | 2 & | | 10 2 & | & 78 | ", 78},
                {"111 5 ^ 1 2 2 5 2 >> 71 & | << & | 1200 | ", 1274},
        };
    }

    @Test(dataProvider = "data")
    public void testCalculate(String expression, int expected) {
        Client interpreter = new Client(expression);
        int actual = interpreter.calculate();
        Assert.assertEquals(actual, expected);

    }
}
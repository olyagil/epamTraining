package by.training.task03.interpreter;

import org.testng.Assert;
import org.testng.annotations.*;


public class ReversePolishNotationTest {
    ReversePolishNotation rpn;

    @BeforeMethod
    public void setUp() {
        rpn = new ReversePolishNotation();
    }

    @AfterMethod
    public void tearDown() {
        rpn = null;
    }

    @DataProvider(name = "data for creating rpn")
    public Object[][] data() {
        return new Object[][]{
                {"13<<2", "13 2 << "},
                {"30>>>3", "30 3 >>> "},
                {"~6&9|(3&4)", "6 ~ 9 & 3 4 & | "},
                {"5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1)",
                        "5 1 2 & 3 4 25 5 ^ 6 47 & | & 3 | | 2 | & 1 | | "},
                {"(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78",
                        "71 ~ 2 3 & 3 2 1 2 >> & 2 | 2 & | | 10 2 & | & 78 | "},
                {"(111^5|1&2<<(2|5>>2&71))|1200",
                        "111 5 ^ 1 2 2 5 2 >> 71 & | << & | 1200 | "},
        };
    }

    @Test(dataProvider = "data for creating rpn")
    public void testCreate(String expression, String expected) {
        String actual = rpn.create(expression);
        Assert.assertEquals(actual, expected);
    }


}
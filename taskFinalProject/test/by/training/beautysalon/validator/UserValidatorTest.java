package by.training.beautysalon.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserValidatorTest {

    @DataProvider(name = "dataForLogin")
    public static Object[][] dataForLogin() {
        return new Object[][]{
                {"qwerty", true},
                {"123456", true},
                {"qwerty123", true},
                {"qwer-123", true},
                {"qwer_123", true},
                {"qw", false},
                {"0", false},
                {"-1", false},
                {"qwertyuiopasdfghj", false},
                {"!@#$%^&*()", false},
        };
    }

    @Test(dataProvider = "dataForLogin", description = "test for checking if " +
            "login is correct.")
    public void testCheckLogin(String login, Boolean expected) {
        Boolean actual = UserValidator.checkLogin(login);
        Assert.assertEquals(actual, expected);

    }

    @DataProvider(name = "dataForPassword")
    public static Object[][] dataForPassword() {
        return new Object[][]{
                {"qwerty", true},
                {"qwer123", true},
                {"123456", true},
                {"qwer-123", true},
                {"qwer_123", true},
                {"qwert", false},
                {"12345", false},
                {"qwertyuiopasdfghjklz", false},
                {"0", false},
                {"!@#$%^&*()", false},
        };
    }

    @Test(dataProvider = "dataForPassword", description = "test for checking if " +
            "password is correct.")
    public void testCheckPassword(String password, Boolean expected) {
        Boolean actual = UserValidator.checkPassword(password);
        Assert.assertEquals(actual, expected);

    }

}
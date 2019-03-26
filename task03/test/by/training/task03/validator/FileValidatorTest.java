package by.training.task03.validator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class FileValidatorTest {

    private FileValidator fileValidator;
    private static final String WRONG_PATH = "data//wrong_path.txt";
    private static final String PATH = "data//test.txt";
    private static final String EMPTY_FILE_PATH = "data//empty.txt";

    @BeforeMethod
    public void setUp() {
        fileValidator = new FileValidator();
    }

    @AfterMethod
    public void tearDown() {
        fileValidator = null;
    }

    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][]{
                {new File(WRONG_PATH), false},
                {new File(PATH), true},
                {null, false},
                {new File(EMPTY_FILE_PATH), false},
        };
    }

    @Test(dataProvider = "data")
    public void testCheckFile(File file, boolean expected) {
        boolean actual = fileValidator.checkFile(file);
        Assert.assertEquals(actual, expected);
    }
}
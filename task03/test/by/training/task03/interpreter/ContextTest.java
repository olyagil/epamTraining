//package by.training.task03.interpreter;
//
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import static org.testng.Assert.*;
//
//public class ContextTest {
//    Context context;
//
//    @BeforeMethod
//    public void setUp() {
//        context = new Context();
//        context.pushValue(5);
//        context.pushValue(6);
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        context = null;
//    }
//
//    @DataProvider(name = "data")
//    public Object[][] data() {
//        return new Object[][]{
//                {
//
//                }
//        };
//    }
//
//    @Test
//    public void testPopValue() {
//
//        Assert.assertEquals();
//    }
//
//    @Test
//    public void testPushValue() {
//        int actual =
//        Assert.assertEquals();
//    }
//}
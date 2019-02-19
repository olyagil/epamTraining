package by.training.task01.action;

import by.training.task01.entity.Circle;
import by.training.task01.entity.Point;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CircleActionTest {
    CircleAction action = new CircleAction();

    @DataProvider(name = "inputDataForArea")
    public Object[][] createCorrectDataForArea() {
        return
                new Object[][]{
                        {2, 12.5},
                        {1, 3.1},
                        {0, 0},};
    }

    @Test(description = "Positive scenario of the square calculation",
            dataProvider = "inputDataForArea")
    public void testCalcArea(double radius, double expected) throws Exception {
        Circle circle = new Circle(null, radius);
        double actual = action.calcArea(circle);
        Assert.assertEquals(actual, expected, 0.1);
    }


    @DataProvider(name = "inputDataForPerimeter")
    public Object[][] createCorrectDataForPerimeter() {
        return
                new Object[][]{
                        {2, 12.56},
                        {1, 6.283},
                        {0, 0},};
    }

    @Test(description = "Positive scenario of the perimeter calculation",
            dataProvider = "inputDataForPerimeter")
    public void testCalcPerimeter(double radius, double expected) {
        Circle circle = new Circle(null, radius);
        double actual = action.calcPerimeter(circle);
        Assert.assertEquals(actual, expected, 0.1);
    }

    @DataProvider(name = "inputDataForCircle")
    public Object[][] createCorrectData() {
        return
                new Object[][]{
                        {2, true},
                        {1, true},
                        {0, false},
                        {-1, false}};
    }

    @Test(description = "Positive scenario of the circle verification",
            dataProvider = "inputDataForCircle")
    public void testIsCircle(double radius, boolean expected) {
        Circle circle = new Circle(null, radius);
        boolean actual = action.isCircle(circle);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "inputDataForCircleInterception")
    public Object[][] createCorrectDataForCircleInterception() {
        return
                new Object[][]{
                        {5, 2, true},
                        {9, 3, false},
                        {4, 1, true},
                        {0, 5, false},
                        {-1, 2, false}};
    }

    @Test(description = "Positive scenario of the circle verification",
            dataProvider = "inputDataForCircleInterception")
    public void testIsCross(double radius, int distance, boolean expected) {
        Circle circle = new Circle(new Point(2, 3), radius);
        boolean actual = action.isCross(circle, distance);
        Assert.assertEquals(actual, expected);
    }
}

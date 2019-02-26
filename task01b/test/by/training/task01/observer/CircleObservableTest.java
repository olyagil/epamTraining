package by.training.task01.observer;

import by.training.task01.action.CircleAction;
import by.training.task01.entity.CircleParameters;
import by.training.task01.entity.Point;
import org.testng.Assert;
import org.testng.annotations.*;


public class CircleObservableTest {

    public static final int ID = 1;
    private Point center;
    private CircleObservable circle;

    @BeforeClass
    public void setUp() {
        center = new Point(1, 1);
        double radius = 3.0;
        circle = new CircleObservable(center, radius);
        circle.setCircleId(ID);
        CircleObserver.getInstance().setCircleAction(new CircleAction());
        CircleObserver.getInstance().update(circle);
    }

    @AfterClass
    public void tearDown() {
        center = null;
        circle = null;

    }

    @DataProvider(name = "dataForGetCircleParametersById")
    public Object[][] dataForGetCircleParametersById() {
        return new Object[][]{
                {28.27, 18.84},
        };
    }

    /**
     * This test will check if you can get parameters by ID right.
     *
     * @param area      of the circle
     * @param perimeter of the circle
     */
    @Test(description = "The scenario of the getting parameters by id",
            dataProvider = "dataForGetCircleParametersById")
    public void testGetCircleParametersById(double area, double perimeter) {
        CircleParameters actual = CircleObserver.getInstance()
                .getCircleParametersById(circle.getCircleId());
        CircleParameters expected = new CircleParameters(area, perimeter);
        Assert.assertEquals(actual.getArea(), expected.getArea(), 0.01);
    }
}
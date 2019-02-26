package by.training.task01.observer;

import by.training.task01.action.CircleAction;
import by.training.task01.entity.CircleParameters;
import by.training.task01.entity.Point;
import org.testng.Assert;
import org.testng.annotations.*;

public class CircleObserverTest {

    private static final int ID = 1;
    private static Point center;
    private static double radius;

    private static CircleObservable circle;

    @BeforeClass
    public void setUp() {
        center = new Point(1.0, 1.0);
        radius = 1.0;
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

    @DataProvider(name = "dataForTest")
    public static Object[][] dataForTest() {
        return
                new Object[][]{
                        {1.0, 1.0, 1.0},
                        {5.0, 5.0, 1.0},
                        {3.0, 3.0, 1.0},
                        {15.0, 15.0, 1.0},
                        {0.0, 0.0, 1.0},
                };
    }

    /**
     * This test will check if the method notifyObserver is working correctly.
     */
    @Test(description = "The scenario of the notifying the observer",
            dataProvider = "dataForTest")
    public void testNotifyObserver(double x, double y, double radius) {
        circle.addObserver(CircleObserver.getInstance());
        CircleParameters actual = CircleObserver.getInstance()
                .getCircleParametersById(circle.getCircleId());
        circle.setCenter(new Point(x, y));
        circle.setRadius(radius);
        CircleParameters expected = CircleObserver.getInstance()
                .getCircleParametersById(circle.getCircleId());
        Assert.assertEquals(actual.getPerimeter(), expected.getPerimeter());

    }
}

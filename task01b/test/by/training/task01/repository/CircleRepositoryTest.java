package by.training.task01.repository;

import by.training.task01.action.CircleAction;
import by.training.task01.entity.Circle;
import by.training.task01.entity.Point;
import by.training.task01.repository.specification.CircleSpecification;
import by.training.task01.repository.specification.impl.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;


public class CircleRepositoryTest {

    public static final int ID_1 = 1;
    public static final int ID_2 = 2;
    private static CircleRepository circleRepository = new CircleRepository();
    private static Point centerA;
    private static double radiusA;
    private static Point centerB;
    private static double radiusB;
    private static Circle circleA;
    private static Circle circleB;
    private static List<Circle> circleList;
    private static CircleAction circleAction;


    @BeforeMethod
    public void setUp() {
        centerA = new Point(1.0, 1.0);
        radiusA = 1.0;
        circleA = new Circle(centerA, radiusA);
        circleA.setCircleId(ID_1);
        centerB = new Point(2.0, 2.0);
        radiusB = 2.0;
        circleB = new Circle(centerA, radiusA);
        circleB.setCircleId(ID_2);
        circleList = new ArrayList<>();
        circleList.add(circleA);
        circleList.add(circleB);
    }

    @AfterClass
    public void tearDown() {
    }

    @DataProvider(name = "SpecificationForTest")
    public static Object[][] SpecificationForTest() {
        return new Object[][]{
                {new SortByRadiusCircleSpecificationSpecification()},
        };
    }

    @Test(description = "The scenario of the query with specification",
            dataProvider = "SpecificationForTest")
    public void testQuery(CircleSpecification specification) {
        List<Circle> expected = new ArrayList<>();
        circleRepository.add(circleA);
        circleRepository.add(circleA);
        expected.add(circleB);
        expected.add(circleB);
        List<Circle> actual = circleRepository.query(specification);
        Assert.assertEquals(actual, expected);
    }
}
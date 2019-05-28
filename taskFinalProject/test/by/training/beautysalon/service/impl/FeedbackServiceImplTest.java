package by.training.beautysalon.service.impl;

import by.training.beautysalon.dao.connection.ConnectionPool;
import by.training.beautysalon.dao.mysql.DaoFactory;
import by.training.beautysalon.entity.Employee;
import by.training.beautysalon.entity.Feedback;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.DataBaseException;
import by.training.beautysalon.service.FeedbackService;
import by.training.beautysalon.service.ServiceFactory;
import by.training.beautysalon.utill.ImageUtil;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class FeedbackServiceImplTest {

    private ServiceFactory factory;
    private FeedbackService service;

    @BeforeClass
    public void setUp() throws DataBaseException {
        ConnectionPool.getInstance().init();
        factory = new ServiceFactory(new DaoFactory());
        service = factory.getFeedbackService();

    }

    @AfterClass
    public void tearDown() {
        factory.close();
    }

    @DataProvider(name = "dataForFindFeedbackByClientId")
    public static Object[][] dataForFindFeedbackByClientId() {
        User client2 = new User();
        client2.setSurname("Петров");
        client2.setName("Александр");
        client2.setId(2);
        client2.setRole(Role.CLIENT);
        client2.setAvatar(ImageUtil.encoderFromFile("D:/IdeaProjects" +
                "/epamTraining/taskFinalProject/web/img/man_1.jpg"));
        Employee employee10 = new Employee();
        employee10.setSurname("Иванова");
        employee10.setName("Виктория");
        employee10.setId(10);
        employee10.setRole(Role.EMPLOYEE);
        return new Object[][]{
                {Arrays.asList(new Feedback(1,
                        client2,
                        employee10,
                        Date.valueOf("2019-04-16"),
                        "Очень хорошое обуслуживание"))},
        };
    }

    @Test(dataProvider = "dataForFindFeedbackByClientId", description = "test for checking " +
            "finding feedback by id")
    public void testFindAllServices(List<Feedback> expected) throws
            DataBaseException {
        List<Feedback> actual = service.findByClientId(2);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForFindFeedbackById")
    public static Object[][] dataForFindFeedbackById(){
        User client2 = new User();
        client2.setSurname("Петров");
        client2.setName("Александр");
        client2.setId(2);
        client2.setRole(Role.CLIENT);
        client2.setAvatar(ImageUtil.encoderFromFile("D:/IdeaProjects" +
                "/epamTraining/taskFinalProject/web/img/man_1.jpg"));
        Employee employee10 = new Employee();
        employee10.setSurname("Иванова");
        employee10.setName("Виктория");
        employee10.setId(10);
        employee10.setRole(Role.EMPLOYEE);
        User client3 = new User();
        client3.setSurname("Сидоров");
        client3.setName("Петр");
        client3.setId(3);
        client3.setRole(Role.CLIENT);
        client3.setAvatar(ImageUtil.encoderFromFile("D:/IdeaProjects" +
                "/epamTraining/taskFinalProject/web/img/man_2.jpg"));
        Employee employee9 = new Employee();
        employee9.setSurname("Афонасьева");
        employee9.setName("Юлия");
        employee9.setId(9);
        employee9.setRole(Role.EMPLOYEE);
        return new Object[][]{
                {new Feedback(1,
                        client2,
                        employee10,
                        Date.valueOf("2019-04-16"),
                        "Очень хорошое обуслуживание")},
                {new Feedback(2,
                        client3,
                        employee9,
                        Date.valueOf("2019-04-20"),
                        "Хорошое обуслуживание")},
        };
    }

    @Test(dataProvider = "dataForFindFeedbackById", description = "test for " +
            "finding feedback by id")
    public void testFindById(Feedback expected) throws DataBaseException {
        Feedback actual = service.find(expected.getId());
        Assert.assertEquals(actual, expected);
    }


    @DataProvider(name = "dataForSaveFeedback")
    public static Object[][] dataForSaveFeedback(){
        User client2 = new User();
        client2.setSurname("Петров");
        client2.setName("Александр");
        client2.setId(2);
        client2.setRole(Role.CLIENT);
        client2.setAvatar(ImageUtil.encoderFromFile("D:/IdeaProjects" +
                "/epamTraining/taskFinalProject/web/img/man_1.jpg"));
        Employee employee10 = new Employee();
        employee10.setSurname("Иванова");
        employee10.setName("Виктория");
        employee10.setId(10);
        employee10.setRole(Role.EMPLOYEE);
        User client3 = new User();
        client3.setSurname("Сидоров");
        client3.setName("Петр");
        client3.setId(3);
        client3.setRole(Role.CLIENT);
        client3.setAvatar(ImageUtil.encoderFromFile("D:/IdeaProjects" +
                "/epamTraining/taskFinalProject/web/img/man_2.jpg"));
        Employee employee9 = new Employee();
        employee9.setSurname("Афонасьева");
        employee9.setName("Юлия");
        employee9.setId(9);
        employee9.setRole(Role.EMPLOYEE);
        return new Object[][]{
                {new Feedback(
                        client2,
                        employee10,
                        Date.valueOf("2019-04-16"),
                        "Очень хорошое обуслуживание")},
                {new Feedback(
                        client3,
                        employee9,
                        Date.valueOf("2019-04-20"),
                        "Хорошое обуслуживание")},
                {new Feedback(
                        client2,
                        employee9,
                        Date.valueOf("2019-04-20"),
                        "Хорошое обуслуживание")},
        };
    }

    @Test(dataProvider = "dataForSaveFeedback", description = "test for " +
            "saving feedback")
    public void testSave(Feedback expected) throws DataBaseException {
        Integer id = service.save(expected);
        Feedback actual = service.find(id);
        expected.setId(id);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForDeleteFeedback")
    public static Object[][] dataForDeleteFeedback() {
        return new Object[][]{
                {5},
                {6},
                {7},

        };
    }

    @Test(dataProvider = "dataForDeleteFeedback", description = "test for " +
            "checking if deleting from BD correctly.", dependsOnMethods = "testSave")
    public void testDelete(Integer id) throws DataBaseException {
        Assert.assertTrue(service.delete(id));
    }
}
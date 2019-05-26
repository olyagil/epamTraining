package by.training.beatysalon.dao.mysql;

import by.training.beautysalon.dao.UserDao;
import by.training.beautysalon.dao.connection.ConnectionPool;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.entity.enumeration.Gender;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.Date;

public class UserDaoImplTest {
    UserDao userDao;
//    TransactionFactory transactionFactory;
//    Transaction service;
    //    TransactionFactory factory;
    User user;

    private static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/salon_db" +
            "?useUnicode=true&characterEncoding=UTF-8";
    private static final String DB_USER = "salon_user";
    private static final String DB_PASSWORD = "salon_password";

    private static final int DB_POOL_START_SIZE = 10;
    private static final int DB_POOL_MAX_SIZE = 1000;
    private static final int DB_POOL_CHECK_CONNECTION_TIMEOUT = 0;

    @BeforeClass
    public void setUp() throws PersistentException {
//        transactionFactory = new TransactionFactoryImpl();
//        service = transactionFactory.createTransaction();
//        userDao = service.createDao(UserDao.class);
//        factory =
        ConnectionPool.getInstance().init();
        Connection connection = ConnectionPool.getInstance().getConnection();

        user = new User();
        user.setId(1);
        user.setLogin("admin");
        user.setPassword("21232f297a57a5a743894a0e4a801fc3");
        user.setRole(Role.ADMINISTRATOR);
        user.setName("Ольга");
        user.setSurname("Гиль");
        user.setPatronymic("Станиславовна");
        user.setGender(Gender.FEMALE);
        user.setPhone(333036201);
        user.setBirthDate(Date.valueOf("1997-09-16"));
//        user.setAvatar();
    }

    @Test
    public void testRead() throws PersistentException {
        System.out.println(userDao.read(1));
        User expected = user;
        User actual = userDao.read(1);
        Assert.assertEquals(actual, expected);
    }

}
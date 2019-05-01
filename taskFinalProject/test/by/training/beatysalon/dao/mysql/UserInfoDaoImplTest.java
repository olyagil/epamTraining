package by.training.beatysalon.dao.mysql;

import by.training.beatysalon.dao.Transaction;
import by.training.beatysalon.dao.TransactionFactory;
import by.training.beatysalon.dao.UserInfoDao;
import by.training.beatysalon.exception.PersistentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserInfoDaoImplTest {
    UserInfoDao userInfoDao;
    TransactionFactory transactionFactory;
    Transaction transaction;

    @BeforeMethod
    public void setUp() throws PersistentException {
        transactionFactory = new TransactionFactoryImpl();
        transaction = transactionFactory.createTransaction();
        userInfoDao = transaction.createDao(UserInfoDao.class);
    }
    @Test
    public void testRead() throws PersistentException {
//        System.out.println(userInfoDao.readById(3));

    }

}
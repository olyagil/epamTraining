package by.training.beatysalon.controller;

import by.training.beatysalon.dao.BillDao;
import by.training.beatysalon.dao.ServiceDao;
import by.training.beatysalon.dao.SpecialistDao;
import by.training.beatysalon.dao.Transaction;
import by.training.beatysalon.dao.TransactionFactory;
import by.training.beatysalon.dao.UserDao;
import by.training.beatysalon.dao.UserInfoDao;
import by.training.beatysalon.dao.mysql.TransactionFactoryImpl;
import by.training.beatysalon.dao.pool.ConnectionPool;
import by.training.beatysalon.domain.Role;
import by.training.beatysalon.domain.Service;
import by.training.beatysalon.domain.Specialist;
import by.training.beatysalon.domain.Specialty;
import by.training.beatysalon.domain.User;
import by.training.beatysalon.domain.UserInfo;
import by.training.beatysalon.exception.PersistentException;

import java.sql.Date;

public class Main {
    private static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/salon_db" +
            "?useUnicode=true&characterEncoding=UTF-8";
    private static final String DB_USER = "salon_user";
    private static final String DB_PASSWORD = "salon_password";

    private static final int DB_POOL_START_SIZE = 10;
    private static final int DB_POOL_MAX_SIZE = 1000;
    private static final int DB_POOL_CHECK_CONNECTION_TIMEOUT = 0;


    public static void main(String[] args) throws PersistentException {
        ConnectionPool.getInstance().init(DB_DRIVER_CLASS, DB_URL, DB_USER,
                DB_PASSWORD, DB_POOL_START_SIZE, DB_POOL_MAX_SIZE,
                DB_POOL_CHECK_CONNECTION_TIMEOUT);

        TransactionFactory transactionFactory = new TransactionFactoryImpl();
        Transaction transaction = transactionFactory.createTransaction();
//        UserDao userDao = transaction.createDao(UserDao.class);
//        userDao.read("admin", "admin");
//
//        userDao.read(2);
//        User client = new User();
////        client.setId(8);
//        client.setLogin("qwerty");
//        client.setPassword("qwerty");
//        client.setRole(Role.CLIENT);
//        userDao.create(client);
////        client.setRole(Role.SPECIALIST);
////        userDao.update(client );
//        System.out.println("LOGIN: " + userDao.read());
//        BillDao billDao = transaction.createDao(BillDao.class);
////        System.out.println(billDao.readBySpecialist(8));
//
////        System.out.println("FIO:" + userDao.readInfo());
//        System.out.println(userDao.read("client2", "client"));
//
//        UserInfo userInfo = new UserInfo();
//        userInfo.setId(4);
//        userInfo.setName("Татьяна");
//        userInfo.setSurname("Петрова");
//        userInfo.setPatronymic("Петровна");
//        userInfo.setPhone(13248461);
//        userInfo.setBirthDate(new Date(2019-02-16));
//        UserInfoDao userInfoDao = transaction.createDao(UserInfoDao.class);
////        userInfoDao.create(userInfo);
//        System.out.println(userInfoDao.read());
//        userInfoDao.update(userInfo);
//        System.out.println(userInfoDao.read(4));
////        userInfoDao.delete(4);
//        System.out.println(userInfoDao.read());
//
//        Service service = new Service();
////        service.setId(2);
//        service.setName("Ногті");
//        service.setDescription("xgfgfhfcbcb cbcbv gfnv v");
//        service.setPrice(453.415);
//        service.setDuration(45);
//
//        ServiceDao serviceDao = transaction.createDao(ServiceDao.class);
//        System.out.println(serviceDao.readByPrice(0, 1200));
//        System.out.println(serviceDao.readByName("Визаж"));
        SpecialistDao specialistDao =
                transaction.createDao(SpecialistDao.class);
        Specialist specialist = new Specialist();
specialist.setId(13);
        specialist.setCabinetNumber(10);
        specialist.setSalary(10000.0);
        specialist.setEmploymentDate(new Date(2000 - 12 - 05));
        specialist.setSpecialty(Specialty.COSMETOLOGIST);
        System.out.println(specialistDao.read());

//        specialistDao.update();
//        specialistDao.create(specialist);
        System.out.println(specialistDao.read(9));
        System.out.println(specialistDao.read());

    }

}

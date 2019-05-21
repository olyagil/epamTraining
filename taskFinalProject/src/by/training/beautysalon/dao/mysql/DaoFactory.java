package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.dao.EmployeeDao;
import by.training.beautysalon.dao.FeedbackDao;
import by.training.beautysalon.dao.ServiceDao;
import by.training.beautysalon.dao.TalonDao;
import by.training.beautysalon.dao.UserDao;
import by.training.beautysalon.dao.connection.ConnectionPool;
import by.training.beautysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final DaoFactory instance = new DaoFactory();
    private Connection connection;

    private DaoFactory() {
        try {
            connection = ConnectionPool.getInstance().getConnection();
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public UserDao getUserDao() {
        UserDao dao = new UserDaoImpl(connection);
        ((UserDaoImpl) dao).setConnection(connection);
        return dao;
    }

    public EmployeeDao getEmployeeDao() {
        EmployeeDao dao = new EmployeeDaoImpl();
        ((EmployeeDaoImpl) dao).setConnection(connection);
        return dao;
    }

    public ServiceDao getServiceDao() {
        ServiceDao dao = new ServiceDaoImpl();
        ((ServiceDaoImpl) dao).setConnection(connection);
        return dao;
    }

    public TalonDao getTalonDao() {
        TalonDao dao = new TalonDaoImpl();
        ((TalonDaoImpl) dao).setConnection(connection);
        return dao;
    }

    public FeedbackDao getFeedbackDao() {
        FeedbackDao dao = new FeedbackDaoImpl();
        ((FeedbackDaoImpl) dao).setConnection(connection);
        return dao;
    }

    public void commit() throws PersistentException {
        try {
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error("It is impossible to commit transaction", e);
            throw new PersistentException(e);
        }
    }

    public void rollback() throws PersistentException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            LOGGER.error("It is impossible to rollback transaction", e);
            throw new PersistentException(e);
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            LOGGER.error("Can't close connection to DB", e);
        }
    }
}

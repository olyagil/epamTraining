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
        return new UserDaoImpl(connection);
    }

    public EmployeeDao getEmployeeDao() {
        return new EmployeeDaoImpl(connection);
    }

    public ServiceDao getServiceDao() {
        return new ServiceDaoImpl(connection);
    }

    public TalonDao getTalonDao() {
        return new TalonDaoImpl(connection);
    }

    public FeedbackDao getFeedbackDao() {
        return new FeedbackDaoImpl(connection);
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
            LOGGER.debug("Closing connection to DB");

            connection.close();
        } catch (SQLException e) {
            LOGGER.error("Can't close connection to DB", e);
        }
    }
}

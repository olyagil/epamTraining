package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.dao.Dao;
import by.training.beautysalon.dao.BillDao;
import by.training.beautysalon.dao.ServiceDao;
import by.training.beautysalon.dao.SpecialistDao;
import by.training.beautysalon.dao.Transaction;
import by.training.beautysalon.dao.UserDao;
import by.training.beautysalon.dao.UserInfoDao;
import by.training.beautysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionImpl implements Transaction {

    private static final Logger LOGGER = LogManager.getLogger();

    private static Map<Class<? extends Dao<?>>, Class<? extends BaseDaoImpl>>
            classMap = new ConcurrentHashMap<>();

    static {
        classMap.put(UserDao.class, UserDaoImpl.class);
        classMap.put(BillDao.class, BillDaoImpl.class);
        classMap.put(UserInfoDao.class, UserInfoDaoImpl.class);
        classMap.put(SpecialistDao.class, SpecialistDaoImpl.class);
        classMap.put(ServiceDao.class, ServiceDaoImpl.class);
    }

    private Connection connection;

    public TransactionImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <Type extends Dao<?>> Type createDao(Class<Type> key) throws PersistentException {
        Class<? extends BaseDaoImpl> value = classMap.get(key);
        if (value != null) {
            try {
                BaseDaoImpl dao = value.newInstance();
                dao.setConnection(connection);
                return (Type) dao;
            } catch (InstantiationException | IllegalAccessException e) {
                LOGGER.error("Impossible to create data access object.", e);
                throw new PersistentException(e);
            }
        }
        return null;
    }

    @Override
    public void commit() throws PersistentException {
        try {
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error("Can't commit transaction.", e);
            throw new PersistentException(e);
        }
    }

    @Override
    public void rollback() throws PersistentException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            LOGGER.error("Can't rollback transaction", e);
            throw new PersistentException(e);
        }
    }
}
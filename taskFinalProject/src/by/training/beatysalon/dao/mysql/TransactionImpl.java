package by.training.beatysalon.dao.mysql;

import by.training.beatysalon.dao.Dao;
import by.training.beatysalon.dao.SpecialistDao;
import by.training.beatysalon.dao.TalonDao;
import by.training.beatysalon.dao.Transaction;
import by.training.beatysalon.dao.UserDao;
import by.training.beatysalon.dao.UserInfoDao;
import by.training.beatysalon.domain.UserInfo;
import by.training.beatysalon.exception.PersistentException;
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
        classMap.put(TalonDao.class, TalonDaoImpl.class);
        classMap.put(UserInfoDao.class, UserInfoDaoImpl.class);
//        classMap.put(SpecialistDao.class,);
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

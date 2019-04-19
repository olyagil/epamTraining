package by.training.beatysalon.dao.mysql;

import by.training.beatysalon.dao.Transaction;
import by.training.beatysalon.dao.TransactionFactory;
import by.training.beatysalon.dao.pool.ConnectionPool;
import by.training.beatysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionFactoryImpl implements TransactionFactory {
    private static final Logger LOGGER = LogManager.getLogger();
    private Connection connection;

    public TransactionFactoryImpl() throws PersistentException {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            LOGGER.error("Can't turn off autocommit for database connection.");
            throw new PersistentException(e);
        }
    }

    @Override
    public Transaction createTransaction() throws PersistentException {
        return new TransactionImpl(connection);
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {

        }
    }
}

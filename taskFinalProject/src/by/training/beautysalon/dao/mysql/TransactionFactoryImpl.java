package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.dao.Transaction;
import by.training.beautysalon.dao.TransactionFactory;
import by.training.beautysalon.dao.connection.ConnectionPool;
import by.training.beautysalon.exception.PersistentException;
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
            LOGGER.debug("Trying close connection");
            connection.close();
        } catch (SQLException e) {
            LOGGER.error("Can't close the connection " + e);
        }
    }
}

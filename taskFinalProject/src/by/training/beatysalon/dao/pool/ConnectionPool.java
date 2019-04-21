package by.training.beatysalon.dao.pool;

import by.training.beatysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger();
    private String url;
    private String user;
    private String password;
    private int maxSize;
    private int checkConnectionTimeout;
    private ReentrantLock lock;
    private BlockingQueue<PooledConnection> freeConnections =
            new LinkedBlockingQueue<>();
    private List<PooledConnection> usedConnections = new ArrayList<>();

    private ConnectionPool() {
        lock = new ReentrantLock();
    }

    private static ConnectionPool instance = new ConnectionPool();

    public static ConnectionPool getInstance() {
        return instance;
    }

    public Connection getConnection() throws PersistentException {

        PooledConnection connection = null;
        while (connection == null) {
            try {
                lock.lock();
                if (!freeConnections.isEmpty()) {
                    connection = freeConnections.take();
                    if (!connection.isValid(checkConnectionTimeout)) {
                        try {
                            connection.getConnection().close();
                        } catch (SQLException e) {
                        }
                        connection = null;
                    }
                } else if (usedConnections.size() < maxSize) {
                    connection = createConnection();
                } else {
                    LOGGER.error("The limit of number of database connections is" +
                            " exceeded");
                    throw new PersistentException();
                }
            } catch (InterruptedException | SQLException e) {
                LOGGER.error("It is impossible to connect to a database", e);
                throw new PersistentException(e);
            } finally {
                lock.unlock();
            }
        }
        usedConnections.add(connection);
        LOGGER.debug(String.format("Connection was received from pool. " +
                        "Current pool size: %d used connections; %d free connection",
                usedConnections.size(), freeConnections.size()));
        return connection;
    }

    void releaseConnection(PooledConnection connection) {
        try {
            lock.lock();
            if (!connection.isValid(checkConnectionTimeout)) {
                connection.clearWarnings();
                connection.setAutoCommit(true);
                usedConnections.remove(connection);
                freeConnections.put(connection);
                LOGGER.debug(String.format("Connection was returned into pool. " +
                        "Current pool size: %d used connections; %d free connection", usedConnections.size(), freeConnections.size()));
            }
        } catch (SQLException | InterruptedException e) {
            LOGGER.warn("It is impossible to return database connection into pool"
                    , e);
        }
        try {
            connection.getConnection().close();
        } catch (SQLException e) {
        } finally {
            lock.unlock();
        }
    }

    public void init(String driverCLass, String url,
                     String user, String password,
                     int startSize, int maxSize,
                     int checkConnectionTimeout) throws PersistentException {

        try {
            lock.lock();
            destroy();
            Class.forName(driverCLass);
            this.url = url;
            this.user = user;
            this.password = password;
            this.maxSize = maxSize;
            this.checkConnectionTimeout = checkConnectionTimeout;
            for (int counter = 0; counter < startSize; counter++) {
                freeConnections.put(createConnection());
            }
        } catch (ClassNotFoundException | InterruptedException | SQLException e) {
            LOGGER.fatal("It is impossible to initialize connection pool", e);
            throw new PersistentException(e);
        } finally {
            lock.unlock();
        }

    }

    private void destroy() {
        lock.lock();
        usedConnections.addAll(freeConnections);
        freeConnections.clear();
        for (PooledConnection connection : usedConnections) {
            try {
                connection.getConnection().close();
            } catch (SQLException e) {
            } finally {
                lock.unlock();
            }
        }
        usedConnections.clear();
    }

    private PooledConnection createConnection() throws SQLException {
        return new PooledConnection(DriverManager.getConnection(url, user,
                password));
    }

    @Override
    protected void finalize() throws Throwable {
        destroy();
    }
}

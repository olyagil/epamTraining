package by.training.beautysalon.dao.connection;

import by.training.beautysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;

//TODO add synchronization
//TODO maybe delete destroy and finalize
public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger();
    private String url;
    private String user;
    private String password;
    private int maxSize;
    private int checkConnectionTimeout;

    private BlockingQueue<PooledConnection> freeConnections
            = new LinkedBlockingQueue<>();
    private Set<PooledConnection> usedConnections
            = new ConcurrentSkipListSet<>();

    private static ConnectionPool instance = new ConnectionPool();

    private ConnectionPool() {
    }


    public static ConnectionPool getInstance() {
        return instance;
    }

    public Connection getConnection() throws PersistentException {

        PooledConnection connection = null;
        while (connection == null) {
            try {
                if (!freeConnections.isEmpty()) {
                    connection = freeConnections.take();
                    if (!connection.isValid(checkConnectionTimeout)) {
                        try {
                            connection.getConnection().close();
                        } catch (SQLException e) {
                            LOGGER.error("Can't close connection", e);
                        }
                        connection = null;
                    }
                } else if (usedConnections.size() < maxSize) {
                    connection = createConnection();
                } else {
                    LOGGER.error("The limit of number of database " +
                            "connections is exceeded");
                    throw new PersistentException();
                }
            } catch (InterruptedException | SQLException e) {
                LOGGER.error("It is impossible to connect to a database", e);
                throw new PersistentException(e);
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
            if (connection.isValid(checkConnectionTimeout)) {
                connection.clearWarnings();
//                connection.setAutoCommit(true);
                usedConnections.remove(connection);
                freeConnections.put(connection);
                LOGGER.debug(String.format("Connection was released into pool. "
                                + "Current pool size: %d used connections;"
                                + " %d free connection", usedConnections.size(),
                        freeConnections.size()));
            }
        } catch (SQLException | InterruptedException e) {
            LOGGER.error("Can't return database connection into pool", e);
            try {
                connection.getConnection().close();
            } catch (SQLException e2) {
                LOGGER.error("Can't close connection", e2);
            }
        }
    }

    public void init() throws PersistentException {
        try {
            DBConfigurationManager confManager =
                    DBConfigurationManager.getInstance();
            destroy();
            Class.forName(confManager.getValue("jdbc.driver"));
            this.url = confManager.getValue("jdbc.url");
            this.user = confManager.getValue("jdbc.user");
            this.password = confManager.getValue("jdbc.password");
            this.maxSize = Integer.parseInt(confManager
                    .getValue("jdbc.pool.size.max"));
            this.checkConnectionTimeout = Integer.parseInt(confManager
                    .getValue("jdbc.pool.connection.timeout"));
            int startSize = Integer.parseInt(confManager
                    .getValue("jdbc.pool.size.start"));

            for (int counter = 0; counter < startSize; counter++) {
                freeConnections.put(createConnection());
            }
        } catch (ClassNotFoundException | InterruptedException | SQLException e) {
            LOGGER.fatal("It is impossible to initialize connection", e);
            throw new PersistentException(e);
        }
    }

    private void destroy() {
        usedConnections.addAll(freeConnections);
        freeConnections.clear();
        for (PooledConnection connection : usedConnections) {
            try {
                connection.getConnection().close();
            } catch (SQLException e) {
                LOGGER.error("Can't close the connection", e);
            }
        }
        usedConnections.clear();
    }

    private PooledConnection createConnection() throws SQLException {
        LOGGER.debug("Creating connection");
        return new PooledConnection(DriverManager.getConnection(url, user,
                password));
    }

    @Override
    protected void finalize() throws Throwable {
        destroy();
    }
}

package by.training.beatysalon.dao.mysql;

import java.sql.Connection;

public abstract class BaseDaoPool {

    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}

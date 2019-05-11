package by.training.beautysalon.dao.connection;

import java.util.ResourceBundle;

public class DBConfigurationManager {

    private static DBConfigurationManager instance = new DBConfigurationManager();
    private ResourceBundle bundle = ResourceBundle.getBundle("db_config");

    private DBConfigurationManager() {

    }

    public static DBConfigurationManager getInstance() {
        return instance;
    }

    String getValue(String key) {
        return bundle.getString(key);
    }
}

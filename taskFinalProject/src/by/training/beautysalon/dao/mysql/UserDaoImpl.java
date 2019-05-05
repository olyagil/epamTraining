package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.dao.UserDao;
import by.training.beautysalon.domain.Role;
import by.training.beautysalon.domain.User;
import by.training.beautysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String SQL_DELETE_BY_ID = "delete from `users` where `id`=?";
    public static final String SELECT_BY_PASSWORD_LOGIN = "select `id`, `role` from `users` where `login`= ? and " +
            "`password` = ?";
    public static final String SELECT_ALL = "select `id`, `login`, `role` "
            + "from `users`";
    public static final String INSERT_USER = "insert into `users` (`login`, `password`, `role`) " +
            "values (?,?,?)";
    public static final String SELECT_BY_ID = "select `login`, `role` from `users`" +
            "where `id`=?";
    public static final String UPDATE_USER = "update `users` set `login`=?, `password`=?, `role`=?"
            + "where `id`=?";

    //TODO ?????
    @Override
    public User read(String login, String password) throws PersistentException {
        ResultSet resultSet = null;
        try (PreparedStatement statement =
                     connection.prepareStatement(SELECT_BY_PASSWORD_LOGIN)) {
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(Role.getById(resultSet.getInt("role")));
            }
            System.out.println(user);
            return user;
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {

            }
        }
    }

    @Override
    public List<User> read() throws PersistentException {
        List<User> clientList;
        try (PreparedStatement statement =
                     connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            clientList = new ArrayList<>();
            User client;
            while (resultSet.next()) {
                client = new User();
                client.setId(resultSet.getInt("id"));
                client.setLogin(resultSet.getString("login"));
//                client.setPassword(resultSet.getString("password"));
                client.setRole(Role.getById(resultSet.getInt("role")));
                clientList.add(client);
            }
            return clientList;
        } catch (SQLException e) {
            throw new PersistentException(e);

        }
    }

    @Override
    public Integer create(User user) throws PersistentException {
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(INSERT_USER,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getId());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                LOGGER.error("There is no autoincremented index after trying " +
                        "to add record into `users` ");
                throw new PersistentException();
            }
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public User read(Integer id) throws PersistentException {
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(id);
                user.setLogin(resultSet.getString("login"));
//                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.getById(resultSet.getInt("role")));
            }
            return user;
        } catch (SQLException e) {
            LOGGER.error("Can't read the user from DB by id.");
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {

            }
        }
    }

    @Override
    public void update(User user) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_USER)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getId());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistentException(e);
        }
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(SQL_DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistentException(e);
        }
    }
}

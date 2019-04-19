package by.training.beatysalon.dao.mysql;

import by.training.beatysalon.dao.UserDao;
import by.training.beatysalon.dao.mysql.BaseDaoImpl;
import by.training.beatysalon.domain.Role;
import by.training.beatysalon.domain.User;
import by.training.beatysalon.exception.PersistentException;
import com.mysql.jdbc.NotUpdatable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Override
    public User read(String login, String password) throws PersistentException {
        String sql = "select `id`, `role` from `users` where `login`= ? and " +
                "`password` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
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
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {

            }
        }
    }

    @Override
    public List<User> read() throws PersistentException {
        String sql = "select `id`, `login`, `password`, `role` from `users` " +
                "order by `login`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.getById(resultSet.getInt("role")));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {

            }
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {

            }
        }

    }

    @Override
    public Integer create(User entity) throws PersistentException {
        return null;
    }

    @Override
    public User read(Integer id) throws PersistentException {
        return null;
    }

    @Override
    public void update(User entity) throws PersistentException {

    }

    @Override
    public void delete(Integer id) throws PersistentException {

    }
}

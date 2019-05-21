package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.dao.UserDao;
import by.training.beautysalon.domain.User;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.utill.ImageUtill;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String READ_ALL = "select `user_id`, `login`, " +
            "`role`, `surname`, `name`, `patronymic`, `gender`, `phone`, " +
            "`birth_date`, `avatar` from `users` join user_info ui on users" +
            ".id = ui.user_id where `role`=?";
    private static final String READ_BY_LOGIN = "select `user_id`, `login`, " +
            "`role`, `surname`, `name`, `patronymic`, `gender`, `phone`, " +
            "`birth_date`, `avatar` from `users` join user_info ui on users" +
            ".id = ui.user_id where `login`=?";
    private static final String CREATE_USER = "insert into `users` (`login`, `password`, `role`)\n" +
            "values (?, ?, ?);";
    private static final String CREATE_USER_BY_ID = "insert into `user_info`" +
            " (`user_id`, `name`, `surname`, `patronymic`, `gender`," +
            " `phone`, `birth_date`, `avatar`)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "select `user_id`,`login`, "
            + "`password`, `role`, `surname`, `name`,`patronymic`,`gender`, "
            + "`phone`, `birth_date`, `avatar` "
            + "from `users` join `user_info` ui on users.id=ui.user_id "
            + "where `user_id`=?";
    private static final String SELECT_BY_PASSWORD_LOGIN = " select `user_id`, "
            + "`login`, `password`, `role`, `surname`, `name`, `patronymic`,"
            + "`gender`, `phone`,`birth_date`, `avatar` "
            + "from `users` join `user_info` ui on users.id=ui.user_id "
            + "where `login`= ? and `password` = ?;";
    private static final String UPDATE_USER_INFO = "update `users` join user_info ui on users.id = ui.user_id set `login`=?,\n" +
            "`name`=?, `surname`=?, `patronymic`=?,\n" +
            "`gender`=?, `birth_date`=?, `phone`=? where `user_id`=?;";
    private static final String UPDATE_PASSWORD = "update `users` set " +
            "`password`=? where `id`=?";
    private static final String UPDATE_AVATAR = "update `user_info` set " +
            "`avatar`=? where `user_id`=?";
    private static final String DELETE_BY_ID = "delete from users where id=?";
    //    private static final String DELETE_USER_INFO_BY_ID = "delete from user_info where user_id=?";
    private static final String COUNT_USERS = "select count(`id`) from `users` where `role`=?";

    public UserDaoImpl(Connection connection) {

    }


    @Override
    public int countRows(int role) throws PersistentException {
        int count = 0;
        try (PreparedStatement statement = connection.prepareStatement(COUNT_USERS)) {
            statement.setInt(1, role);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Can't count all users from DB.", e);
            throw new PersistentException(e);
        }
        return count;
    }

    @Override
    public List<User> read() throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(READ_ALL)) {
            statement.setInt(1, 2);
//            statement.setInt(2, );
//            statement.setInt(3, );
            List<User> userList;
            try (ResultSet resultSet = statement.executeQuery()) {
                userList = new ArrayList<>();
                while (resultSet.next()) {
                    userList.add(getBuilder().build(resultSet));
                }
            }
            return userList;
        } catch (SQLException e) {
            LOGGER.error("Can't find all users from DB.", e);
            throw new PersistentException(e);
        }
    }

    @Override
    public List<User> read(String login) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(READ_BY_LOGIN)) {
            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<User> userList = new ArrayList<>();
                while (resultSet.next()) {
                    userList.add(getBuilder().build(resultSet));
                }
                return userList;
            }
        } catch (SQLException e) {
            LOGGER.error("Can't find the user from DB by id.", e);
            throw new PersistentException(e);
        }
    }


    @Override
    public Integer create(User user) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(CREATE_USER_BY_ID,
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, createUser(user));
            statement.setString(2, user.getName());
            statement.setString(3, user.getSurname());
            statement.setString(4, user.getPatronymic());
            statement.setInt(5, user.getGender().getId());
            statement.setInt(6, user.getPhone());
            statement.setDate(7, user.getBirthDate());
            statement.setBlob(8, ImageUtill.decoder(user.getAvatar()));
            statement.executeUpdate();
            return user.getId();
        } catch (SQLException e) {
            LOGGER.error("Can't create info about the user with id "
                    + user.getId(), e);
            throw new PersistentException(e);

        }
    }

    private Integer createUser(User user) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(CREATE_USER,
                Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getId());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                } else {
                    LOGGER.error("There is no autoincremented index after trying " +
                            "to add record into `users` ");
                    throw new PersistentException();
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Can't insert the user in db", e);
            throw new PersistentException(e);
        }
    }


    @Override
    public User read(Integer id) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                User user = null;
                if (resultSet.next()) {
                    user = getBuilder().build(resultSet);
                    user.setId(id);
                    user.setPassword(resultSet.getString("password"));
                }
                return user;
            }
        } catch (SQLException e) {
            LOGGER.error("Can't find the user from DB by id.", e);
            throw new PersistentException(e);
        }
    }

    @Override
    public User read(String login, String password) throws
            PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(SELECT_BY_PASSWORD_LOGIN)) {
            statement.setString(1, login);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                User user = null;
                if (resultSet.next()) {
                    user = getBuilder().build(resultSet);
//                    user.setLogin(login);
//                    user.setPassword(password);
                }
                return user;
            }
        } catch (SQLException e) {

            throw new PersistentException(e);
        }
    }


    @Override
    public boolean update(User user) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(UPDATE_USER_INFO)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getName());
            statement.setString(3, user.getSurname());
            statement.setString(4, user.getPatronymic());
            statement.setInt(5, user.getGender().getId());
            statement.setDate(6, user.getBirthDate());
            statement.setInt(7, user.getPhone());
            statement.setInt(8, user.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error("Can't update info about user with id: "
                    + user.getId(), e);
            throw new PersistentException(e);
        }

    }

    @Override
    public void updatePassword(User user) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(UPDATE_PASSWORD)) {
            statement.setString(1, user.getPassword());
            statement.setInt(2, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Can't update password for user with id: "
                    + user.getId(), e);
            throw new PersistentException(e);
        }
    }

    @Override
    public void updateAvatar(User user) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(UPDATE_AVATAR)) {
            statement.setBlob(1, ImageUtill.decoder(user.getAvatar()));
            statement.setInt(2, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Can't update avatar for user with id: "
                    + user.getId(), e);
            throw new PersistentException(e);
        }

    }

    @Override
    public boolean delete(Integer id) throws PersistentException {
        try (PreparedStatement statement
                     = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error("Can't delete user from DB with id: " + id, e);
            throw new PersistentException(e);
        }
    }

//    @Override
//    public void deleteUser(Integer id) throws PersistentException {
//        try (PreparedStatement statement
//                     = connection.prepareStatement(DELETE_USER_INFO_BY_ID)) {
//            statement.setInt(1, id);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            LOGGER.error("Can't delete info about user with id: " + id, e);
//            throw new PersistentException(e);
//        }
//    }


}

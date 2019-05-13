package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.dao.UserInfoDao;
import by.training.beautysalon.domain.User;
import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.domain.enumeration.Gender;
import by.training.beautysalon.domain.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDaoImpl extends BaseDaoImpl implements UserInfoDao {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String READ_ALL = "select `user_id`, `login`, " +
            "`role`, `surname`, `name`, `patronymic`, `gender`, `phone`, " +
            "`birth_date`, `avatar` from `users` join user_info ui on users" +
            ".id = ui.user_id where `role`=2";
    private static final String CREATE_USER_INFO = "insert into `user_info` " +
            "(`user_id`, `name`, `surname`, `patronymic`, `phone`, " +
            "`birth_date`, `avatar`) "
            + "VALUES (?,?,?,?,?,?,?)";
    private static final String READ_BY_ID = "select  `login`, `password`, " +
            "`role`, `surname`, `name`,`patronymic`,`gender`, `phone`," +
            "`birth_date`, `avatar` from `users` join `user_info` ui on users" +
            ".id=ui.user_id    where `user_id`=?";
    private static final String READ_BY_PASSWORD_LOGIN = " select `id`, " +
            "`login`, `password`, `role`, `surname`, `name`,`patronymic`, `gender`, " +
            "`phone`,`birth_date`, `avatar` from `users` join `user_info` " +
            "ui on users.id=ui.user_id where `login`= ? and `password` = ?;";
    private static final String UPDATE_USER_INFO = "update `users` " +
            "join user_info ui on users.id = ui.user_id\n set `login`=?, " +
            "`password`=?, `role`=?, `name`=?, `surname`=?, `patronymic`=?, " +
            "`gender`=?, `birth_date`=?, `phone`=?, avatar=? where `user_id`=?";
    private static final String DELETE_BY_ID = "delete from `user_info` where `user_id`=?";

    @Override
    public List<UserInfo> read() throws PersistentException {
        List<UserInfo> userInfoList;
        try (PreparedStatement statement = connection.prepareStatement(READ_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            userInfoList = new ArrayList<>();
            UserInfo userInfo;
            while (resultSet.next()) {
                userInfo = new UserInfo();
                userInfo.setId(resultSet.getInt("user_id"));
                userInfo.setLogin(resultSet.getString("login"));
                userInfo.setRole(Role.getById(resultSet.getInt("role")));
                userInfo.setSurname(resultSet.getString("surname"));
                userInfo.setName(resultSet.getString("name"));
                userInfo.setPatronymic(resultSet.getString("patronymic"));
                userInfo.setGender(Gender.getById(resultSet.getInt("gender")));
                userInfo.setPhone(resultSet.getInt("phone"));
                userInfo.setBirthDate(resultSet.getDate("birth_date"));
                userInfoList.add(userInfo);
            }
            return userInfoList;
        } catch (SQLException e) {
            LOGGER.error("Can't find all users from DB.", e);
            throw new PersistentException(e);
        }
    }

    //TODO объединение user and userInfo
    @Override
    public Integer create(UserInfo userInfo) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(CREATE_USER_INFO,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, userInfo.getName());
            statement.setString(2, userInfo.getSurname());
            statement.setString(3, userInfo.getPatronymic());
            statement.setInt(4, userInfo.getPhone());
            statement.setDate(5, userInfo.getBirthDate());
            statement.setBlob(6, userInfo.getAvatar());
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
            throw new PersistentException(e);

        }
    }

    @Override
    public UserInfo read(Integer id) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(READ_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                UserInfo userInfo = null;
                if (resultSet.next()) {
                    userInfo = new UserInfo();
                    userInfo.setId(id);
                    userInfo.setLogin(resultSet.getString("login"));
                    userInfo.setPassword(resultSet.getString("password"));
                    userInfo.setRole(Role.getById(resultSet.getInt("role")));
                    userInfo.setName(resultSet.getString("name"));
                    userInfo.setSurname(resultSet.getString("surname"));
                    userInfo.setPatronymic(resultSet.getString("patronymic"));
                    userInfo.setGender(Gender.getById(resultSet.getInt(
                            "gender")));
                    userInfo.setPhone(resultSet.getInt("phone"));
                    userInfo.setBirthDate(resultSet.getDate("birth_date"));
                    userInfo.setAvatar(resultSet.getBlob("avatar"));
                }
                return userInfo;
            }
        } catch (SQLException e) {
            LOGGER.error("Can't find the user from DB by id.", e);
            throw new PersistentException(e);
        }
    }

    @Override
    public UserInfo read(String login, String password) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(READ_BY_PASSWORD_LOGIN)) {
            statement.setString(1, login);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                UserInfo userInfo = null;
                if (resultSet.next()) {
                    userInfo = new UserInfo();
                    userInfo.setId(resultSet.getInt("id"));
                    userInfo.setLogin(login);
                    userInfo.setPassword(password);
                    userInfo.setRole(Role.getById(resultSet.getInt("role")));
                    userInfo.setName(resultSet.getString("name"));
                    userInfo.setSurname(resultSet.getString("surname"));
                    userInfo.setPatronymic(resultSet.getString("patronymic"));
                    userInfo.setGender(Gender.getById(resultSet.getInt(
                            "gender")));
                    userInfo.setPhone(resultSet.getInt("phone"));
                    userInfo.setBirthDate(resultSet.getDate("birth_date"));
                    userInfo.setAvatar(resultSet.getBlob("avatar"));
                }
                return userInfo;
            }
        } catch (SQLException e) {
            throw new PersistentException(e);
        }
    }


    @Override
    public void update(UserInfo userInfo) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(UPDATE_USER_INFO)) {

            statement.setString(1, userInfo.getLogin());
            statement.setString(2, userInfo.getPassword());
            statement.setInt(3, userInfo.getRole().getId());
            statement.setString(4, userInfo.getName());
            statement.setString(5, userInfo.getSurname());
            statement.setString(6, userInfo.getPatronymic());
            statement.setInt(7, userInfo.getGender().getId());
            statement.setDate(8, userInfo.getBirthDate());
            statement.setInt(9, userInfo.getPhone());
            statement.setObject(10, userInfo.getAvatar());
            statement.setInt(11, userInfo.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new PersistentException(e);
        }

    }

    @Override
    public void delete(Integer id) throws PersistentException {
        try (PreparedStatement statement
                     = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistentException(e);
        }


    }
}

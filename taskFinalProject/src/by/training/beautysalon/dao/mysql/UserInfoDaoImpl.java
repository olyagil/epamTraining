package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.dao.UserInfoDao;
import by.training.beautysalon.domain.UserInfo;
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
    private static final String READ_ALL = "select `id`, `surname`, "
            + "`name`, `patronymic`, `phone`, `birth_date`,path_to_photo "
            + "from `users`"
            + "join user_info ui on users.id = ui.user_id";
    private static final String CREATE_USER_INFO = "insert into `user_info` " +
            "(`user_id`, `name`, `surname`, `patronymic`, `phone`, " +
            "`birth_date`, path_to_photo) "
            + "VALUES (?,?,?,?,?,?,?)";
    private static final String READ_BY_ID = "select  `name`, `surname`,`patronymic`, `phone`, "
            + "`birth_date`, path_to_photo " +
            "from `user_info` where `user_id`=?";
    private static final String UPDATE_USER_INFO = "update `user_info` set `name`=?, `surname`=?, " +
            "`patronymic`=?, `birth_date`=?, `phone`=? where `user_id`=?";
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
                userInfo.setId(resultSet.getInt("id"));
                userInfo.setSurname(resultSet.getString("surname"));
                userInfo.setName(resultSet.getString("name"));
                userInfo.setPatronymic(resultSet.getString("patronymic"));
                userInfo.setPhone(resultSet.getInt("phone"));
                userInfo.setBirthDate(resultSet.getDate("birth_date"));
                userInfoList.add(userInfo);
            }
            return userInfoList;
        } catch (SQLException e) {
            throw new PersistentException(e);
        }
    }

    @Override
    public Integer create(UserInfo userInfo) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(CREATE_USER_INFO,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, userInfo.getName());
            statement.setString(2, userInfo.getSurname());
            statement.setString(3, userInfo.getPatronymic());
            statement.setInt(4, userInfo.getPhone());
            statement.setDate(5, userInfo.getBirthDate());
//            statement.setObject(6, userInfo.getPhoto());
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
            throw new PersistentException();

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
                    userInfo.setName(resultSet.getString("name"));
                    userInfo.setSurname(resultSet.getString("surname"));
                    userInfo.setPatronymic(resultSet.getString("patronymic"));
                    userInfo.setPhone(resultSet.getInt("phone"));
                    userInfo.setBirthDate(resultSet.getDate("birth_date"));
//                    userInfo.setPhoto(resultSet.getObject("photo"));
                }
                return userInfo;
            }

        } catch (SQLException e) {
            LOGGER.error("Can't read the user from DB by id.");
            throw new PersistentException();
        }
    }

    @Override
    public void update(UserInfo userInfo) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(UPDATE_USER_INFO)) {
            statement.setString(1, userInfo.getName());
            statement.setString(2, userInfo.getSurname());
            statement.setString(3, userInfo.getPatronymic());
            statement.setDate(4, userInfo.getBirthDate());
            statement.setInt(5, userInfo.getPhone());
//            statement.setObject(6, userInfo.getPhoto());
            statement.setInt(6, userInfo.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new PersistentException(e);
        }

    }

    //TODO ?????????
    @Override
    public void delete(Integer id) throws PersistentException {
        String sql = DELETE_BY_ID;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistentException();
        }


    }
}

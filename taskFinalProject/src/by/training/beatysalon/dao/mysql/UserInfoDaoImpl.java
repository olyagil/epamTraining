package by.training.beatysalon.dao.mysql;

import by.training.beatysalon.dao.UserInfoDao;
import by.training.beatysalon.domain.UserInfo;
import by.training.beatysalon.domain.User;
import by.training.beatysalon.exception.PersistentException;
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


    @Override
    public User readById(Integer id) throws PersistentException {
        return null;
    }

    @Override
    public List<UserInfo> read() throws PersistentException {
        String sql = "select `id`, `surname`, "
                + "`name`, `patronymic`, `phone`, `birth_date`,`photo` "
                + "from `users`"
                + "join user_info ui on users.id = ui.user_id";
        List<UserInfo> userInfoList;
        try (PreparedStatement statement = connection.prepareStatement(sql);
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
        String sql = "insert into `user_info` " +
                "(`user_id`, `name`, `surname`, `patronymic`, `phone`, " +
                "`birth_date`, `photo`) "
                + "VALUES (?,?,?,?,?,?,?)";
//        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, userInfo.getName());
            statement.setString(2, userInfo.getSurname());
            statement.setString(3, userInfo.getPatronymic());
            statement.setInt(4, userInfo.getPhone());
            statement.setDate(5, userInfo.getBirthDate());
//            statement.setObject(1, userInfo.getPhoto());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
//            resultSet = statement.getGeneratedKeys();
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
        return null;
    }

    @Override
    public void update(UserInfo userInfo) throws PersistentException {

    }

    @Override
    public void delete(Integer id) throws PersistentException {

    }
}
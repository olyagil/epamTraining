package by.training.beautysalon.builder;

import by.training.beautysalon.dao.mysql.ImageUtill;
import by.training.beautysalon.domain.User;
import by.training.beautysalon.domain.enumeration.Gender;
import by.training.beautysalon.domain.enumeration.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder implements Builder<User> {

    @Override
    public User build(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        user.setLogin(resultSet.getString("login"));
        user.setRole(Role.getById(resultSet.getInt("role")));
        user.setSurname(resultSet.getString("surname"));
        user.setName(resultSet.getString("name"));
        user.setPatronymic(resultSet.getString("patronymic"));
        user.setGender(Gender.getById(resultSet.getInt("gender")));
        user.setPhone(resultSet.getInt("phone"));
        user.setBirthDate(resultSet.getDate("birth_date"));
        user.setAvatar(ImageUtill.encoder(resultSet.getBlob("avatar")));

        return user;
    }
}

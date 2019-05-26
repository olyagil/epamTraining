package by.training.beautysalon.dao;

import by.training.beautysalon.builder.Builder;
import by.training.beautysalon.builder.UserBuilder;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface UserDao extends Dao<User> {


    List<User> read(String login) throws PersistentException;

    User read(String login, String password) throws PersistentException;

    boolean updatePassword(User user) throws PersistentException;

    boolean updateAvatar(User user) throws PersistentException;

    default Builder<User> getBuilder() {
        return new UserBuilder();
    }
}

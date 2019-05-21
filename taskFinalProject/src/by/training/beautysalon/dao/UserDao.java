package by.training.beautysalon.dao;

import by.training.beautysalon.builder.Builder;
import by.training.beautysalon.builder.UserBuilder;
import by.training.beautysalon.domain.User;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface UserDao extends Dao<User> {

    int countRows(int role) throws PersistentException;

    List<User> read(String login) throws PersistentException;

    User read(String login, String password) throws PersistentException;

    void updatePassword(User user) throws PersistentException;

    void updateAvatar(User user) throws PersistentException;

    default Builder<User> getBuilder() {
        return new UserBuilder();
    }
}

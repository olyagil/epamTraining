package by.training.beatysalon.dao;

import by.training.beatysalon.domain.User;
import by.training.beatysalon.exception.PersistentException;

import java.util.List;

public interface UserDao extends Dao<User> {

    User read(String login, String password) throws PersistentException;

    List<User> read() throws PersistentException;
}

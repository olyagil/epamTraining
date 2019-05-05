package by.training.beautysalon.dao;

import by.training.beautysalon.domain.User;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

/**
 * Dao for client
 */
public interface UserDao extends Dao<User> {

    User read(String login, String password) throws PersistentException;

    List<User> read() throws PersistentException;

}

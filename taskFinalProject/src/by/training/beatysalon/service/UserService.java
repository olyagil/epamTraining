package by.training.beatysalon.service;

import by.training.beatysalon.domain.User;
import by.training.beatysalon.exception.PersistentException;

import java.util.List;

public interface UserService extends Service {

    List<User> findAll() throws PersistentException;

    User findById(Integer id) throws PersistentException;

    User findByLoginAndPassword(String login, String password)
            throws PersistentException;

    void save(User user) throws PersistentException;

    void delete(Integer id) throws PersistentException;
}

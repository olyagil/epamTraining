package by.training.beautysalon.service.impl;

import by.training.beautysalon.domain.User;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.impl.Service;

import java.util.List;

public interface UserService extends Service {

    List<User> findAll() throws PersistentException;

    User findById(Integer id) throws PersistentException;

    User findByLoginAndPassword(String login, String password)
            throws PersistentException;

    void save(User user) throws PersistentException;

    void delete(Integer id) throws PersistentException;
}

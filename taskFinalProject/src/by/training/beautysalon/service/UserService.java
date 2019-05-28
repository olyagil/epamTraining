package by.training.beautysalon.service;

import by.training.beautysalon.entity.User;
import by.training.beautysalon.exception.DataBaseException;

import java.util.List;

public interface UserService extends Service<User> {

    List<User> find(String login) throws DataBaseException;

    User find(String login, String password)
            throws DataBaseException;

}

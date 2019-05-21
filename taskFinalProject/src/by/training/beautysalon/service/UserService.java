package by.training.beautysalon.service;

import by.training.beautysalon.entity.User;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface UserService extends Service<User> {

    //    List<User> find(int currentPage,
//                      int  recordsPerPage) throws PersistentException;

    List<User> find(String login) throws PersistentException;

    User find(String login, String password)
            throws PersistentException;

}

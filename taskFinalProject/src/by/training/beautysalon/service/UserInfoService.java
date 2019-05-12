package by.training.beautysalon.service;

import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface UserInfoService extends Service {

    List<UserInfo> find() throws PersistentException;

    UserInfo find(Integer id) throws PersistentException;

    UserInfo find(String login, String password)
            throws PersistentException;

//    User findBySurname(String surname) throws PersistentException;

    void save(UserInfo userInfo) throws PersistentException;

    void delete(Integer id) throws PersistentException;
}

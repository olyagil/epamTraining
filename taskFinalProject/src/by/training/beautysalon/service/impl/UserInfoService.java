package by.training.beautysalon.service.impl;

import by.training.beautysalon.domain.User;
import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.impl.Service;

import java.util.List;

public interface UserInfoService extends Service {

    List<UserInfo> findAll() throws PersistentException;

    User findById(Integer id) throws PersistentException;

//    User findBySurname(String surname) throws PersistentException;

    void save(UserInfo userInfo) throws PersistentException;

    void delete(Integer id) throws PersistentException;
}

package by.training.beautysalon.service;

import by.training.beautysalon.dao.UserInfoDao;
import by.training.beautysalon.domain.User;
import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.impl.UserInfoService;

import java.util.List;

public class UserInfoServiceImpl extends ServiceImpl implements UserInfoService {
    @Override
    public List<UserInfo> findAll() throws PersistentException {
        UserInfoDao userInfoDao = transaction.createDao(UserInfoDao.class);
        return userInfoDao.read();
    }

    @Override
    public User findById(Integer id) throws PersistentException {
        UserInfoDao userInfoDao = transaction.createDao(UserInfoDao.class);
        return userInfoDao.read(id);
    }

//    @Override
//    public User findBySurname(String surname) throws PersistentException {
//        return null;
//    }

    @Override
    public void save(UserInfo userInfo) throws PersistentException {
        UserInfoDao userInfoDao = transaction.createDao(UserInfoDao.class);
        if (userInfo.getId() != null) {
            userInfoDao.update(userInfo);
        } else {
            userInfoDao.create(userInfo);
        }

    }

    @Override
    public void delete(Integer id) throws PersistentException {
        UserInfoDao userInfoDao = transaction.createDao(UserInfoDao.class);
        userInfoDao.delete(id);
    }
}

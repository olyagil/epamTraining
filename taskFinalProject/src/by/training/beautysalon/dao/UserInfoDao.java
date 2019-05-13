package by.training.beautysalon.dao;

import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface UserInfoDao extends Dao<UserInfo> {

    List<UserInfo> read() throws PersistentException;

    UserInfo read(Integer id) throws PersistentException;

    UserInfo read(String login, String password) throws PersistentException;

//    List<UserInfo> find(String search) throws PersistentException;

}

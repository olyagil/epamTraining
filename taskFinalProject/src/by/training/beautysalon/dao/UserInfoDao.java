package by.training.beautysalon.dao;

import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface UserInfoDao extends Dao<UserInfo>{

//    User readById(Integer id) throws PersistentException;

    List<UserInfo> read() throws PersistentException;

//    List<UserInfo> read(String search) throws PersistentException;

}

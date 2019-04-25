package by.training.beatysalon.dao;

import by.training.beatysalon.domain.UserInfo;
import by.training.beatysalon.domain.User;
import by.training.beatysalon.exception.PersistentException;

import java.util.List;

public interface UserInfoDao extends Dao<UserInfo>{

    User readById(Integer id) throws PersistentException;

    List<UserInfo> read() throws PersistentException;

//    List<UserInfo> read(String search) throws PersistentException;

}

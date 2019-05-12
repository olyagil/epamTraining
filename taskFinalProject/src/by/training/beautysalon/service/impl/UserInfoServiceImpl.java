package by.training.beautysalon.service.impl;

import by.training.beautysalon.dao.UserInfoDao;
import by.training.beautysalon.domain.Service;
import by.training.beautysalon.domain.User;
import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.List;

public class UserInfoServiceImpl extends ServiceImpl implements UserInfoService {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<UserInfo> find() throws PersistentException {

        UserInfoDao userInfoDao = transaction.createDao(UserInfoDao.class);
        return userInfoDao.read();
    }

    @Override
    public UserInfo find(Integer id) throws PersistentException {
        UserInfoDao userInfoDao = transaction.createDao(UserInfoDao.class);
        return userInfoDao.read(id);
    }

    @Override
    public UserInfo find(String login, String password) throws PersistentException {
        UserInfoDao userDao = transaction.createDao(UserInfoDao.class);
        return userDao.read(login, md5(password));
    }

    @Override
    public void save(UserInfo userInfo) throws PersistentException {
        UserInfoDao userInfoDao = transaction.createDao(UserInfoDao.class);
        if (userInfo.getId() != null) {
            if (userInfo.getPassword() != null) {
                userInfo.setPassword(md5(userInfo.getPassword()));

            } else {
                User oldUser = userInfoDao.read(userInfo.getId());
                userInfo.setPassword(oldUser.getPassword());
            }

            userInfoDao.update(userInfo);
            LOGGER.debug("Update user");
        } else {
            userInfo.setPassword(md5(new String()));
            LOGGER.debug("Create  user");
            userInfo.setId(userInfoDao.create(userInfo));
            LOGGER.debug("Created user");
        }
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        UserInfoDao userInfoDao = transaction.createDao(UserInfoDao.class);
        userInfoDao.delete(id);
    }

    private String md5(String password) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("md5");
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            byte[] hash = messageDigest.digest();
            Formatter formatter = new Formatter();
            for (int i = 0; i < hash.length; i++) {
                formatter.format("%02X", hash[i]);
            }
            String m5sum = formatter.toString();
            formatter.close();
            return m5sum;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}

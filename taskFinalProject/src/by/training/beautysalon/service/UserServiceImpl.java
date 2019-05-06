package by.training.beautysalon.service;

import by.training.beautysalon.dao.UserDao;
import by.training.beautysalon.domain.User;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.impl.UserService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.List;

public class UserServiceImpl extends ServiceImpl implements UserService {
    @Override
    public List<User> findAll() throws PersistentException {
        UserDao userDao = transaction.createDao(UserDao.class);
        return userDao.read();
    }

    @Override
    public User findById(Integer id) throws PersistentException {
        UserDao userDao = transaction.createDao(UserDao.class);
        return userDao.read(id);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) throws PersistentException {
        UserDao userDao = transaction.createDao(UserDao.class);
        return userDao.read(login, md5(password));
    }

    @Override
    public void save(User user) throws PersistentException {
        UserDao userDao = transaction.createDao(UserDao.class);
        if (user.getId() != null) {
            if (user.getPassword() != null) {
                user.setPassword(md5(user.getPassword()));
            } else {
                User oldUser = userDao.read(user.getId());
                user.setPassword(oldUser.getPassword());
            }
            userDao.update(user);
        } else {
            user.setPassword(md5(new String()));
            user.setId(userDao.create(user));
        }

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

    @Override
    public void delete(Integer id) throws PersistentException {
        UserDao userDao = transaction.createDao(UserDao.class);
        userDao.delete(id);
    }
}

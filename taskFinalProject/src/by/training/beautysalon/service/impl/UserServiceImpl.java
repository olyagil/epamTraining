package by.training.beautysalon.service.impl;

import by.training.beautysalon.dao.UserDao;
import by.training.beautysalon.dao.mysql.DaoFactory;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int countRows() throws PersistentException {
        UserDao dao = DaoFactory.getInstance().getUserDao();
        return dao.countRows();
    }

    @Override
    public List<User> find() throws PersistentException {
        UserDao dao = DaoFactory.getInstance().getUserDao();
        return dao.read();
    }

    public List<User> find(int currentPage, int recordsPerPage)
            throws PersistentException {
        UserDao dao = DaoFactory.getInstance().getUserDao();
        return dao.read(currentPage, recordsPerPage);
    }

    @Override
    public List<User> find(String login) throws PersistentException {
        UserDao dao = DaoFactory.getInstance().getUserDao();
        return dao.read(login);
    }

    @Override
    public User find(Integer id) throws PersistentException {
        UserDao dao = DaoFactory.getInstance().getUserDao();
        return dao.read(id);
    }

    @Override
    public User find(String login, String password) throws PersistentException {
        UserDao dao = DaoFactory.getInstance().getUserDao();
        return dao.read(login, md5(password));
    }

    @Override
    public Integer save(User user) throws PersistentException {
        UserDao dao = DaoFactory.getInstance().getUserDao();

        if (user.getId() != null) {
            if (user.getPassword() != null) {
                user.setPassword(md5(user.getPassword()));
                dao.updatePassword(user);
                LOGGER.debug("Update password for user");
            } else if (user.getAvatar() != null) {
                dao.updateAvatar(user);
            } else {
                dao.update(user);
                LOGGER.debug("Update info about user");
            }
        } else {
            user.setPassword(md5(user.getPassword()));
            user.setId(dao.create(user));
            LOGGER.debug("Create user info");
        }
        return user.getId();

    }

    @Override
    public void delete(Integer id) throws PersistentException {
        UserDao dao = DaoFactory.getInstance().getUserDao();
        dao.delete(id);

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

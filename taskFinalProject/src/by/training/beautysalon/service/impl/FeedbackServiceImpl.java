package by.training.beautysalon.service.impl;

import by.training.beautysalon.dao.FeedbackDao;
import by.training.beautysalon.dao.mysql.FeedbackDaoImpl;
import by.training.beautysalon.domain.Feedback;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.FeedbackService;

import java.sql.Date;
import java.util.List;

public class FeedbackServiceImpl extends ServiceImpl implements FeedbackService {
    @Override
    public List<Feedback> findBySpecialistId(Integer id) throws PersistentException {
        FeedbackDao dao = transaction.createDao(FeedbackDaoImpl.class);
        return dao.readBySpecialist(id);
    }

    @Override
    public List<Feedback> find(Date date) throws PersistentException {
        FeedbackDao feedbackDao =
                transaction.createDao(FeedbackDao.class);
        return feedbackDao.read(date);
    }

    @Override
    public List<Feedback> find() throws PersistentException {
        FeedbackDao dao = transaction.createDao(FeedbackDao.class);
        return dao.read();
    }

    @Override
    public void save(Feedback feedback) throws PersistentException {
        FeedbackDao feedbackDao = transaction.createDao(FeedbackDao.class);
        feedbackDao.create(feedback);
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        FeedbackDao feedbackDao = transaction.createDao(FeedbackDao.class);
        feedbackDao.delete(id);
    }
}

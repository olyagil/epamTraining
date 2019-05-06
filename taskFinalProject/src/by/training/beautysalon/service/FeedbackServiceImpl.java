package by.training.beautysalon.service;

import by.training.beautysalon.dao.mysql.FeedbackDaoImpl;
import by.training.beautysalon.domain.Feedback;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.impl.FeedbackService;

import java.sql.Date;
import java.util.List;

public class FeedbackServiceImpl extends ServiceImpl implements FeedbackService {
    @Override
    public List<Feedback> findBySpecialistId(Integer id) throws PersistentException {
        FeedbackDaoImpl feedbackDao =
                transaction.createDao(FeedbackDaoImpl.class);
        return feedbackDao.readBySpecialist(id);
    }

    @Override
    public List<Feedback> findByDate(Date date) throws PersistentException {
        FeedbackDaoImpl feedbackDao =
                transaction.createDao(FeedbackDaoImpl.class);
        return feedbackDao.readByDate(date);
    }

    @Override
    public void save(Feedback feedback) throws PersistentException {
        FeedbackDaoImpl feedbackDao = transaction.createDao(FeedbackDaoImpl.class);
        feedbackDao.create(feedback);
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        FeedbackDaoImpl feedbackDao = transaction.createDao(FeedbackDaoImpl.class);
        feedbackDao.delete(id);
    }
}

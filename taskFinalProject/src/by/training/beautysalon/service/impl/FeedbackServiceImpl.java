package by.training.beautysalon.service.impl;

import by.training.beautysalon.dao.FeedbackDao;
import by.training.beautysalon.dao.mysql.DaoFactory;
import by.training.beautysalon.entity.Feedback;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.FeedbackService;

import java.sql.Date;
import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    @Override
    public int countRows() throws PersistentException {
        FeedbackDao dao = DaoFactory.getInstance().getFeedbackDao();
        return dao.countRows();
    }

    @Override
    public List<Feedback> find(int currentPage, int recordsPerPage) throws PersistentException {
        FeedbackDao dao = DaoFactory.getInstance().getFeedbackDao();
        return dao.read(currentPage, recordsPerPage);
    }

    @Override
    public List<Feedback> findBySpecialistId(Integer id) throws PersistentException {
        FeedbackDao dao = DaoFactory.getInstance().getFeedbackDao();
        return dao.readByEmployee(id);
    }

    @Override
    public List<Feedback> find(Date date) throws PersistentException {
        FeedbackDao dao = DaoFactory.getInstance().getFeedbackDao();
        return dao.read(date);
    }

    @Override
    public List<Feedback> findByClientId(Integer clientId) throws PersistentException {
        FeedbackDao dao = DaoFactory.getInstance().getFeedbackDao();
        return dao.readByClientId(clientId);
    }


    @Override
    public List<Feedback> find() throws PersistentException {
        FeedbackDao dao = DaoFactory.getInstance().getFeedbackDao();
        return dao.read();
    }

    @Override
    public Feedback find(Integer id) throws PersistentException {
        FeedbackDao dao = DaoFactory.getInstance().getFeedbackDao();
        return dao.read(id);
    }

    @Override
    public Integer save(Feedback feedback) throws PersistentException {
        FeedbackDao dao = DaoFactory.getInstance().getFeedbackDao();
        return dao.create(feedback);

    }

    @Override
    public void delete(Integer id) throws PersistentException {
        FeedbackDao dao = DaoFactory.getInstance().getFeedbackDao();
        dao.delete(id);
    }
}

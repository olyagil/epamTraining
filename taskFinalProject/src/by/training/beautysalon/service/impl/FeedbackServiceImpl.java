package by.training.beautysalon.service.impl;

import by.training.beautysalon.dao.FeedbackDao;
import by.training.beautysalon.entity.Feedback;
import by.training.beautysalon.exception.DataBaseException;
import by.training.beautysalon.service.FeedbackService;

import java.sql.Date;
import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackDao dao;

    public FeedbackServiceImpl(FeedbackDao feedbackDao) {
        this.dao = feedbackDao;
    }

    @Override
    public int countRows() throws DataBaseException {
        return dao.countRows();
    }

    @Override
    public List<Feedback> find(int currentPage, int recordsPerPage) throws DataBaseException {
        return dao.read(currentPage, recordsPerPage);
    }

    @Override
    public List<Feedback> findBySpecialistId(Integer id) throws DataBaseException {
        return dao.readByEmployee(id);
    }

    @Override
    public List<Feedback> find(Date date) throws DataBaseException {
        return dao.read(date);
    }

    @Override
    public List<Feedback> findByClientId(Integer clientId) throws DataBaseException {
        return dao.readByClientId(clientId);
    }


    @Override
    public List<Feedback> find() throws DataBaseException {
        return dao.read();
    }

    @Override
    public Feedback find(Integer id) throws DataBaseException {
        return dao.read(id);
    }

    @Override
    public Integer save(Feedback feedback) throws DataBaseException {
        return dao.create(feedback);

    }

    @Override
    public boolean delete(Integer id) throws DataBaseException {
        return dao.delete(id);
    }
}

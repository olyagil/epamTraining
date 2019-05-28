package by.training.beautysalon.service;

import by.training.beautysalon.entity.Feedback;
import by.training.beautysalon.exception.DataBaseException;

import java.sql.Date;
import java.util.List;

public interface FeedbackService extends Service<Feedback> {

    List<Feedback> findBySpecialistId(Integer id) throws DataBaseException;

    List<Feedback> find(Date date) throws DataBaseException;

    List<Feedback> findByClientId(Integer clientId) throws DataBaseException;


}

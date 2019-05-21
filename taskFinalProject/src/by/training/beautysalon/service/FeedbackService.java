package by.training.beautysalon.service;

import by.training.beautysalon.entity.Feedback;
import by.training.beautysalon.exception.PersistentException;

import java.sql.Date;
import java.util.List;

public interface FeedbackService extends Service<Feedback> {

    List<Feedback> findBySpecialistId(Integer id) throws PersistentException;

    List<Feedback> find(Date date) throws PersistentException;

    List<Feedback> findByClientId(Integer clientId) throws PersistentException;


}

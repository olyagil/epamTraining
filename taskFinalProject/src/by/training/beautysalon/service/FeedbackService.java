package by.training.beautysalon.service;

import by.training.beautysalon.domain.Feedback;
import by.training.beautysalon.exception.PersistentException;

import java.sql.Date;
import java.util.List;

public interface FeedbackService extends Service {

    List<Feedback> findBySpecialistId(Integer id) throws PersistentException;

    List<Feedback> find(Date date) throws PersistentException;

    //   Feedback findByClientId(Integer clientId) throws PersistentException;
    List<Feedback> find() throws PersistentException;

    void save(Feedback feedback) throws PersistentException;

    void delete(Integer id) throws PersistentException;
}

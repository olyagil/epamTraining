package by.training.beautysalon.service.impl;

import by.training.beautysalon.domain.Feedback;
import by.training.beautysalon.domain.User;
import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.exception.PersistentException;

import java.sql.Date;
import java.util.List;

public interface FeedbackService extends Service {

    List<Feedback> findBySpecialistId(Integer id) throws PersistentException;

    List<Feedback> findByDate(Date date) throws PersistentException;

//   Feedback findByClientId(Integer clientId) throws PersistentException;

    void save(Feedback feedback) throws PersistentException;

    void delete(Integer id) throws PersistentException;
}

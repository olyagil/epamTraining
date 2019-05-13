package by.training.beautysalon.dao;

import by.training.beautysalon.domain.Feedback;
import by.training.beautysalon.exception.PersistentException;

import java.sql.Date;
import java.util.List;

public interface FeedbackDao extends Dao<Feedback> {

    List<Feedback> readByClientId(Integer id) throws PersistentException;
    List<Feedback> readBySpecialist(Integer specialistId) throws PersistentException;
    List<Feedback> read(Date date) throws PersistentException;
    List<Feedback> read() throws PersistentException;
}

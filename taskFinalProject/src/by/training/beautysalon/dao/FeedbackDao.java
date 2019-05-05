package by.training.beautysalon.dao;

import by.training.beautysalon.domain.Feedback;
import by.training.beautysalon.exception.PersistentException;

import java.sql.Date;
import java.util.List;

public interface FeedbackDao extends Dao<Feedback> {

    List<Feedback> readBySpecialist(Integer specialistId) throws PersistentException;

    List<Feedback> readByDate(Date date) throws PersistentException;
}

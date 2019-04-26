package by.training.beatysalon.dao;

import by.training.beatysalon.domain.Feedback;
import by.training.beatysalon.exception.PersistentException;

import java.sql.Date;
import java.util.List;

public interface FeedbackDao extends Dao<Feedback> {

    List<Feedback> readBySpecialist(Integer specialistId) throws PersistentException;

    List<Feedback> readByDate(Date date) throws PersistentException;
}

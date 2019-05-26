package by.training.beautysalon.dao;

import by.training.beautysalon.builder.Builder;
import by.training.beautysalon.builder.FeedbackBuilder;
import by.training.beautysalon.entity.Feedback;
import by.training.beautysalon.exception.PersistentException;

import java.sql.Date;
import java.util.List;

public interface FeedbackDao extends Dao<Feedback> {

    List<Feedback> readByClientId(Integer id) throws PersistentException;

    List<Feedback> readByEmployee(Integer specialistId) throws PersistentException;

    List<Feedback> read(Date date) throws PersistentException;

    default Builder<Feedback> getBuilder() {
        return new FeedbackBuilder();
    }
}

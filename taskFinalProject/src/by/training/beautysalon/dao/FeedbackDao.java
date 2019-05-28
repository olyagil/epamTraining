package by.training.beautysalon.dao;

import by.training.beautysalon.builder.Builder;
import by.training.beautysalon.builder.FeedbackBuilder;
import by.training.beautysalon.entity.Feedback;
import by.training.beautysalon.exception.DataBaseException;

import java.sql.Date;
import java.util.List;

public interface FeedbackDao extends Dao<Feedback> {

    List<Feedback> readByClientId(Integer id) throws DataBaseException;

    List<Feedback> readByEmployee(Integer specialistId) throws DataBaseException;

    List<Feedback> read(Date date) throws DataBaseException;

    default Builder<Feedback> getBuilder() {
        return new FeedbackBuilder();
    }
}

package by.training.beautysalon.service;

import by.training.beautysalon.entity.Talon;
import by.training.beautysalon.exception.DataBaseException;

import java.sql.Date;
import java.util.List;

public interface TalonService extends Service<Talon> {

    List<Talon> findByClient(Integer clientId) throws DataBaseException;

    List<Talon> findByEmployee(Integer specialistId) throws DataBaseException;

    List<Talon> find(Date date) throws DataBaseException;

    List<Talon> find(Boolean status) throws DataBaseException;

}

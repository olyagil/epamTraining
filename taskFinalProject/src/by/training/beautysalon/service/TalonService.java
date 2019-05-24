package by.training.beautysalon.service;

import by.training.beautysalon.entity.Talon;
import by.training.beautysalon.exception.PersistentException;

import java.sql.Date;
import java.util.List;

public interface TalonService extends Service<Talon> {

    List<Talon> findByClient(Integer clientId) throws PersistentException;

    List<Talon> findByEmployee(Integer specialistId) throws PersistentException;

    List<Talon> find(Date date) throws PersistentException;

    List<Talon> find(Boolean status) throws PersistentException;

}

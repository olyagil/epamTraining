package by.training.beautysalon.dao;

import by.training.beautysalon.domain.Bill;
import by.training.beautysalon.domain.Talon;
import by.training.beautysalon.exception.PersistentException;

import java.sql.Date;
import java.util.List;

public interface TalonDao extends Dao<Talon> {
    List<Talon> readByClient(Integer clientId) throws PersistentException;

    List<Talon> readBySpecialist(Integer specialistId) throws PersistentException;

    List<Talon> readByService(Integer serviceId) throws PersistentException;

    List<Talon> read(Date date) throws PersistentException;

    List<Talon> read();

}

package by.training.beatysalon.dao;

import by.training.beatysalon.domain.Talon;
import by.training.beatysalon.exception.PersistentException;

import java.util.List;

public interface TalonDao extends Dao<Talon> {

    List<Talon> readBySpecialist(Integer specialistId) throws PersistentException;

    List<Talon> readByService(Integer serviceId) throws PersistentException;

    List<Talon> readByReceptionDate() throws PersistentException;
}

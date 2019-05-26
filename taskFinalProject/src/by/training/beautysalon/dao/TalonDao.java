package by.training.beautysalon.dao;

import by.training.beautysalon.builder.Builder;
import by.training.beautysalon.builder.TalonBuilder;
import by.training.beautysalon.entity.Talon;
import by.training.beautysalon.exception.PersistentException;

import java.sql.Date;
import java.util.List;

public interface TalonDao extends Dao<Talon> {
    List<Talon> readByClient(Integer clientId) throws PersistentException;

    List<Talon> readByEmployee(Integer specialistId) throws PersistentException;

    List<Talon> read(Boolean status) throws PersistentException;

    List<Talon> read(Date date) throws PersistentException;

    default Builder<Talon> getBuilder() {
        return new TalonBuilder();
    }

}

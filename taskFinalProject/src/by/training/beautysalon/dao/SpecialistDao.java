package by.training.beautysalon.dao;

import by.training.beautysalon.domain.Specialist;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface SpecialistDao extends Dao<Specialist> {

    List<Specialist> read() throws PersistentException;

}

package by.training.beatysalon.dao;

import by.training.beatysalon.domain.Specialist;
import by.training.beatysalon.exception.PersistentException;

import java.util.List;
import java.util.Map;

public interface SpecialistDao extends Dao<Specialist> {

    List<Specialist> read() throws PersistentException;

    Map<Specialist, Integer> readWithNamOfServices() throws PersistentException;
}

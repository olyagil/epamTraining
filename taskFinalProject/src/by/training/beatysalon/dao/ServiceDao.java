package by.training.beatysalon.dao;

import by.training.beatysalon.domain.Doctor;
import by.training.beatysalon.domain.Service;
import by.training.beatysalon.exception.PersistentException;

import java.util.List;

public interface ServiceDao extends Dao<Service> {

    Service readByName(String name) throws PersistentException;

    List<Doctor> readByDoctor(Integer doctorId) throws PersistentException;

}

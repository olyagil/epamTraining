package by.training.beatysalon.dao;

import by.training.beatysalon.domain.Doctor;
import by.training.beatysalon.exception.PersistentException;

import javax.print.Doc;
import java.util.List;
import java.util.Map;

public interface DoctorDao extends Dao<Doctor> {

    List<Doctor> read() throws PersistentException;

    Map<Doctor, Integer> readWithNamOfServices() throws PersistentException;
}

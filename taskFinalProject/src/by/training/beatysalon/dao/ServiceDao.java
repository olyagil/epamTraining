package by.training.beatysalon.dao;

import by.training.beatysalon.domain.Specialist;
import by.training.beatysalon.domain.Service;
import by.training.beatysalon.exception.PersistentException;

import java.util.List;

public interface ServiceDao extends Dao<Service> {

    Service readByName(String name) throws PersistentException;

//    List<Service> readBySpecialist(Integer specialistId) throws PersistentException;

    List<Service> readByPrice(double startPrice, double endPrice)
            throws PersistentException;

}

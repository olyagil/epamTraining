package by.training.beautysalon.dao;

import by.training.beautysalon.domain.Service;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface ServiceDao extends Dao<Service> {

    List<Service> readByName(String name) throws PersistentException;

//    List<Service> readBySpecialist(Integer specialistId) throws PersistentException;

    List<Service> readByPrice(double startPrice, double endPrice)
            throws PersistentException;

}

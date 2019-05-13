package by.training.beautysalon.dao;

import by.training.beautysalon.domain.Service;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface ServiceDao extends Dao<Service> {

    List<Service> read(String name) throws PersistentException;

    List<Service> read() throws PersistentException;
//    List<Transaction> readBySpecialist(Integer specialistId) throws PersistentException;

    List<Service> read(double startPrice, double endPrice)
            throws PersistentException;

}

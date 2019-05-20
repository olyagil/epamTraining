package by.training.beautysalon.service;

import by.training.beautysalon.domain.Service;
import by.training.beautysalon.exception.PersistentException;

import java.sql.Date;
import java.util.List;

public interface ServiceService extends by.training.beautysalon.service.Service {
    int getNumberOfRows() throws PersistentException;

    List<Service> find() throws PersistentException;

    List<Service> find(int currentPage, int recordsPerPage) throws PersistentException;

    Service find(Integer id) throws PersistentException;

    List<Service> find(String name) throws PersistentException;

//    List<Service> find(double startPrice, double endPrice) throws PersistentException;

//   Feedback findByClientId(Integer clientId) throws PersistentException;
//    List<Service> findByDate(Date date) throws PersistentException;

    void save(Service service) throws PersistentException;

    void delete(Integer id) throws PersistentException;
}

package by.training.beautysalon.dao;

import by.training.beautysalon.domain.Service;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface ServiceDao extends Dao<Service> {
    int getNumberOfRows() throws PersistentException;

    List<Service> read(String name) throws PersistentException;

    List<Service> read(int currentPage, int recordsPerPage) throws PersistentException;


    List<Service> read() throws PersistentException;

//    List<Service> read(double startPrice, double endPrice)
//            throws PersistentException;

}

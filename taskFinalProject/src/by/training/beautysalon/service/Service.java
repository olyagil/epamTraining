package by.training.beautysalon.service;

import by.training.beautysalon.entity.Entity;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface Service<Type extends Entity> {
    int countRows() throws PersistentException;
    List<Type> find(int currentPage, int recordsPerPage) throws PersistentException;

    List<Type> find() throws PersistentException;

    Type find(Integer id) throws PersistentException;

    Integer save(Type entity) throws PersistentException;

    void delete(Integer id) throws PersistentException;


}

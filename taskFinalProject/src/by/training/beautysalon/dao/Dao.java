package by.training.beautysalon.dao;

import by.training.beautysalon.builder.Builder;
import by.training.beautysalon.entity.Employee;
import by.training.beautysalon.entity.Entity;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface Dao<Type extends Entity> {
    //    Optional<Type> read(Integer id) throws PersistentException;
    int countRows() throws PersistentException;
    List<Type> read(int currentPage, int recordsPerPage) throws PersistentException;

    List<Type> read() throws PersistentException;

    Integer create(Type entity) throws PersistentException;

    Type read(Integer id) throws PersistentException;

    boolean update(Type entity) throws PersistentException;

    boolean delete(Integer id) throws PersistentException;

    Builder<Type> getBuilder();
}

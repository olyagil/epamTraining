package by.training.beautysalon.dao;

import by.training.beautysalon.builder.Builder;
import by.training.beautysalon.entity.Entity;
import by.training.beautysalon.exception.DataBaseException;

import java.util.List;

public interface Dao<Type extends Entity> {
    int countRows() throws DataBaseException;

    List<Type> read(int currentPage, int recordsPerPage) throws DataBaseException;

    List<Type> read() throws DataBaseException;

    Integer create(Type entity) throws DataBaseException;

    Type read(Integer id) throws DataBaseException;

    boolean update(Type entity) throws DataBaseException;

    boolean delete(Integer id) throws DataBaseException;

    Builder<Type> getBuilder();
}

package by.training.beautysalon.dao;

import by.training.beautysalon.domain.Entity;
import by.training.beautysalon.exception.PersistentException;

public interface Dao<Type extends Entity> {

    Integer create(Type entity) throws PersistentException;

    Type read(Integer id) throws PersistentException;

    void update(Type entity) throws PersistentException;

    void delete(Integer id) throws PersistentException;
}

package by.training.beatysalon.dao;

import by.training.beatysalon.domain.Entity;
import by.training.beatysalon.exception.PersistentException;

public interface Dao<Type extends Entity> {

    Integer create(Type entity) throws PersistentException;

    Type read(Integer id) throws PersistentException;

    void update(Type entity) throws PersistentException;

    void delete(Integer id) throws PersistentException;
}

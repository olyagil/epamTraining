package by.training.beautysalon.service;

import by.training.beautysalon.entity.Entity;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface Service<Type extends Entity> {

    List<Type> find() throws PersistentException;

    Type find(Integer id) throws PersistentException;

    void save(Type entity) throws PersistentException;

    void delete(Integer id) throws PersistentException;


}

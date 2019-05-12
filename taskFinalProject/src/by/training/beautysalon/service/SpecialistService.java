package by.training.beautysalon.service;

import by.training.beautysalon.domain.Specialist;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface SpecialistService extends Service {


    List<Specialist> find() throws PersistentException;

    Specialist find(Integer id) throws PersistentException;

//    Specialist find(String login, String password)
//            throws PersistentException;

//    User findBySpecialty(String surname) throws PersistentException;

    void save(Specialist specialist) throws PersistentException;

    void delete(Integer id) throws PersistentException;
}

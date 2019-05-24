package by.training.beautysalon.service;

import by.training.beautysalon.entity.Service;
import by.training.beautysalon.exception.PersistentException;

import java.sql.Date;
import java.util.List;

public interface ServiceService extends by.training.beautysalon.service.Service<Service> {

    List<Service> find(String name) throws PersistentException;

    List<Service> find(Date date) throws PersistentException;

}

package by.training.beautysalon.dao;

import by.training.beautysalon.builder.Builder;
import by.training.beautysalon.builder.ServiceBuilder;
import by.training.beautysalon.entity.Service;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface ServiceDao extends Dao<Service> {

    List<Service> read(String name) throws PersistentException;


    List<Service> read() throws PersistentException;

    default Builder<Service> getBuilder() {
        return new ServiceBuilder();
    }
}

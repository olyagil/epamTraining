package by.training.beautysalon.dao;

import by.training.beautysalon.builder.Builder;
import by.training.beautysalon.builder.ServiceBuilder;
import by.training.beautysalon.entity.Service;
import by.training.beautysalon.exception.DataBaseException;

import java.util.List;

public interface ServiceDao extends Dao<Service> {

    List<Service> read(String name) throws DataBaseException;


    List<Service> read() throws DataBaseException;

    default Builder<Service> getBuilder() {
        return new ServiceBuilder();
    }
}

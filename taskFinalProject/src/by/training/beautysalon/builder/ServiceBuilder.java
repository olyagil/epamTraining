package by.training.beautysalon.builder;

import by.training.beautysalon.domain.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceBuilder implements Builder<Service> {
    @Override
    public Service build(ResultSet resultSet) throws SQLException {
        Service service = new Service();
        service.setId(resultSet.getInt("id"));
        service.setName(resultSet.getString("name"));
        service.setDescription(resultSet.getString("description"));
        service.setPrice(resultSet.getDouble("price"));
        service.setDuration(resultSet.getDouble("duration"));

        return service;

    }
}

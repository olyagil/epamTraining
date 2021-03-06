package by.training.beautysalon.dao;

import by.training.beautysalon.builder.Builder;
import by.training.beautysalon.builder.EmployeeBuilder;
import by.training.beautysalon.entity.Employee;
import by.training.beautysalon.exception.DataBaseException;

import java.util.List;

public interface EmployeeDao extends Dao<Employee> {

    List<Employee> read(String login) throws DataBaseException;

    default Builder<Employee> getBuilder() {
        return new EmployeeBuilder();
    }
}

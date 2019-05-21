package by.training.beautysalon.dao;

import by.training.beautysalon.builder.Builder;
import by.training.beautysalon.builder.EmployeeBuilder;
import by.training.beautysalon.domain.Employee;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface EmployeeDao extends Dao<Employee> {

    List<Employee> read() throws PersistentException;

    List<Employee> read(String login) throws PersistentException;

    default Builder<Employee> getBuilder() {
        return new EmployeeBuilder();
    }
}

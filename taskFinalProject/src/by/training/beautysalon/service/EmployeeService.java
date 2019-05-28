package by.training.beautysalon.service;

import by.training.beautysalon.entity.Employee;
import by.training.beautysalon.exception.DataBaseException;

import java.util.List;

public interface EmployeeService extends Service<Employee> {

    List<Employee> find(String login) throws DataBaseException;


}

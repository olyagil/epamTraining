package by.training.beautysalon.service.impl;

import by.training.beautysalon.dao.EmployeeDao;
import by.training.beautysalon.dao.mysql.DaoFactory;
import by.training.beautysalon.entity.Employee;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> find() throws PersistentException {
        EmployeeDao dao = DaoFactory.getInstance().getEmployeeDao();
        return dao.read();
    }

    @Override
    public List<Employee> find(String login) throws PersistentException {
        EmployeeDao dao = DaoFactory.getInstance().getEmployeeDao();
        return dao.read(login);
    }

    @Override
    public Employee find(Integer id) throws PersistentException {
        EmployeeDao dao = DaoFactory.getInstance().getEmployeeDao();
        return dao.read(id);
    }

    @Override
    public void save(Employee employee) throws PersistentException {
        EmployeeDao dao = DaoFactory.getInstance().getEmployeeDao();
        if (employee.getId() != null) {
            dao.update(employee);
        } else {
            dao.create(employee);
        }
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        EmployeeDao dao = DaoFactory.getInstance().getEmployeeDao();
        dao.delete(id);
    }
}

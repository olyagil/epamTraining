package by.training.beautysalon.service.impl;

import by.training.beautysalon.dao.EmployeeDao;
import by.training.beautysalon.dao.mysql.DaoFactory;
import by.training.beautysalon.entity.Employee;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public int countRows() throws PersistentException {
        EmployeeDao dao = DaoFactory.getInstance().getEmployeeDao();
        return dao.countRows();
    }

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
    public List<Employee> find(int currentPage, int recordsPerPage) throws PersistentException {
        EmployeeDao dao = DaoFactory.getInstance().getEmployeeDao();
        return dao.read(currentPage, recordsPerPage);
    }

    @Override
    public Employee find(Integer id) throws PersistentException {
        EmployeeDao dao = DaoFactory.getInstance().getEmployeeDao();
        return dao.read(id);
    }

    @Override
    public Integer save(Employee employee) throws PersistentException {
        EmployeeDao dao = DaoFactory.getInstance().getEmployeeDao();
        if (employee.getLogin() != null) {
            dao.create(employee);
        } else {
            dao.update(employee);
        }
        return employee.getId();
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        EmployeeDao dao = DaoFactory.getInstance().getEmployeeDao();
        dao.delete(id);
    }
}

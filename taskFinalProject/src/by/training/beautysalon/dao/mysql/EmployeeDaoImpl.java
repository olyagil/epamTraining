package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.dao.EmployeeDao;
import by.training.beautysalon.domain.Employee;
import by.training.beautysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl extends BaseDaoImpl implements EmployeeDao {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String UPDATE_EMPLOYEE_BY_ID = "update employees "
            + "set `cabinet_number`=?, `salary`=?, `employment_date`=?, "
            + "`specialty`=? where user_info_id=?";
    private static final String INSERT_EMPLOYEE = "insert into employees "
            + "(user_info_id, `cabinet_number`, `salary`, `employment_date`, "
            + "`specialty`) values (?,?,?,?,?)";
    private static final String SELECT_ALL = "select `user_id`, `login`,"
            + "`role`, `name`,  `surname`,  `patronymic`, `gender`, "
            + "`phone`, `birth_date`, `avatar`, `cabinet_number`, `salary`, "
            + "`employment_date`, `specialty`"
            + "from employees "
            + "join user_info ui on employees.user_info_id = ui.user_id "
            + "join users users on employees.user_info_id = users.`id` "
            + "order by users.`id`";

    private static final String SELECT_BY_LOGIN = "select `user_id`, `login`, "
            + "`role`, `name`,  `surname`,  `patronymic`, `gender`, `phone`, "
            + "`birth_date`, `avatar`, `cabinet_number`, `salary`, "
            + "`employment_date`, `specialty`"
            + "from employees "
            + "join user_info ui on employees.user_info_id = ui.user_id\n"
            + "join users users on employees.user_info_id = users.`id` "
            + "where `login`=?";

    private static final String SELECT_BY_ID = "select `user_id`, `login`, "
            + "`role`, `name`,  `surname`,  `patronymic`, `gender`, `phone`, "
            + "`birth_date`, `avatar`, `cabinet_number`, `salary`, "
            + "`employment_date`, `specialty`"
            + "from employees "
            + "join user_info ui on employees.user_info_id = ui.user_id "
            + "join users users on employees.user_info_id = users.`id` "
            + "where `id`=?";

    @Override
    public List<Employee> read() throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            List<Employee> employeeList = new ArrayList<>();
            while (resultSet.next()) {
                employeeList.add(getBuilder().build(resultSet));
            }
            return employeeList;

        } catch (SQLException e) {
            throw new PersistentException(e);
        }
    }

    @Override
    public List<Employee> read(String login) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_LOGIN)) {
            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Employee> employeeList = new ArrayList<>();
                while (resultSet.next()) {
                    employeeList.add(getBuilder().build(resultSet));
                }
                return employeeList;
            }
        } catch (SQLException e) {
            LOGGER.error("Can't read the employee by the login: " + login, e);
            throw new PersistentException(e);
        }
    }

    @Override
    public Integer create(Employee employee) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEE,
                Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, employee.getId());
            statement.setInt(2, employee.getCabinetNumber());
            statement.setDouble(3, employee.getSalary());
            statement.setDate(4, employee.getEmploymentDate());
            statement.setInt(5, employee.getSpecialty().getId());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                } else {
                    LOGGER.error("There is no autoincremented index after trying " +
                            "to add record into `employees` ");
                    throw new PersistentException();
                }
            }

        } catch (SQLException e) {
            LOGGER.error("Can't insert the employee into the DB", e);
            throw new PersistentException(e);
        }

    }

    @Override
    public Employee read(Integer id) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                Employee employee = null;
                if (resultSet.next()) {
                    employee = getBuilder().build(resultSet);
                }
                return employee;
            }
        } catch (SQLException e) {
            LOGGER.error("Can't read the employee from DB eith id: " + id, e);
            throw new PersistentException(e);
        }
    }

    @Override
    public boolean update(Employee employee) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID)) {
            statement.setInt(1, employee.getCabinetNumber());
            statement.setDouble(2, employee.getSalary());
            statement.setDate(3, employee.getEmploymentDate());
            statement.setInt(4, employee.getSpecialty().getId());
            statement.setInt(5, employee.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error("Can't update the info about employee with id: "
                    + employee.getId(), e);
            throw new PersistentException(e);
        }
    }

    @Override
    public boolean delete(Integer id) throws PersistentException {
        return false;
    }
}

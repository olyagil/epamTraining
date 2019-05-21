package by.training.beautysalon.builder;

import by.training.beautysalon.dao.mysql.ImageUtill;
import by.training.beautysalon.domain.Employee;
import by.training.beautysalon.domain.enumeration.Gender;
import by.training.beautysalon.domain.enumeration.Role;
import by.training.beautysalon.domain.enumeration.Specialty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeBuilder implements Builder<Employee> {
    @Override
    public Employee build(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();

        employee.setCabinetNumber(resultSet.getInt("cabinet_number"));
        employee.setSalary(resultSet.getDouble("salary"));
        employee.setEmploymentDate(resultSet.getDate("employment_date"));
        employee.setSpecialty(Specialty.getById(resultSet.getInt("specialty")));
        employee.setLogin(resultSet.getString("login"));
        employee.setRole(Role.getById(resultSet.getInt("role")));
        employee.setName(resultSet.getString("name"));
        employee.setSurname(resultSet.getString("surname"));
        employee.setPatronymic(resultSet.getString("patronymic"));
        employee.setGender(Gender.getById(resultSet.getInt("gender")));
        employee.setPhone(resultSet.getInt("phone"));
        employee.setBirthDate(resultSet.getDate("birth_date"));
        employee.setAvatar(ImageUtill.encoder(resultSet.getBlob("avatar")));

        return employee;
    }
}

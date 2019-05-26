package by.training.beautysalon.builder;

import by.training.beautysalon.entity.Employee;
import by.training.beautysalon.entity.Service;
import by.training.beautysalon.entity.Talon;
import by.training.beautysalon.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TalonBuilder implements Builder<Talon> {

    @Override
    public Talon build(ResultSet resultSet) throws SQLException {
        Talon talon = new Talon();
        User client = new User();
        Service service = new Service();
        Employee employee = new Employee();
        talon.setClient(client);
        talon.setService(service);
        talon.setEmployee(employee);

        talon.setId(resultSet.getInt("talons.id"));
        talon.setReceptionDate(resultSet.getTimestamp("reception_date"));
        talon.setStatus(resultSet.getBoolean("status"));
        employee.setId(resultSet.getInt("employee_id"));
        client.setId(resultSet.getInt("client_id"));

        service.setId(resultSet.getInt("s.id"));
        service.setName(resultSet.getString("s.name"));
        employee.setName(resultSet.getString("employee.name"));
        employee.setSurname(resultSet.getString("employee.surname"));
        employee.setPhone(resultSet.getInt("employee.phone"));

        client.setName(resultSet.getString("client.name"));
        client.setSurname(resultSet.getString("client.surname"));
        client.setPhone(resultSet.getInt("client.phone"));

        return talon;
    }
}

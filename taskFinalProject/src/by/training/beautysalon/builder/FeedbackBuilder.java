package by.training.beautysalon.builder;

import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.utill.ImageUtill;
import by.training.beautysalon.entity.Employee;
import by.training.beautysalon.entity.Feedback;
import by.training.beautysalon.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackBuilder implements Builder<Feedback> {
    @Override
    public Feedback build(ResultSet resultSet) throws SQLException {
        Feedback feedback = new Feedback();

        User client = new User();
        Employee employee = new Employee();

        client.setId(resultSet.getInt("client_id"));
        employee.setId(resultSet.getInt("employee_id"));
        client.setSurname(resultSet.getString("client.name"));
        client.setName(resultSet.getString("client.surname"));
        client.setAvatar(ImageUtill.encoder(resultSet.getBlob("client" +
                ".avatar")));
        client.setRole(Role.CLIENT);
        employee.setName(resultSet.getString("employee.name"));
        employee.setSurname(resultSet.getString("employee.surname"));
        employee.setRole(Role.EMPLOYEE);

        feedback.setId(resultSet.getInt("id"));
        feedback.setClient(client);
        feedback.setEmployee(employee);
        feedback.setDate(resultSet.getDate("date"));
        feedback.setReview(resultSet.getString("review"));
        return feedback;
    }
}

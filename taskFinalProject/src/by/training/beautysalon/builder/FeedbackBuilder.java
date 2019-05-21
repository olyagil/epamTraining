package by.training.beautysalon.builder;

import by.training.beautysalon.dao.mysql.ImageUtill;
import by.training.beautysalon.domain.Employee;
import by.training.beautysalon.domain.Feedback;
import by.training.beautysalon.domain.User;

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
        employee.setSurname(resultSet.getString("employee.name"));
        employee.setSurname(resultSet.getString("employee.surname"));
        employee.setAvatar(ImageUtill.encoder(resultSet.getBlob("employee.avatar")));
        feedback.setClient(client);
        feedback.setEmployee(employee);
        feedback.setDate(resultSet.getDate("date"));
        feedback.setReview(resultSet.getString("review"));
        return feedback;
    }
}

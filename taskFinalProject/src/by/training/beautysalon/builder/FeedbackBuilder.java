package by.training.beautysalon.builder;

import by.training.beautysalon.entity.Employee;
import by.training.beautysalon.entity.Feedback;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.utill.ImageUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackBuilder implements Builder<Feedback> {

    private static final String CLIENT_ID = "client_id";
    private static final String EMPLOYEE_ID = "employee_id";
    private static final String CLIENT_NAME = "client.name";
    private static final String CLIENT_SURNAME = "client.surname";
    private static final String CLIENT_AVATAR = "client.avatar";
    private static final String EMPLOYEE_NAME = "employee.name";
    private static final String EMPLOYEE_SURNAME = "employee.surname";
    private static final String ID = "id";
    private static final String DATE = "date";
    private static final String REVIEW = "review";

    @Override
    public Feedback build(ResultSet resultSet) throws SQLException {
        Feedback feedback = new Feedback();

        User client = new User();
        Employee employee = new Employee();

        client.setId(resultSet.getInt(CLIENT_ID));
        employee.setId(resultSet.getInt(EMPLOYEE_ID));
        client.setName(resultSet.getString(CLIENT_NAME));
        client.setSurname(resultSet.getString(CLIENT_SURNAME));
        client.setAvatar(ImageUtil.encoder(resultSet.getBlob(CLIENT_AVATAR)));
        client.setRole(Role.CLIENT);
        employee.setName(resultSet.getString(EMPLOYEE_NAME));
        employee.setSurname(resultSet.getString(EMPLOYEE_SURNAME));
        employee.setRole(Role.EMPLOYEE);

        feedback.setId(resultSet.getInt(ID));
        feedback.setClient(client);
        feedback.setEmployee(employee);
        feedback.setDate(resultSet.getDate(DATE));
        feedback.setReview(resultSet.getString(REVIEW));
        return feedback;
    }
}

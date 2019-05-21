package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.dao.FeedbackDao;
import by.training.beautysalon.domain.Feedback;
import by.training.beautysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDaoImpl extends BaseDaoImpl implements FeedbackDao {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SELECT_ALL = "select  client.`name`, "
            + "client.`surname`, employee.`surname`, employee.`name` ,"
            + "employee.`avatar`, `date`, `review` "
            + "from `feedback`join employees on feedback.employee_id = employees.user_info_id\n" +
            "  join user_info employee on employees.user_info_id = employee.user_id\n" +
            "  join user_info client on feedback.client_id = client.user_id";
    private static final String UPDATE_FEEDBACK = "update `feedback` set  `client_id`=?, employee_id=?, `date`=?, `review`=?\n" +
            "where `id`=?";
    private static final String READ_FEEDBACK_BY_ID = "select `id`, `client_id`, employee_id, `date`, " +
            "`review` from `feedback` where `id`=?";
    private static final String INSERT_FEEDBACK = "insert into `feedback` (`id`, `client_id`, employee_id, `date`, `review`)\n" +
            "values (?,?,?,?,?)";
    private static final String SELECT_BY_EMPLOYEE_ID = "select `client_id`, "
            + "client.`name`, client.surname, employee_id, employee.surname, "
            + "employee.`name`,employee.`avatar`, `date`, `review` from `feedback` "
            + "join employees on feedback.employee_id = employees.user_info_id "
            + "join user_info employee on employees.user_info_id = employee.user_id"
            + " join user_info client on feedback.client_id = client.user_id "
            + "where employee_id=?";
    private static final String DELETE_BY_ID = "delete from feedback where id = ?";
    private static final String SELECT_FEEDBACK_BY_DATE = "select `client_id`, "
            + "client.`name`, client.surname, employee_id, employee.surname, "
            + "employee.`name`,employee.`avatar`, `date`, `review` from `feedback` "
            + "join employees on feedback.employee_id = employees.user_info_id "
            + "join user_info employee on employees.user_info_id = employee.user_id"
            + " join user_info client on feedback.client_id = client.user_id "
            + "where `date`=?";

    //TODO
    @Override
    public List<Feedback> readByClientId(Integer id) throws PersistentException {
        return null;
    }

    @Override
    public List<Feedback> readByEmployee(Integer employeeId) throws PersistentException {

        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_EMPLOYEE_ID)) {
            statement.setInt(1, employeeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Feedback> feedbackList = new ArrayList<>();
                while (resultSet.next()) {
                    feedbackList.add(getBuilder().build(resultSet));
                }
                return feedbackList;
            }
        } catch (SQLException e) {
            LOGGER.error("Can't read the feedback by employee id: "
                    + employeeId, e);
            throw new PersistentException(e);
        }
    }

    @Override
    public List<Feedback> read(Date date) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_FEEDBACK_BY_DATE)) {
            statement.setDate(1, date);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Feedback> feedbackList = new ArrayList<>();
                while (resultSet.next()) {
                    feedbackList.add(getBuilder().build(resultSet));
                }
                return feedbackList;
            }
        } catch (SQLException e) {
            LOGGER.error("Can't read the feedback by date: "
                    + date.toString(), e);
            throw new PersistentException(e);
        }
    }

    @Override
    public List<Feedback> read() throws PersistentException {

        try (PreparedStatement statement =
                     connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            List<Feedback> feedbackList = new ArrayList<>();
            while (resultSet.next()) {
                feedbackList.add(getBuilder().build(resultSet));
            }
            return feedbackList;
        } catch (SQLException e) {
            LOGGER.error("Can't find all feedback from db", e);
            throw new PersistentException(e);
        }
    }

    @Override
    public Integer create(Feedback feedback) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_FEEDBACK,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, feedback.getId());
            statement.setInt(2, feedback.getClient().getId());
            statement.setInt(3, feedback.getEmployee().getId());
            statement.setDate(4, feedback.getDate());
            statement.setString(5, feedback.getReview());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                } else {
                    LOGGER.error("There is no autoincremented index after " +
                            "trying to add record into `feedback` ");
                    throw new PersistentException();
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Can't insert feedback from db", e);
            throw new PersistentException(e);
        }
    }

    @Override
    public Feedback read(Integer id) throws PersistentException {

        try (PreparedStatement statement =
                     connection.prepareStatement(READ_FEEDBACK_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                Feedback feedback = null;
                if (resultSet.next()) {
                    feedback = getBuilder().build(resultSet);
                }
                return feedback;
            }
        } catch (SQLException e) {
            LOGGER.error("Can't read the feedback from db", e);
            throw new PersistentException(e);
        }
    }

    @Override
    public boolean update(Feedback feedback) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(UPDATE_FEEDBACK)) {
            statement.setInt(1, feedback.getClient().getId());
            statement.setInt(2, feedback.getEmployee().getId());
            statement.setDate(3, feedback.getDate());
            statement.setString(4, feedback.getReview());
            statement.setInt(5, feedback.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error("Can't update the feedback from db", e);
            throw new PersistentException(e);
        }
    }

    @Override
    public boolean delete(Integer id) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error("Can't delete the feedback from db", e);
            throw new PersistentException(e);
        }

    }
}

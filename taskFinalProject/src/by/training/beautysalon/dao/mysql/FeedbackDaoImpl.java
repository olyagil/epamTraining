package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.dao.FeedbackDao;
import by.training.beautysalon.domain.Feedback;
import by.training.beautysalon.domain.Specialist;
import by.training.beautysalon.domain.UserInfo;
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
    private static final String READ_ALL = "select  client.`name`, " +
            "client.`surname`, specialist.`surname`, specialist.`name` ,\n" +
            "      `date`, `review`\n" +
            "from `feedback`join specialists on feedback.specialist_id = specialists.user_id\n" +
            "  join user_info specialist on specialists.user_id = specialist.user_id\n" +
            "  join user_info client on feedback.client_id = client.user_id";
    private static final String UPDATE_FEEDBACK = "update `feedback` set  `client_id`=?, `specialist_id`=?, `date`=?, `review`=?\n" +
            "where `id`=?";
    private static final String READ_FEEDBACK_BY_ID = "select `id`, `client_id`, `specialist_id`, `date`, " +
            "`review` from `feedback` where `id`=?";
    private static final String CREATE_FEEDBACK = "insert into `feedback` (`id`, `client_id`, `specialist_id`, `date`, `review`)\n" +
            "values (?,?,?,?,?)";
    private static final String READ_BY_SPECIALIST_ID = "select `client_id`, `surname`, `name`, `date`, `review` from `feedback`\n" +
            "join user_info ui on feedback.client_id = ui.user_id\n" +
            "where specialist_id=?";
    private static final String DELETE_BY_ID = "delete from feedback where id = ?";
    private static final String READ_FEEDBACK_BY_DATE = "select `client_id`, client.`name`, client.surname,\n" +
            "`specialist_id`, specialist.surname, specialist.name\n, " +
            "`review`" +
            "from `feedback`\n" +
            "join specialists on feedback.specialist_id = specialists.user_id\n" +
            "join user_info specialist on specialists.user_id = specialist.user_id\n" +
            "join user_info client on feedback.client_id = client.user_id\n" +
            "where `date`=?";

    @Override
    public List<Feedback> readByClientId(Integer id) throws PersistentException {
        return null;
    }

    @Override
    public List<Feedback> readBySpecialist(Integer specialistId) throws PersistentException {

        try (PreparedStatement statement = connection.prepareStatement(READ_BY_SPECIALIST_ID)) {
            statement.setInt(1, specialistId);
            List<Feedback> feedbackList;
            try (ResultSet resultSet = statement.executeQuery()) {
                feedbackList = new ArrayList<>();
                Feedback feedback;
                while (resultSet.next()) {
                    feedback = new Feedback();

                    UserInfo client = new UserInfo();
                    Specialist specialist = new Specialist();
                    client.setId(resultSet.getInt("client_id"));
                    specialist.setId(specialistId);
                    feedback.setClient(client);
                    feedback.setSpecialist(specialist);
                    feedback.setDate(resultSet.getDate("date"));
                    feedback.setReview(resultSet.getString("review"));

                    feedbackList.add(feedback);
                }
            }
            return feedbackList;

        } catch (SQLException e) {
            throw new PersistentException(e);
        }
    }

    @Override
    public List<Feedback> read(Date date) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(READ_FEEDBACK_BY_DATE)) {
            statement.setDate(1, date);
            List<Feedback> feedbackList;
            try (ResultSet resultSet = statement.executeQuery()) {
                feedbackList = new ArrayList<>();
                Feedback feedback;
                while (resultSet.next()) {
                    feedback = new Feedback();
                    UserInfo client = new UserInfo();
                    Specialist specialist = new Specialist();
                    client.setId(resultSet.getInt("client_id"));
                    specialist.setId(resultSet.getInt("specialist_id"));
                    feedback.setClient(client);
                    feedback.setSpecialist(specialist);
                    feedback.setDate(date);
                    feedback.setReview(resultSet.getString("review"));
                    feedbackList.add(feedback);
                }
                return feedbackList;
            }
        } catch (SQLException e) {
            throw new PersistentException(e);
        }
    }

    @Override
    public List<Feedback> read() throws PersistentException {

        try (PreparedStatement statement =
                     connection.prepareStatement(READ_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            List<Feedback> feedbackList = new ArrayList<>();
            Feedback feedback;
            while (resultSet.next()) {
                feedback = new Feedback();
                UserInfo client = new UserInfo();
                Specialist specialist = new Specialist();
                client.setSurname(resultSet.getString("client.name"));
                client.setName(resultSet.getString("client.surname"));
                specialist.setSurname(resultSet.getString("specialist.name"));
                specialist.setSurname(resultSet.getString("specialist" +
                        ".surname"));
                feedback.setClient(client);
                feedback.setSpecialist(specialist);
                feedback.setDate(resultSet.getDate("date"));
                feedback.setReview(resultSet.getString("review"));
                feedbackList.add(feedback);
            }
            return feedbackList;
        } catch (SQLException e) {
            LOGGER.error("Can't find all feedback from db", e);
            throw new PersistentException(e);
        }
    }

    @Override
    public Integer create(Feedback feedback) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(CREATE_FEEDBACK,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, feedback.getId());
            statement.setInt(2, feedback.getClient().getId());
            statement.setInt(3, feedback.getSpecialist().getId());
            statement.setDate(4, feedback.getDate());
            statement.setString(5, feedback.getReview());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                } else {
                    LOGGER.error("There is no autoincremented index after " +
                            "trying " +
                            "to add record into `users` ");
                    throw new PersistentException();
                }
            }
        } catch (SQLException e) {
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
                    feedback = new Feedback();
                    UserInfo client = new UserInfo();
                    Specialist specialist = new Specialist();
                    Integer clientId = resultSet.getInt("client_id");
                    Integer specialistId = resultSet.getInt("specialist_id");
                    client.setId(clientId);
                    specialist.setId(specialistId);
                    feedback.setClient(client);
                    feedback.setSpecialist(specialist);
                    feedback.setDate(resultSet.getDate("date"));
                    feedback.setReview(resultSet.getString("review"));
                }
                return feedback;
            }
        } catch (SQLException e) {
            throw new PersistentException(e);
        }
    }

    @Override
    public void update(Feedback feedback) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(UPDATE_FEEDBACK)) {
            statement.setInt(1, feedback.getClient().getId());
            statement.setInt(2, feedback.getSpecialist().getId());
            statement.setDate(3, feedback.getDate());
            statement.setString(4, feedback.getReview());
            statement.setInt(5, feedback.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistentException(e);
        }
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistentException(e);
        }

    }
}

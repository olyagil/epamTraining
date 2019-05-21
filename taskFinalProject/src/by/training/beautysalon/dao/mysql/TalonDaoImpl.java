package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.dao.TalonDao;
import by.training.beautysalon.domain.Service;
import by.training.beautysalon.domain.Talon;
import by.training.beautysalon.domain.User;
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

public class TalonDaoImpl extends BaseDaoImpl implements TalonDao {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SELECT_BY_SPECIALIST = "select talons.`id`, "
            + "`client_id`, ui.`surname`,ui.`patronymic`, ui.`phone`, ui"
            + ".`name`, s.`id`, s.`name`, `reception_date`, `status` "
            + "from talons join services s on service_id = s.id "
            + "join user_info ui on talons.client_id = ui.user_id "
            + "where employee_id = ?;";
    private static final String SELECT_BY_ID = "select talons.`id`, `client_id`,"
            + " ui.`surname`, ui.`name`, ui.`patronymic`, ui.`phone`, s.`id`, "
            + "s.`name`, `reception_date`, `status`"
            + "from talons join services s on service_id = s.id "
            + "join user_info ui on talons.client_id = ui.user_id "
            + "where talons.`id` = ?;";
    private static final String INSERT_TALON = "insert into `talons`"
            + "(client_id, service_id, employee_id, reception_date, status) "
            + "values (?, ?, ?, ?, ?);";
    private static final String UPDATE_TALON = "update `talons` set service_id=?,"
            + " `reception_date`=?, `status`=? where id=?";
    private static final String DELETE_BY_ID = "delete from `talons` "
            + "where `id`=?;";

    //TODO
    @Override
    public List<Talon> readByClient(Integer clientId) throws PersistentException {
        return null;
    }

    @Override
    public List<Talon> readBySpecialist(Integer specialistId) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(SELECT_BY_SPECIALIST)) {
            statement.setInt(1, specialistId);

            try (ResultSet resultSet = statement.executeQuery()) {
                List<Talon> talonList = new ArrayList<>();
                while (resultSet.next()) {
                    talonList.add(getBuilder().build(resultSet));
                }
                return talonList;
            }
        } catch (SQLException e) {
            LOGGER.error("Can't read clients by employee id: " + specialistId, e);
            throw new PersistentException(e);
        }
    }

    //TODO
    @Override
    public List<Talon> read(Date date) throws PersistentException {
        return null;
    }

    //TODO
    @Override
    public List<Talon> read() {
        return null;
    }

    @Override
    public Integer create(Talon talon) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_TALON,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, talon.getClient().getId());
            statement.setInt(2, talon.getService().getId());
            statement.setInt(3, talon.getEmployee().getId());
            statement.setTimestamp(4, talon.getReceptionDate());
            statement.setBoolean(5, talon.isStatus());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                } else {
                    LOGGER.error("There is no autoincremented index after trying " +
                            "to add record into `talons` ");
                    throw new PersistentException();
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Can't insert talon in DB ", e);
            throw new PersistentException(e);
        }
    }

    @Override
    public Talon read(Integer id) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                Talon talon = null;
                while (resultSet.next()) {
                    talon = getBuilder().build(resultSet);
                }
                return talon;
            }
        } catch (SQLException e) {
            LOGGER.error("Can't read talon by id: " + id, e);
            throw new PersistentException(e);
        }
    }

    @Override
    public boolean update(Talon talon) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_TALON)) {
            statement.setInt(1, talon.getService().getId());
            statement.setTimestamp(2, talon.getReceptionDate());
            statement.setBoolean(3, talon.isStatus());
            statement.setInt(4, talon.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error("Can't make the update of the talon to DB ", e);
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
            LOGGER.error("Can't delete the talon from DB ", e);
            throw new PersistentException(e);
        }
    }
}

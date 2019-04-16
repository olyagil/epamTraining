package by.training.beatysalon.dao.mysql;

import by.training.beatysalon.dao.TalonDao;
import by.training.beatysalon.domain.Talon;
import by.training.beatysalon.exception.PersistentException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TalonDaoImpl extends BaseDaoImpl implements TalonDao {
    private static final String SQL = "insert into `talons` (`id`, `service_id`,"
            + " `specialist_id`, `client_id`, `reception_date`, `status`) "
            + "VALUES (?,?,?,?,?,?)";

    @Override
    public Integer create(Talon talon) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, talon.getService().getId());
            statement.setInt(2, talon.getSpecialist().getId());
            statement.setInt(3, talon.getClient().getId());
            statement.setDate(4, new Date(talon.getReceptionDate().getTime()));
            statement.setBoolean(5, talon.isStatus());

            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
        } catch (SQLException e) {
            throw new PersistentException();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {

            }
            try {
                statement.close();
            } catch (SQLException e) {

            }
        }

        return null;
    }

    @Override
    public Talon read(Integer id) throws PersistentException {
        return null;
    }

    @Override
    public void update(Talon entity) throws PersistentException {

    }

    @Override
    public void delete(Integer id) throws PersistentException {

    }

    @Override
    public List<Talon> readBySpecialist(Integer specialistId) throws PersistentException {
        return null;
    }

    @Override
    public List<Talon> readByService(Integer serviceId) throws PersistentException {
        return null;
    }

    @Override
    public List<Talon> readByReceptionDate() throws PersistentException {
        return null;
    }

    @Override
    public List<Talon> readByClients(Integer clientId) throws PersistentException {
        return null;
    }
}

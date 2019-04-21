package by.training.beatysalon.dao.mysql;

import by.training.beatysalon.dao.TalonDao;
import by.training.beatysalon.domain.Client;
import by.training.beatysalon.domain.Service;
import by.training.beatysalon.domain.Specialist;
import by.training.beatysalon.domain.Talon;
import by.training.beatysalon.exception.PersistentException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TalonDaoImpl extends BaseDaoImpl implements TalonDao {
    private static final String SQL = "insert into `talons` (`id`, `service_id`,"
            + " `specialist_id`, `client_id`, `reception_date`, `status`) "
            + "VALUES (?,?,?,?,?,?)";

    @Override
    public Integer create(Talon talon) throws PersistentException {
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {
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
        String sql = "select `id`, `service_id`, `client_id`, " +
                "`reception_date`, `status` from `talons` where " +
                "`specialist_id`=?";
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, specialistId);
            resultSet = statement.executeQuery();
            List<Talon> talonList = new ArrayList<>();
            Talon talon;
            Specialist specialist = new Specialist();
            while (resultSet.next()) {
                talon = new Talon();
                talon.setId(resultSet.getInt("id"));
                talon.setSpecialist(specialist);
                Service service = new Service();
                service.setId(resultSet.getInt("service_id"));
                talon.setService(service);
                Client client = new Client();
                client.setId(resultSet.getInt("client_id"));
                talon.setClient(client);
                talon.setReceptionDate(new java.util.Date(resultSet.getDate(
                        "reception_date").getTime()));
                talon.setStatus(resultSet.getBoolean("status"));
                talonList.add(talon);
            }
            return talonList;
        } catch (SQLException e) {
            throw new PersistentException();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
            }
        }
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

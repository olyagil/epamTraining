package by.training.beatysalon.dao.mysql;

import by.training.beatysalon.dao.ServiceDao;
import by.training.beatysalon.domain.Service;
import by.training.beatysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceDaoImpl extends BaseDaoImpl implements ServiceDao {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String DELETE_BY_ID = "delete from `services` where `id`=?";
    public static final String UPDATE_SERVICE = "update `services` set `name`=?,"
            + " `description`=?, `price`=?, `duration`=?"
            + "where `id`=?";
    public static final String READ_BY_ID = "select `name`, `description`, `price`, `duration` " +
            "from `services` where `id`=?";
    public static final String CREATE_SERVICE = "insert into `services`(`name`,"
            + " `description`, `price`, `duration`) values (?,?,?,?)";
    public static final String READ_SERVICES_BY_RANGE_OF_PRICE =
            "select `name`, `description`, `price`, `duration` from `services`"
                    + " where `price` between  ? and ? order by `price`";

    @Override
    public Service readByName(String name) throws PersistentException {
        String sql = "";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                Service service = null;
                if (resultSet.next()) {
                    service = new Service();
                    service.setId(resultSet.getInt("id"));
                    service.setName(resultSet.getString("name"));
                    service.setDescription(resultSet.getString("descrition"));
                    service.setPrice(resultSet.getDouble("price"));
                    service.setDuration(resultSet.getDouble("duration"));
                }
                return service;
            }
        } catch (SQLException e) {
            throw new PersistentException();
        }
    }

    @Override
    public List<Service> readByPrice(double startPrice, double endPrice)
            throws PersistentException {
        List<Service> serviceList;
        try (PreparedStatement statement =
                     connection.prepareStatement(READ_SERVICES_BY_RANGE_OF_PRICE)) {
            statement.setDouble(1, startPrice);
            statement.setDouble(2, endPrice);

            try (ResultSet resultSet = statement.executeQuery()) {
                serviceList = new ArrayList<>();
                Service service;
                while (resultSet.next()) {
                    service = new Service();
                    service.setId(resultSet.getInt("id"));
                    service.setName(resultSet.getString("name"));
                    service.setDescription(resultSet.getString("description"));
                    service.setPrice(resultSet.getDouble("price"));
                    service.setDuration(resultSet.getDouble("duration"));
                    serviceList.add(service);
                }
                return serviceList;
            }
        } catch (SQLException e1) {
            throw new PersistentException();

        }
    }

    @Override
    public Integer create(Service service) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SERVICE,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, service.getName());
            statement.setString(2, service.getDescription());
            statement.setDouble(3, service.getPrice());
            statement.setDouble(4, service.getDuration());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                } else {
                    LOGGER.error("There is no autoincremented index after trying " +
                            "to add record into `users` ");
                    throw new PersistentException();
                }
            }
        } catch (SQLException e) {
            throw new PersistentException();
        }
    }

    @Override
    public Service read(Integer id) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(READ_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                Service service = null;
                if (resultSet.next()) {
                    service = new Service();
                    service.setId(id);
                    service.setName(resultSet.getString("name"));
                    service.setDescription(resultSet.getString("description"));
                    service.setPrice(resultSet.getDouble("price"));
                    service.setDuration(resultSet.getDouble("duration"));
                }
                return service;
            }
        } catch (SQLException e) {
            throw new PersistentException();
        }

    }

    @Override
    public void update(Service service) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SERVICE)) {
            statement.setString(1, service.getName());
            statement.setString(2, service.getDescription());
            statement.setDouble(3, service.getPrice());
            statement.setDouble(4, service.getDuration());
            statement.setInt(5, service.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistentException();
        }
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistentException();
        }


    }
}

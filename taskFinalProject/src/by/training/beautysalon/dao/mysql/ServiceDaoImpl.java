package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.dao.ServiceDao;
import by.training.beautysalon.domain.Service;
import by.training.beautysalon.exception.PersistentException;
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
    private static final String READ_ALL = "select `id`, `name`, " +
            "`description`, `price`, `duration` " +
            "from `services`";
    private static final String DELETE_BY_ID = "delete from `services` where `id`=?";
    private static final String UPDATE_SERVICE = "update `services` set `name`=?,"
            + " `description`=?, `price`=?, `duration`=?"
            + "where `id`=?";
    private static final String READ_BY_ID = "select `name`, `description`, `price`, `duration` " +
            "from `services` where `id`=?";
    private static final String CREATE_SERVICE = "insert into `services`(`name`,"
            + " `description`, `price`, `duration`) values (?,?,?,?)";
    //    private static final String READ_SERVICES_BY_RANGE_OF_PRICE =
//            "select `id`, `name`, `description`, `price`, `duration` from " +
//                    "`services`"
//                    + " where `price` between  ? and ? order by `price`";
    private static final String READ_SERVICE_BY_NAME = "select `id`, `name`, " +
            "`description`, `price`, `duration` from `services`\n" +
            "where `name` like ? order by name";

    /**
     * Though you can use the last() and getRow() method to first move to the
     * last position and then return the current row, btw, you must return back
     * to the previous position by calling beforeFirst(), otherwise, you will
     * miss all records from ResultSet.
     *
     * @return
     * @throws PersistentException
     */
    @Override
    public int getNumberOfRows() throws PersistentException {
        String COUNT_ROWS = "select count(`id`) from `services`";
        int count = 0;
        try (PreparedStatement statement =
                     connection.prepareStatement(COUNT_ROWS);
             ResultSet resultSet = statement.executeQuery()) {
         if(resultSet.next()){
            count =resultSet.getInt(1);
        } }catch (SQLException e) {
            LOGGER.error("Can't count the number of services", e);
            throw new PersistentException(e);
        }
        return count;

    }

    @Override
    public List<Service> read(String name) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(READ_SERVICE_BY_NAME)) {
            statement.setString(1, "%" + name + "%");
            List<Service> serviceList;
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
        } catch (SQLException e) {
            throw new PersistentException(e);
        }
    }

    @Override
    public List<Service> read(int currentPage, int recordsPerPage) throws PersistentException {
        String READ_ALL_PARTS = "  select `id`, `name`, `description`, `price`, " +
                "`duration` from `services` order by `id` limit ?,?";
        int start = currentPage * recordsPerPage - recordsPerPage;

        try (PreparedStatement statement =
                     connection.prepareStatement(READ_ALL_PARTS)) {
            statement.setInt(1, start);
            statement.setInt(2, recordsPerPage);
            List<Service> serviceList;
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
        } catch (SQLException e) {
            LOGGER.error("Can't read by page the services", e);
            throw new PersistentException(e);
        }

    }

    @Override
    public List<Service> read() throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(READ_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            List<Service> serviceList = new ArrayList<>();
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

        } catch (SQLException e) {
            throw new PersistentException(e);

        }

    }

//    @Override
//    public List<Service> read(double startPrice, double endPrice)
//            throws PersistentException {
//        List<Service> serviceList;
//        try (PreparedStatement statement =
//                     connection.prepareStatement(READ_SERVICES_BY_RANGE_OF_PRICE)) {
//            statement.setDouble(1, startPrice);
//            statement.setDouble(2, endPrice);
//
//            try (ResultSet resultSet = statement.executeQuery()) {
//                serviceList = new ArrayList<>();
//                Service service;
//                while (resultSet.next()) {
//                    service = new Service();
//                    service.setId(resultSet.getInt("id"));
//                    service.setName(resultSet.getString("name"));
//                    service.setDescription(resultSet.getString("description"));
//                    service.setPrice(resultSet.getDouble("price"));
//                    service.setDuration(resultSet.getDouble("duration"));
//                    serviceList.add(service);
//                }
//                return serviceList;
//            }
//        } catch (SQLException e) {
//            throw new PersistentException(e);
//
//        }
//    }

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
            LOGGER.error("Can't insert the service in DB.", e);
            throw new PersistentException(e);
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
        try (PreparedStatement statement =
                     connection.prepareStatement(UPDATE_SERVICE)) {
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

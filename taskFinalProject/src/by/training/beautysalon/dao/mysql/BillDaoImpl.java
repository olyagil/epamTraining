package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.domain.Bill;
import by.training.beautysalon.domain.Service;
import by.training.beautysalon.domain.Specialist;
import by.training.beautysalon.domain.User;
import by.training.beautysalon.exception.PersistentException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl extends BaseDaoImpl  {
    private static final String SQL = "insert into `talons` (`id`, `service_id`,"
            + " `specialist_id`, `client_id`, `reception_date`, `status`) "
            + "VALUES (?,?,?,?,?,?)";

    public Integer create(Bill bill) throws PersistentException {
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, bill.getService().getId());
            statement.setInt(2, bill.getSpecialist().getId());
//            statement.setInt(3, bill.getClient().getId());
            statement.setDate(4, new Date(bill.getReceptionDate().getTime()));
            statement.setBoolean(5, bill.isStatus());

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

    public Bill read(Integer id) throws PersistentException {
        return null;
    }

    public void update(Bill entity) throws PersistentException {

    }

    public void delete(Integer id) throws PersistentException {

    }

    public List<Bill> readBySpecialist(Integer specialistId) throws PersistentException {
        String sql = "select `id`, `service_id`, `client_id`, " +
                "`reception_date`, `status` from `talons` where " +
                "`specialist_id`=?";
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, specialistId);
            resultSet = statement.executeQuery();
            List<Bill> billList = new ArrayList<>();
            Bill bill;
            Specialist specialist = new Specialist();
            while (resultSet.next()) {
                bill = new Bill();
                bill.setId(resultSet.getInt("id"));
                bill.setSpecialist(specialist);
                Service service = new Service();
                service.setId(resultSet.getInt("service_id"));
                bill.setService(service);
                User client = new User();
                client.setId(resultSet.getInt("client_id"));
//                bill.setClient(client);
                bill.setReceptionDate(new java.util.Date(resultSet.getDate(
                        "reception_date").getTime()));
                bill.setStatus(resultSet.getBoolean("status"));
                billList.add(bill);
            }
            return billList;
        } catch (SQLException e) {
            throw new PersistentException();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
            }
        }
    }

    public List<Bill> readByService(Integer serviceId) throws PersistentException {
        return null;
    }

    public List<Bill> readByReceptionDate() throws PersistentException {
        return null;
    }


}

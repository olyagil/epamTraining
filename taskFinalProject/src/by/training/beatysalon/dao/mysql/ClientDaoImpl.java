package by.training.beatysalon.dao.mysql;

import by.training.beatysalon.dao.ClientDao;
import by.training.beatysalon.domain.Client;
import by.training.beatysalon.exception.PersistentException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl extends BaseDaoImpl implements ClientDao {
    @Override
    public Client readByCardNumber(String cardNumber) throws PersistentException {
        return null;
    }

    @Override
    public List<Client> read() throws PersistentException {

        String sql = "select `id`, `name`, `surname`, `patronymic`, " +
                "`phone` " +
                "from `user_info` ";
//                +                "join `user_info` using (`user_id`)";

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            List<Client> clients = new ArrayList<>();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            Client client = null;
            while (resultSet.next()) {
                client.setId(resultSet.getInt("id"));
                client.setSurname(resultSet.getString("surname"));
                client.setName(resultSet.getString("name"));
                client.setPatronymic(resultSet.getString("patronymic"));
                client.setPhone(resultSet.getInt("phone"));
                client.setBirthDate(resultSet.getDate("birth_date"));
                clients.add(client);
            }
            return clients;
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
        }

    }

    @Override
    public List<Client> read(String search) throws PersistentException {
        return null;
    }

    @Override
    public Integer create(Client entity) throws PersistentException {
        return null;
    }

    @Override
    public Client read(Integer id) throws PersistentException {
        return null;
    }

    @Override
    public void update(Client entity) throws PersistentException {

    }

    @Override
    public void delete(Integer id) throws PersistentException {

    }
}

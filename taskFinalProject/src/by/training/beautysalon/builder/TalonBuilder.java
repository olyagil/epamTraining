package by.training.beautysalon.builder;

import by.training.beautysalon.domain.Service;
import by.training.beautysalon.domain.Talon;
import by.training.beautysalon.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TalonBuilder implements Builder<Talon> {

    @Override
    public Talon build(ResultSet resultSet) throws SQLException {
        Talon talon = new Talon();
        User client = new User();
        Service service = new Service();
        talon.setClient(client);
        talon.setService(service);

        talon.setId(resultSet.getInt("talons.id"));
        talon.setReceptionDate(resultSet.getTimestamp("reception_date"));
        talon.setStatus(resultSet.getBoolean("status"));

        service.setId(resultSet.getInt("s.id"));
        service.setName(resultSet.getString("s.name"));

        client.setId(resultSet.getInt("client_id"));
        client.setName(resultSet.getString("ui.name"));
        client.setSurname(resultSet.getString("ui.surname"));
        client.setPatronymic(resultSet.getString("ui.patronymic"));
        client.setPhone(resultSet.getInt("ui.phone"));
        return talon;
    }
}

package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.dao.TalonDao;
import by.training.beautysalon.domain.Talon;
import by.training.beautysalon.exception.PersistentException;

import java.sql.Date;
import java.util.List;

public class TalonDaoImpl extends BaseDaoImpl implements TalonDao {

    private final static String SQL = "select talons.`id`,\n" +
            "       `client_id`,\n" +
            "       client.`surname`,\n" +
            "       client.`name`,\n" +
            "       `bill_id`,\n" +
            "       transaction.`name`,\n" +
            "       ui.`surname`,\n" +
            "       ui.`name`\n" +
            "from `talons`\n" +
            "       join bills bill on talons.bill_id = bill.id\n" +
            "       join user_info client on talons.client_id = client.user_id\n" +
            "       join services transaction on bill.service_id = transaction.id\n" +
            "       join specialists specialist on bill.specialist_id = specialist.user_id\n" +
            "       join user_info ui on specialist.user_id = ui.user_id;";

    @Override
    public List<Talon> readByClient(Integer clientId) throws PersistentException {
        return null;
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
    public List<Talon> read(Date date) throws PersistentException {
        return null;
    }

    @Override
    public List<Talon> read() {
        return null;
    }

    @Override
    public Integer create(Talon entity) throws PersistentException {
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
}

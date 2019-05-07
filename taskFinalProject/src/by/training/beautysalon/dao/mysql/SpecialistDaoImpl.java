package by.training.beautysalon.dao.mysql;

import by.training.beautysalon.dao.SpecialistDao;
import by.training.beautysalon.domain.Specialist;
import by.training.beautysalon.domain.enumeration.Specialty;
import by.training.beautysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SpecialistDaoImpl extends BaseDaoImpl implements SpecialistDao {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String DELETE_SPECIALIST_BY_ID = "delete from " +
            "`specialists` where user_id=?";
    private static final String UPDATE_SPECIALIST_BY_ID = "update `specialists` set `cabinet_number`=?, `salary`=?, `employment_date`=?,\n" +
            "`specialty`=? where user_id=?";
    private static final String CREATE_SPECIALIST = "insert into `specialists` (`user_id`," +
            "`cabinet_number`," +
            " `salary`, `employment_date`, `specialty`)" +
            "values (?,?,?,?,?)";
    private static final String READ_ALL = "select `name`, `surname`, `patronymic`, `phone`, `birth_date`, path_to_photo,\n" +
            "`cabinet_number`, `salary`, `employment_date`, `specialty`\n" +
            "from `specialists` join user_info ui on specialists.user_id = ui.user_id";
    private static final String READ_BY_ID = "select `cabinet_number`, `salary`, `employment_date`, `specialty`\n" +
            "from `specialists` where user_id=?";

    @Override
    public List<Specialist> read() throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(READ_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            List<Specialist> specialistList = new ArrayList<>();
            Specialist specialist;
            while (resultSet.next()) {
                specialist = new Specialist();
                specialist.setCabinetNumber(resultSet.getInt("cabinet_number"));
                specialist.setSalary(resultSet.getDouble("salary"));
                specialist.setEmploymentDate(resultSet.getDate("employment_date"));
                specialist.setSpecialty(Specialty.getById(resultSet.getInt(
                        "specialty")));
                specialistList.add(specialist);
            }
            return specialistList;

        } catch (SQLException e) {
            throw new PersistentException(e);
        }
    }

    //TODO ???????
    @Override
    public Integer create(Specialist specialist) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(CREATE_SPECIALIST,
                Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, specialist.getId());
            statement.setInt(2, specialist.getCabinetNumber());
            statement.setDouble(3, specialist.getSalary());
            statement.setDate(4, specialist.getEmploymentDate());
            statement.setInt(5, specialist.getSpecialty().getId());
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
            throw new PersistentException(e);
        }

    }

    @Override
    public Specialist read(Integer id) throws PersistentException {
        try (PreparedStatement statement = connection.prepareStatement(READ_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                Specialist specialist = null;
                if (resultSet.next()) {
                    specialist = new Specialist();
                    specialist.setId(id);
                    specialist.setCabinetNumber(resultSet.getInt(
                            "cabinet_number"));
                    specialist.setSalary(resultSet.getDouble("salary"));
                    specialist.setEmploymentDate(resultSet.getDate(
                            "employment_date"));
                    specialist.setSpecialty(Specialty.getById(resultSet.getInt(
                            "specialty")));

                }
                return specialist;
            }
        } catch (SQLException e) {
            throw new PersistentException(e);
        }
    }

    @Override
    public void update(Specialist specialist) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(UPDATE_SPECIALIST_BY_ID)) {
            statement.setInt(1, specialist.getCabinetNumber());
            statement.setDouble(2, specialist.getSalary());
            statement.setDate(3, specialist.getEmploymentDate());
            statement.setInt(4, specialist.getSpecialty().getId());
            statement.setInt(5, specialist.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistentException(e);
        }
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        try (PreparedStatement statement =
                     connection.prepareStatement(DELETE_SPECIALIST_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistentException(e);
        }

    }
}

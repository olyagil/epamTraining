package by.training.beautysalon.service.impl;

import by.training.beautysalon.dao.TalonDao;
import by.training.beautysalon.dao.mysql.DaoFactory;
import by.training.beautysalon.entity.Talon;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.TalonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.List;

public class TalonServiceImpl implements TalonService {
    private static final Logger LOGGER = LogManager.getLogger();


    @Override
    public List<Talon> findByClient(Integer clientId) throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        return null;
    }

    @Override
    public List<Talon> findBySpecialist(Integer specialistId) throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        return dao.readBySpecialist(specialistId);
    }

    @Override
    public List<Talon> find(Date date) throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        return null;
    }

    @Override
    public List<Talon> find() throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        return null;
    }

    @Override
    public Talon find(Integer id) throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        return dao.read(id);
    }

    @Override
    public void save(Talon talon) throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        LOGGER.debug("TALON ID: " + talon.getId());
        if (talon.getId() != null) {
            dao.update(talon);
        } else {
            talon.setId(dao.create(talon));
        }
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        dao.delete(id);
    }
}

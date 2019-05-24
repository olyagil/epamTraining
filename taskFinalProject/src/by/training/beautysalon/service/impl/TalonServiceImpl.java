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
    public int countRows() throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        return dao.countRows();
    }

    @Override
    public List<Talon> find(int currentPage, int recordsPerPage) throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        return dao.read(currentPage, recordsPerPage);
    }

    @Override
    public List<Talon> findByClient(Integer clientId) throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        return dao.readByClient(clientId);
    }

    @Override
    public List<Talon> findByEmployee(Integer specialistId) throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        return dao.readByEmployee(specialistId);
    }

    @Override
    public List<Talon> find(Date date) throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        return dao.read(date);
    }

    @Override
    public List<Talon> find(Boolean status) throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        return dao.read(status);
    }

    @Override
    public List<Talon> find() throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        return dao.read();
    }


    @Override
    public Talon find(Integer id) throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        return dao.read(id);
    }

    @Override
    public Integer save(Talon talon) throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        LOGGER.debug("TALON ID: " + talon.getId());
        if (talon.getId() != null) {
            dao.update(talon);
        } else {
            talon.setId(dao.create(talon));
        }
        return talon.getId();
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        TalonDao dao = DaoFactory.getInstance().getTalonDao();
        dao.delete(id);
    }
}

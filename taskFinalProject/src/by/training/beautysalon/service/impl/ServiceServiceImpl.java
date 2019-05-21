package by.training.beautysalon.service.impl;

import by.training.beautysalon.dao.ServiceDao;
import by.training.beautysalon.dao.mysql.DaoFactory;
import by.training.beautysalon.entity.Service;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.ServiceService;

import java.sql.Date;
import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    @Override
    public int getNumberOfRows() throws PersistentException {
        ServiceDao dao = DaoFactory.getInstance().getServiceDao();
        return dao.getNumberOfRows();
    }

    @Override
    public List<Service> find() throws PersistentException {
        ServiceDao dao = DaoFactory.getInstance().getServiceDao();
        return dao.read();
    }

    @Override
    public List<Service> find(int currentPage, int recordsPerPage) throws PersistentException {
        ServiceDao dao = DaoFactory.getInstance().getServiceDao();
        return dao.read(currentPage, recordsPerPage);
    }

    @Override
    public Service find(Integer id) throws PersistentException {
        ServiceDao dao = DaoFactory.getInstance().getServiceDao();
        return dao.read(id);
    }


    @Override
    public List<Service> find(String name) throws PersistentException {
        ServiceDao dao = DaoFactory.getInstance().getServiceDao();
        return dao.read(name);
    }

    @Override
    public List<Service> find(Date date) throws PersistentException {
        ServiceDao dao = DaoFactory.getInstance().getServiceDao();
        return null;
    }


    @Override
    public void save(Service service) throws PersistentException {
        ServiceDao dao = DaoFactory.getInstance().getServiceDao();
        if (service.getId() != null) {
            dao.update(service);
        } else {
            service.setId(dao.create(service));
        }
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        ServiceDao dao = DaoFactory.getInstance().getServiceDao();
        dao.delete(id);
    }
}

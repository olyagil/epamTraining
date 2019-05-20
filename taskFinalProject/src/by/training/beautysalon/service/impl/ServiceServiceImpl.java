package by.training.beautysalon.service.impl;

import by.training.beautysalon.dao.ServiceDao;
import by.training.beautysalon.domain.Service;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.ServiceService;

import java.util.List;

public class ServiceServiceImpl extends ServiceImpl implements ServiceService {
    @Override
    public int getNumberOfRows() throws PersistentException {
        ServiceDao dao = transaction.createDao(ServiceDao.class);
        return dao.getNumberOfRows();
    }

    @Override
    public List<Service> find() throws PersistentException {
        ServiceDao dao = transaction.createDao(ServiceDao.class);
        return dao.read();
    }

    @Override
    public List<Service> find(int currentPage, int recordsPerPage) throws PersistentException {
        ServiceDao dao = transaction.createDao(ServiceDao.class);
        return dao.read(currentPage, recordsPerPage);
    }

    @Override
    public Service find(Integer id) throws PersistentException {
        ServiceDao dao = transaction.createDao(ServiceDao.class);
        return dao.read(id);
    }


    @Override
    public List<Service> find(String name) throws PersistentException {
        ServiceDao dao = transaction.createDao(ServiceDao.class);
        return dao.read(name);
    }


    @Override
    public void save(Service service) throws PersistentException {
        ServiceDao dao = transaction.createDao(ServiceDao.class);
        if (service.getId() != null) {
            dao.update(service);
        } else {
            service.setId(dao.create(service));
        }
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        ServiceDao dao = transaction.createDao(ServiceDao.class);
        dao.delete(id);
    }
}

package by.training.beautysalon.service.impl;

import by.training.beautysalon.dao.ServiceDao;
import by.training.beautysalon.domain.Service;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.ServiceService;

import java.util.List;

public class ServiceServiceImpl extends ServiceImpl implements ServiceService {
    @Override
    public List<Service> find() throws PersistentException {
        ServiceDao dao = transaction.createDao(ServiceDao.class);
        return dao.read();
    }

    @Override
    public Service find(Integer id) throws PersistentException {
        return null;
    }


    @Override
    public List<Service> find(String name) throws PersistentException {
        return null;
    }

    @Override
    public List<Service> find(double startPrice, double endPrice) throws PersistentException {
        return null;
    }

    @Override
    public void save(Service service) throws PersistentException {

    }

    @Override
    public void delete(Integer id) throws PersistentException {

    }
}

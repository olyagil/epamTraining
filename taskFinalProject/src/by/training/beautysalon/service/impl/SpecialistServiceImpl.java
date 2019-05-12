package by.training.beautysalon.service.impl;

import by.training.beautysalon.dao.SpecialistDao;
import by.training.beautysalon.dao.mysql.SpecialistDaoImpl;
import by.training.beautysalon.domain.Specialist;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.SpecialistService;

import java.util.List;

public class SpecialistServiceImpl extends ServiceImpl implements SpecialistService {
    @Override
    public List<Specialist> find() throws PersistentException {
        SpecialistDao dao = transaction.createDao(SpecialistDao.class);
        return dao.read();
    }

    @Override
    public Specialist find(Integer id) throws PersistentException {
        return null;
    }

    @Override
    public void save(Specialist specialist) throws PersistentException {

    }

    @Override
    public void delete(Integer id) throws PersistentException {

    }
}

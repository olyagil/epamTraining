package by.training.beautysalon.dao;

import by.training.beautysalon.domain.Bill;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface BillDao extends Dao<Bill> {

    List<Bill> readBySpecialist(Integer specialistId) throws PersistentException;

    List<Bill> readByService(Integer serviceId) throws PersistentException;

    List<Bill> readByReceptionDate() throws PersistentException;

}

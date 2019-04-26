package by.training.beatysalon.dao;

import by.training.beatysalon.domain.Bill;
import by.training.beatysalon.exception.PersistentException;

import java.util.List;

public interface BillDao extends Dao<Bill> {

    List<Bill> readBySpecialist(Integer specialistId) throws PersistentException;

    List<Bill> readByService(Integer serviceId) throws PersistentException;

    List<Bill> readByReceptionDate() throws PersistentException;

}

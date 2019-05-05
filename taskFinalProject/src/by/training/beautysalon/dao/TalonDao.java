package by.training.beautysalon.dao;

import by.training.beautysalon.domain.Bill;
import by.training.beautysalon.exception.PersistentException;

import java.util.List;

public interface TalonDao extends BillDao {
    List<Bill> readByClient(Integer clientId) throws PersistentException;


}

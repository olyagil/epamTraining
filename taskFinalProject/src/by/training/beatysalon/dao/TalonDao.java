package by.training.beatysalon.dao;

import by.training.beatysalon.domain.Bill;
import by.training.beatysalon.exception.PersistentException;

import java.util.List;

public interface TalonDao extends BillDao {
    List<Bill> readByClients(Integer clientId) throws PersistentException;


}

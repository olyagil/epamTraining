package by.training.beatysalon.dao;

import by.training.beatysalon.domain.Client;
import by.training.beatysalon.exception.PersistentException;

import java.util.List;

public interface ClientDao extends Dao<Client> {

    Client readByCardNumber(String cardNumber) throws PersistentException;

    List<Client> read() throws PersistentException;

    List<Client> read(String search) throws PersistentException;
}

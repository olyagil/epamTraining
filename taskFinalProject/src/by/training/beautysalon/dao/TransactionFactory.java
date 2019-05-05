package by.training.beautysalon.dao;

import by.training.beautysalon.exception.PersistentException;

public interface TransactionFactory {

    Transaction createTransaction() throws PersistentException;

    void close();
}

package by.training.beatysalon.dao;

import by.training.beatysalon.exception.PersistentException;

public interface TransactionFactory {

    Transaction createTransaction() throws PersistentException;

    void close();
}

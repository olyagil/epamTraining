package by.training.beatysalon.service;

import by.training.beatysalon.dao.Transaction;

public abstract class ServiceImpl implements Service {

    protected Transaction transaction = null;

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}

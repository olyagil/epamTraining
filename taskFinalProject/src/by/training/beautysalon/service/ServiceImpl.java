package by.training.beautysalon.service;

import by.training.beautysalon.dao.Transaction;
import by.training.beautysalon.service.impl.Service;

public abstract class ServiceImpl implements Service {

    protected Transaction transaction = null;

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}

package by.training.beautysalon.service;

import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.impl.UserInfoServiceImpl;

public interface ServiceFactory {

    UserInfoServiceImpl getUserServiceImpl();

    <Type extends Service> Type getService(Class<Type> key)
            throws PersistentException;

    void close();
}

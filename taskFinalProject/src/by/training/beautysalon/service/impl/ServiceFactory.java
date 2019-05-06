package by.training.beautysalon.service.impl;

import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.impl.Service;

public interface ServiceFactory {

    <Type extends Service> Type getService(Class<Type> key)
            throws PersistentException;

    void close();
}

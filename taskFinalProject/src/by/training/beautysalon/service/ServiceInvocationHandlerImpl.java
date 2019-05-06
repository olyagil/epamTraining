package by.training.beautysalon.service;

import by.training.beautysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ServiceInvocationHandlerImpl implements InvocationHandler {
    private static final Logger LOGGER = LogManager.getLogger();
    private ServiceImpl service;

    public ServiceInvocationHandlerImpl(ServiceImpl service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        try {
            Object result = method.invoke(service, args);
            service.transaction.commit();
            return result;
        } catch (PersistentException e) {
            rollback(method);
            throw e;
        } catch (InvocationTargetException e) {
            rollback(method);
            throw e.getCause();
        }
    }

    private void rollback(Method method) {
        try {
            service.transaction.rollback();
        } catch (PersistentException e) {
            LOGGER.error("Can't rollback transaction", e);
        }
    }

}

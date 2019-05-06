package by.training.beautysalon.service;

import by.training.beautysalon.dao.Transaction;
import by.training.beautysalon.dao.TransactionFactory;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.impl.Service;
import by.training.beautysalon.service.impl.ServiceFactory;
import by.training.beautysalon.service.impl.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceFactoryImpl implements ServiceFactory {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Map<Class<? extends Service>,
            Class<? extends ServiceImpl>> SERVICES = new ConcurrentHashMap<>();

    static {
        SERVICES.put(UserService.class, UserServiceImpl.class);
//        SERVICES.put(ClientService.class, ClientServiceImpl.class);
//        SERVICES.put(ServiceService.class, ServiceServiceImpl.class);

    }

    private TransactionFactory factory;

    public ServiceFactoryImpl(TransactionFactory factory)
            throws PersistentException {
        this.factory = factory;
    }

    @Override
    public <Type extends Service> Type getService(Class<Type> key)
            throws PersistentException {
        Class<? extends ServiceImpl> value = SERVICES.get(key);
        if (value != null) {
            try {
                ClassLoader classLoader = value.getClassLoader();
                Class<?>[] interfaces = {key};
                Transaction transaction = factory.createTransaction();
                ServiceImpl service = value.newInstance();
                service.setTransaction(transaction);
                InvocationHandler handler =
                        new ServiceInvocationHandlerImpl(service);
                return (Type) Proxy.newProxyInstance(classLoader, interfaces,
                        handler);
            } catch (PersistentException e) {
                throw e;

            } catch (IllegalAccessException | InstantiationException e) {
                LOGGER.error("Can't instance service class.", e);
                throw new PersistentException(e);
            }
        }
        return null;
    }

    @Override
    public void close() {
        factory.close();

    }
}

package by.training.beautysalon.service.impl;

import by.training.beautysalon.dao.Transaction;
import by.training.beautysalon.dao.TransactionFactory;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.FeedbackService;
import by.training.beautysalon.service.Service;
import by.training.beautysalon.service.ServiceFactory;
import by.training.beautysalon.service.ServiceService;
import by.training.beautysalon.service.SpecialistService;
import by.training.beautysalon.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceFactoryImpl implements ServiceFactory {
    private static final Logger LOGGER = LogManager.getLogger();

    public UserInfoServiceImpl getUserServiceImpl() {
        return new UserInfoServiceImpl();
    }

    public FeedbackServiceImpl getFeedbackServiceImpl() {
        return new FeedbackServiceImpl();
    }


    private static final Map<Class<? extends Service>,
            Class<? extends ServiceImpl>> SERVICES = new ConcurrentHashMap<>();

    static {
        SERVICES.put(UserInfoService.class, UserInfoServiceImpl.class);
        SERVICES.put(FeedbackService.class, FeedbackServiceImpl.class);
        SERVICES.put(SpecialistService.class, SpecialistServiceImpl.class);
        SERVICES.put(ServiceService.class, ServiceServiceImpl.class);

    }

    private TransactionFactory factory;

    public ServiceFactoryImpl(TransactionFactory factory) throws PersistentException {
        this.factory = factory;
    }


    //    public Transaction getService(ServiceEnum service)
//            throws PersistentException {
//        switch (service) {
//            case USER:
//                return new UserInfoServiceImpl();
////            case TALON:
////                return new TalonServiceImpl();
//            case FEEDBACK:
//                return new FeedbackServiceImpl();
////            case SERVICE:
////                return ServiceServiceImpl();
////            case SPECIALIST:
////                return new SpecialistServiceImpl();
//            default:
//                LOGGER.error("There are not such service: " + service);
//                throw new PersistentException();
//        }
//    }

    @Override
    @SuppressWarnings("unchecked")
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


    public void close() {
        factory.close();

    }
}

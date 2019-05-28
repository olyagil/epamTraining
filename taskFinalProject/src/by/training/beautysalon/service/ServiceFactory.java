package by.training.beautysalon.service;

import by.training.beautysalon.dao.mysql.DaoFactory;
import by.training.beautysalon.service.impl.EmployeeServiceImpl;
import by.training.beautysalon.service.impl.FeedbackServiceImpl;
import by.training.beautysalon.service.impl.ServiceServiceImpl;
import by.training.beautysalon.service.impl.TalonServiceImpl;
import by.training.beautysalon.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiceFactory {

    private final DaoFactory factory;

    public ServiceFactory(DaoFactory daoFactory) {
        this.factory = daoFactory;

    }

    public UserServiceImpl getUserService() {
        return new UserServiceImpl(factory.getUserDao());
    }

    public EmployeeServiceImpl getEmployeeService() {
        return new EmployeeServiceImpl(factory.getEmployeeDao());
    }

    public ServiceServiceImpl getServiceService() {
        return new ServiceServiceImpl(factory.getServiceDao());
    }

    public TalonServiceImpl getTalonService() {
        return new TalonServiceImpl(factory.getTalonDao());
    }

    public FeedbackServiceImpl getFeedbackService() {
        return new FeedbackServiceImpl(factory.getFeedbackDao());
    }

    public void close() {
        factory.close();
    }
}

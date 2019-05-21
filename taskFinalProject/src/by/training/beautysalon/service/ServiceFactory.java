package by.training.beautysalon.service;

import by.training.beautysalon.service.impl.EmployeeServiceImpl;
import by.training.beautysalon.service.impl.FeedbackServiceImpl;
import by.training.beautysalon.service.impl.ServiceServiceImpl;
import by.training.beautysalon.service.impl.TalonServiceImpl;
import by.training.beautysalon.service.impl.UserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory() {

    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserServiceImpl getUserService() {
        return new UserServiceImpl();
    }

    public EmployeeServiceImpl getEmployeeService() {
        return new EmployeeServiceImpl();
    }

    public ServiceServiceImpl getServiceService() {
        return new ServiceServiceImpl();
    }

    public TalonServiceImpl getTalonService() {
        return new TalonServiceImpl();
    }

    public FeedbackServiceImpl getFeedbackService() {
        return new FeedbackServiceImpl();
    }
}

package by.training.beautysalon.service;

import by.training.beautysalon.dao.mysql.DaoFactory;
import by.training.beautysalon.service.impl.EmployeeServiceImpl;
import by.training.beautysalon.service.impl.FeedbackServiceImpl;
import by.training.beautysalon.service.impl.ServiceServiceImpl;
import by.training.beautysalon.service.impl.TalonServiceImpl;
import by.training.beautysalon.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class ServiceFactory {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory() {

    }

    protected DaoFactory factory = DaoFactory.getInstance();

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

    public void close() {
        factory.close();
    }
}

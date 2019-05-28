package by.training.beautysalon.command.guest;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.DataBaseException;
import by.training.beautysalon.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeesCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String EMPLOYEES = "employees";

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        EmployeeService service = serviceFactory.getEmployeeService();
        request.setAttribute(EMPLOYEES, service.find());
        LOGGER.debug("Get list of employees.");
        return null;
    }
}

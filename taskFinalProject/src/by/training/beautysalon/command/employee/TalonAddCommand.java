package by.training.beautysalon.command.employee;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.CommandEnum;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.EmployeeService;
import by.training.beautysalon.service.ServiceService;
import by.training.beautysalon.service.TalonService;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TalonAddCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        UserService userService = serviceFactory.getUserService();
        ServiceService service = serviceFactory.getServiceService();
        EmployeeService employeeService = serviceFactory.getEmployeeService();
        HttpSession session = request.getSession();
        try {
            LOGGER.debug("USER ID: " + session.getAttribute("id"));
            Integer id = (Integer) session.getAttribute("id");
            Role role = Role.getById((Integer) session.getAttribute("role"));

            switch (role) {
                case EMPLOYEE:
                    request.setAttribute("employees", userService.find(id));
                    break;
                case ADMINISTRATOR:
                    request.setAttribute("employees", employeeService.find());
            }
            request.setAttribute("services", service.find());
            request.setAttribute("clients", userService.find());
        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id" + e);
        }
        return new Forward(CommandEnum.TALON_ADD.getName(), false);
    }
}

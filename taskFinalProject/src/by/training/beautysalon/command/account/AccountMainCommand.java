package by.training.beautysalon.command.account;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.CommandEnum;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.EmployeeService;
import by.training.beautysalon.service.ServiceFactory;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccountMainCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        HttpSession session = request.getSession(false);
        Role role = Role.getById((Integer) session.getAttribute("role"));
        Integer id = (Integer) session.getAttribute("id");
        LOGGER.debug("User id: " + id + " with role: " + role);
        if (role.equals(Role.EMPLOYEE)) {
            EmployeeService service = ServiceFactory.getInstance().getEmployeeService();
            request.setAttribute("loggedUser", service.find(id));
            LOGGER.debug("Employee: " + service.find(id));
        } else {
            UserService service = ServiceFactory.getInstance().getUserService();
            request.setAttribute("loggedUser", service.find(id));
            LOGGER.debug("User: " + service.find(id));
        }

        return new Forward(CommandEnum.ACCOUNT_MAIN.getName(), false);
    }
}

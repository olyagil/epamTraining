package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.EmployeeService;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserViewCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {

//        UserService userService = factory.getService(UserService.class);
        UserService userService = serviceFactory.getUserService();

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Role role =
                    Role.getById(Integer.parseInt(request.getParameter("role")));
            LOGGER.debug("User id: " + id + " role: " + role);

            if (role == Role.SPECIALIST) {
//                EmployeeService service = factory.getService(EmployeeService.class);
                EmployeeService service = serviceFactory.getEmployeeService();
                request.setAttribute("user", service.find(id));
            } else {
                request.setAttribute("user", userService.find(id));
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Can't determinate the id of user");
            throw new PersistentException(e);

        }
        return null;
    }
}
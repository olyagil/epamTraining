package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDeleteCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        try {
            UserService service = serviceFactory.getUserService();
            Integer id = Integer.parseInt(request.getParameter("userId"));
            Role role = Role.getById(Integer.parseInt(request.getParameter(
                    "userRole")));

            service.delete(id);

            switch (role) {
                case EMPLOYEE:
                    return new Forward("/employee/list.html");
                case CLIENT:
                    return new Forward("/client/list.html");
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Can't delete user with id ");
            throw new PersistentException(e);
        }
        return new Forward("/client/list.html");

    }
}

package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.domain.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.SpecialistService;
import by.training.beautysalon.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserViewCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        LOGGER.debug("User view");
        LOGGER.debug("User id param: " + request.getParameter("id"));
        LOGGER.debug("User id attr: " + request.getAttribute("id"));
        LOGGER.debug("User role param: " + request.getParameter("role"));
        LOGGER.debug("User role attr: " + request.getAttribute("role"));

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Role role =
                    Role.getById(Integer.parseInt(request.getParameter("role")));
            LOGGER.debug("User id: " + id + " role: " + role);

            switch (role) {
                case SPECIALIST:
                    SpecialistService specialistService =
                            factory.getService(SpecialistService.class);
                    request.setAttribute("user2", specialistService.find(id));
                    break;
                case ADMINISTRATOR:
                case CLIENT:
                    UserInfoService userService =
                            factory.getService(UserInfoService.class);
                    UserInfo user = userService.find(id);
                    request.setAttribute("user2", user);
                    break;
            }
        } catch (
                NumberFormatException e) {
            LOGGER.error("Can't determinate the id of user");
            throw new PersistentException(e);

        }
        return null;
    }
}
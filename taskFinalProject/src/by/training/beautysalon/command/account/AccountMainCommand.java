package by.training.beautysalon.command.account;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.domain.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.SpecialistService;
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
        if (role.equals(Role.SPECIALIST)) {
            SpecialistService specialistService =
                    factory.getService(SpecialistService.class);
            request.setAttribute("loggedUser", specialistService.find(id));
            LOGGER.debug("Employee: " + specialistService.find(id));
        } else {
            UserService service = factory.getService(UserService.class);
            request.setAttribute("loggedUser", service.find(id));
            LOGGER.debug("User: " + service.find(id));
        }

        return null;
    }
}

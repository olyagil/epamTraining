package by.training.beautysalon.command.specialist;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.ServiceService;
import by.training.beautysalon.service.TalonService;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TalonListCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        try {
            TalonService talonService = factory.getService(TalonService.class);
            ServiceService service = factory.getService(ServiceService.class);
            UserService userService = factory.getService(UserService.class);
            HttpSession session = request.getSession();
            LOGGER.debug("TALON ID: " + session.getAttribute("id"));
            Integer id = (Integer) session.getAttribute("id");
            request.setAttribute("talons", talonService.findBySpecialist(id));
            request.setAttribute("clients", userService.find());
            request.setAttribute("services", service.find());
            LOGGER.debug(userService.find());
        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id" + e);
        }
        return null;
    }
}
package by.training.beautysalon.command.employee;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.domain.Talon;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.ServiceService;
import by.training.beautysalon.service.TalonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TalonEditCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        try {
            Integer id = (Integer) request.getAttribute("id");
            if (id == null) {
                id = Integer.parseInt(request.getParameter("id"));
            }
            TalonService talonService = factory.getService(TalonService.class);
            ServiceService service = factory.getService(ServiceService.class);
            LOGGER.debug("ID: " + id);
            Talon talon = talonService.find(id);
            request.setAttribute("talon", talon);
            request.setAttribute("services", service.find());
        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id", e);
        }
        return null;
    }
}

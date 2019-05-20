package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.domain.Service;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.ServiceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceEditCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        try {
            Integer id = (Integer) request.getAttribute("id");
            if (id == null) {
                id = Integer.parseInt(request.getParameter("id"));
            }
            ServiceService service =
                    factory.getService(ServiceService.class);
            Service serv = service.find(id);
            LOGGER.debug("SERVICE: " + serv);
            request.setAttribute("service", serv);

        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id", e);
        }


        return null;
    }
}

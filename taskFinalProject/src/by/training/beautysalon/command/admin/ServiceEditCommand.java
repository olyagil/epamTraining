package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.Service;
import by.training.beautysalon.exception.DataBaseException;
import by.training.beautysalon.service.ServiceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * The class {@code ServiceEditCommand} is used for editing service.
 */
public class ServiceEditCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SERVICE_ID = "serviceId";
    private static final String SERVICE = "service";

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        try {
            Integer id = (Integer) request.getAttribute(SERVICE_ID);
            if (id == null) {
                id = Integer.parseInt(request.getParameter(SERVICE_ID));
            }
            ServiceService service = serviceFactory.getServiceService();
            Service serv = service.find(id);
            request.setAttribute(SERVICE, serv);

        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id", e);
            return new Forward("/service/list.html");
        }
        return null;
    }
}

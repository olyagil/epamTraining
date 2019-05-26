package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.CommandEnum;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.Service;
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
            Integer id = (Integer) request.getAttribute("serviceId");
            if (id == null) {
                id = Integer.parseInt(request.getParameter("serviceId"));
            }
            ServiceService service = serviceFactory.getServiceService();
            Service serv = service.find(id);
            request.setAttribute("service", serv);

        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id", e);
        }


        return new Forward(CommandEnum.SERVICE_EDIT.getName(), false);
    }
}

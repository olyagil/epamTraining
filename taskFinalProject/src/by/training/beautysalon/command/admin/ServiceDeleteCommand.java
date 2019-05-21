package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.Service;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.ServiceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceDeleteCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/account/service/list.html");

//        ServiceService service = factory.getService(ServiceService.class);
        ServiceService service = serviceFactory.getServiceService();
        Integer id = Integer.parseInt(request.getParameter("id"));

        Service serv = service.find(id);
        LOGGER.debug("Trying to delete the id: " + id + " which is " +
                "service: " + service);
        if (serv != null) {
            service.delete(id);
        }

        return forward;
    }
}

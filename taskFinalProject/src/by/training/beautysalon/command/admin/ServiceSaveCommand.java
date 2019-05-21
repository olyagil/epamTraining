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

public class ServiceSaveCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/service/edit.html");
        ServiceService service = serviceFactory.getServiceService();
        Service serv = new Service();
        String id = request.getParameter("id");
        if (id != null) {
            serv.setId(Integer.parseInt(id));
        }
        LOGGER.debug("ID: " + id);
        serv.setName(request.getParameter("name"));
        serv.setDescription(request.getParameter("description"));
        serv.setPrice(Double.parseDouble(request.getParameter("price")));
        serv.setDuration(Double.parseDouble(request.getParameter("duration")));
        service.save(serv);
        LOGGER.debug("SERVICE: " + serv);
//        forward.getAttributes().put("id", serv.getId());

        return forward;
    }
}

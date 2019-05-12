package by.training.beautysalon.command.guest;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.ServiceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServicesCommand extends Command {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {

        ServiceService service =
                factory.getService(ServiceService.class);
        request.setAttribute("services", service.find());
        return null;
    }
}

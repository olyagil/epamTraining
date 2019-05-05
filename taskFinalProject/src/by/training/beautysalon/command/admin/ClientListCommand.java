package by.training.beautysalon.command.admin;

import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientListCommand extends AdminCommand {

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        UserService service = factory.getService(UserService.class);
        request.setAttribute("clients", service.findAll());

        return null;
    }
}

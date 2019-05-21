package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDeleteCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/client/list.html");
        try {
//            UserService service = factory.getService(UserService.class);
            UserService service = serviceFactory.getUserService();
            LOGGER.debug("ID: " + request.getParameter("id"));
            Integer id = Integer.parseInt(request.getParameter("id"));
            service.delete(id);

        } catch (NumberFormatException e) {
            LOGGER.error("Can't delete user with id ");
            throw new PersistentException(e);
        }


        return forward;
    }
}

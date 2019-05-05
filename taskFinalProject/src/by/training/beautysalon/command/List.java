package by.training.beautysalon.command;

import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class List extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Command.Forward exec(HttpServletRequest request,
                                HttpServletResponse response)
            throws PersistentException {
        UserService service = factory.getService(UserService.class);
        request.setAttribute("clients", service.findAll());
        LOGGER.debug("Get list of users: " + service.findAll());

        return null;
    }
}

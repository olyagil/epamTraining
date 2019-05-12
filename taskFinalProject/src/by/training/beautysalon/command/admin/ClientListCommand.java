package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientListCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request,
                                  HttpServletResponse response) throws PersistentException {
        UserInfoService service = factory.getService(UserInfoService.class);
        request.setAttribute("clients", service.find());
        LOGGER.debug("Get list of users: " + service.find());
        return null;
    }
}

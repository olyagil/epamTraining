package by.training.beautysalon.command;

import by.training.beautysalon.domain.User;
import by.training.beautysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();


    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response)
            throws PersistentException {

        User user = getAuthorizedUser();
        LOGGER.info("User \"%s\" is logged out.", user.getLogin());
        request.getSession(false).invalidate();
        return new Forward("/main.jsp");
    }
}

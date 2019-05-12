package by.training.beautysalon.command;

import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();


    @Override
    public Forward execute(HttpServletRequest request,
                           HttpServletResponse response)
            throws PersistentException {
//        UserInfo user = getAuthorizedUser();
//        LOGGER.debug(String.format("user \"%s\" is logged out", user.getLogin()));
        LOGGER.debug(String.format("user \"%s\" is logged out", "TestUser") );
        request.getSession(false).invalidate();
        LOGGER.debug(String.format("user \"%s\" is logged out", "TestUser") );
        return new Forward("/index.jsp");
    }
}

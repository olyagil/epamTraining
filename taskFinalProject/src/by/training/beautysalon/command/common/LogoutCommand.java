package by.training.beautysalon.command.common;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.CommandEnum;
import by.training.beautysalon.command.Forward;
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

        request.getSession(false).invalidate();
        LOGGER.debug("User is logged out.");
        return new Forward(CommandEnum.MAIN.getName(), false);
    }
}

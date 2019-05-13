package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDeleteCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();   @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        return null;
    }
}

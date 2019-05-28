package by.training.beautysalon.command.account;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.exception.DataBaseException;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The class {@code AccountEditCommand} is used for editing user account.
 */
public class AccountEditCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String ID = "id";
    private static final String USER = "user";

    @Override
    public Forward execute(HttpServletRequest request,
                           HttpServletResponse response) throws DataBaseException {
        HttpSession session = request.getSession(false);

        try {

            Integer id = (Integer) session.getAttribute(ID);

            LOGGER.debug("The id of the user: " + id);

            UserService service = serviceFactory.getUserService();
            User user = service.find(id);
            if (user != null) {
                request.setAttribute(USER, user);

            }
        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id", e);
            throw new DataBaseException(e);
        }
        return null;

    }
}

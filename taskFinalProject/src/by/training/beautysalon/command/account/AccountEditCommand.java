package by.training.beautysalon.command.account;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.CommandEnum;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccountEditCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();
//TODO разделить info and password
    @Override
    public Forward execute(HttpServletRequest request,
                           HttpServletResponse response) throws PersistentException {
        HttpSession session = request.getSession(false);

        try {
            Integer id = (Integer) session.getAttribute("id");

            LOGGER.debug("The id of the user: " + id);

            UserService service = serviceFactory.getUserService();
            User user = service.find(id);
            if (user != null) {
                request.setAttribute("user", user);

            }
        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id", e);
            throw new PersistentException(e);
        }
        return new Forward(CommandEnum.ACCOUNT_EDIT_INFO.getName(), false);

    }
}

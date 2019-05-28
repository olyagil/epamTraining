package by.training.beautysalon.command.account;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.entity.enumeration.Gender;
import by.training.beautysalon.exception.DataBaseException;
import by.training.beautysalon.service.UserService;
import by.training.beautysalon.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * The class {@code AccountSaveAvatarCommand} is used for saving avatar of user.
 */
public class AccountSaveAvatarCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String ID = "id";
    private static final String IMG = "img";

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {

        Integer id = (Integer) request.getSession().getAttribute(ID);
        if (id != null) {
            User user = new User();
            user.setId(id);
            UserService service = serviceFactory.getUserService();
            try {
                user.setAvatar(UserValidator.getAvatar(request.getPart(IMG),
                        Gender.FEMALE));
                service.save(user);
            } catch (IOException | ServletException | SQLException e) {
                LOGGER.error("Can't read the image from file", e);
                throw new DataBaseException(e);
            }
        }
        return new Forward("/account/edit/info.html");
    }
}

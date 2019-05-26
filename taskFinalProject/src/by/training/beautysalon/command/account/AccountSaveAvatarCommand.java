package by.training.beautysalon.command.account;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.entity.enumeration.Gender;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserService;
import by.training.beautysalon.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
//TODO add gender
public class AccountSaveAvatarCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {

        Integer id = (Integer) request.getSession().getAttribute("id");
        User user = new User();
        user.setId(id);
        UserService service = serviceFactory.getUserService();
        try {
            user.setAvatar(UserValidator.getAvatar(request.getPart("img"),
                    Gender.MALE));
            service.save(user);
        } catch (IOException | ServletException | SQLException e) {
            LOGGER.error("Can't read the image from file", e);
            throw new PersistentException(e);
        }
        return new Forward("/account/edit/info.html");
    }
}

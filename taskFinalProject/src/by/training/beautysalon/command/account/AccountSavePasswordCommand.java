package by.training.beautysalon.command.account;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.entity.enumeration.Gender;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class AccountSavePasswordCommand extends Command {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/account/edit/password.html");
        HttpSession session = request.getSession();

        String login = (String) session.getAttribute("login");
        UserService service = serviceFactory.getUserService();
        String oldPassword = request.getParameter("old-password");
        String password = request.getParameter("password");
        if (oldPassword != null && password != null) {
            User user = service.find(login, oldPassword);
            if (user != null) {
                user.setPassword(password);
                LOGGER.debug("user: " + user);
                service.save(user);
                session.setAttribute("success_save_password",
                        "The password is successful changed!");

            } else {
                session.setAttribute("failure_save_password",
                        "The password is not recognized! Repeat password, please.");
            }
        }
        return forward;
    }
}

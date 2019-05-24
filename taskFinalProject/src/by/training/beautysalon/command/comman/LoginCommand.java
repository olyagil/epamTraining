package by.training.beautysalon.command.comman;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.ServiceFactory;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand extends Command {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request,
                           HttpServletResponse response)
            throws PersistentException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login != null && password != null) {
            UserService service = ServiceFactory.getInstance().getUserService();

            User user = service.find(login, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("id", user.getId());
                session.setAttribute("login", user.getLogin());
                session.setAttribute("role", user.getRole().getId());
                LOGGER.info(String.format("user \"%s\" is logged in " +
                                "from %s (%s:%s)", login, request.getRemoteAddr(),
                        request.getRemoteHost(), request.getRemotePort()));
                return new Forward("/account/main.html");
            } else {
                request.setAttribute("message", "Имя пользовтеля или" +
                        " пароль не опознаны");
                LOGGER.info(String.format("user \"%s\" unsuccessfully tried " +
                                "to log in  from %s (%s:%s)", login,
                        request.getRemoteAddr(), request.getRemoteHost(),
                        request.getRemotePort()));
            }
        }
        return null;
    }

}

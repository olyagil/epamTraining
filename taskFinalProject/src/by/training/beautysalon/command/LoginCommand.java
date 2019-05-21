package by.training.beautysalon.command;

import by.training.beautysalon.entity.User;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.ServiceFactory;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginCommand extends Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private static Map<Role, List<MenuItem>> menu = new ConcurrentHashMap<>();

    static {
        menu.put(Role.ADMINISTRATOR, new ArrayList<>(Arrays.asList(
                new MenuItem("/client/list.html", "Список " +
                        "клиентов"),
                new MenuItem("/employee/list.html", "Список " +
                        "сотрудников"),
                new MenuItem("/service/list.html", "Список услуг")
        )));
        menu.put(Role.SPECIALIST, new ArrayList<>(Arrays.asList(
                new MenuItem("/account/feedback.html", "Отзывы"),
                new MenuItem("/account/talon/list.html", "Мои талоны")
        )));
        menu.put(Role.CLIENT, new ArrayList<>(Arrays.asList(
                new MenuItem("/account/talons.html", "Мои талоны"),
                new MenuItem("/account/feedback/list.html", "Отзывы")
        )));
    }

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
                session.setAttribute("role", user.getRole().getId());
                session.setAttribute("menu", menu.get(user.getRole()));
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

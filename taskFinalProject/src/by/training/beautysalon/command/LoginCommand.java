package by.training.beautysalon.command;

import by.training.beautysalon.domain.Role;
import by.training.beautysalon.domain.User;
import by.training.beautysalon.exception.PersistentException;
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
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LoginCommand extends Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private static Map<Role, List<MenuItem>> menu = new ConcurrentHashMap<>();

    static {
        menu.put(Role.ADMINISTRATOR, new ArrayList<>(Arrays.asList(
                new MenuItem("/search/client/list.html", "поиск клиентов"),
                new MenuItem("/search/specialist/list.html", "поиск " +
                        "сотрудников")
        )));
        menu.put(Role.SPECIALIST, new ArrayList<>(Arrays.asList(
                new MenuItem("/client/list.html", "клиенты"),
                new MenuItem("/talon/list.html", "талоны")
        )));
        menu.put(Role.CLIENT, new ArrayList<>(Arrays.asList(
                new MenuItem("/talon/list.html", "талоны"),
                new MenuItem("/specialist/list.html", "специалисты")
        )));
        menu.put(Role.GUEST, new ArrayList<>(Arrays.asList(
                new MenuItem("/service/list.html", "услуги"),
                new MenuItem("/specialist/list.html", "специалисты")
        )));
    }

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response)
            throws PersistentException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login != null && password != null) {
            UserService service = factory.getService(UserService.class);
            User user = service.findByLoginAndPassword(login, password);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("authorizedUser", user);
                session.setAttribute("menu", menu.get(user.getRole()));

                LOGGER.info(String.format("user \"%s\" is logged in " +
                                "from %s (%s:%s)", login, request.getRemoteAddr(),
                        request.getRemoteHost(), request.getRemotePort()));
                return new Forward("/index.jsp");
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

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}

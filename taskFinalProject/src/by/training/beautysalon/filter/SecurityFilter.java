package by.training.beautysalon.filter;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.domain.enumeration.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecurityFilter implements Filter {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;

            HttpSession session = httpRequest.getSession(false);

            Command command = (Command) httpRequest.getAttribute("action");
            LOGGER.debug("COMMAND: " + command.getName());

            if (!guestCommand(command.getName())) {
                if (session.getAttribute("role") != null) {
                    Role role = Role.getById((Integer) session.getAttribute("role"));
                    if (userCommand(command.getName())) {
                        chain.doFilter(request, response);
                    } else if (role == Role.ADMINISTRATOR
                            && adminCommand(command.getName())) {
                        chain.doFilter(request, response);

                    } else if (role == Role.SPECIALIST
                            && specialistCommand(command.getName())) {
                        chain.doFilter(request, response);

                    } else if (role == Role.CLIENT
                            && clientCommand(command.getName())) {
                        chain.doFilter(request, response);

                    } else {
                        LOGGER.info("Trying to access forbidden recourse: "
                                + command.getName());
                        httpResponse.sendRedirect(httpRequest.getContextPath() +
                                "/jsp/404page.jsp");
                    }
                } else {
                    LOGGER.info("Trying to access forbidden recourse: "
                            + command.getName());
                    //TODO add message
                    httpResponse.sendRedirect(httpRequest.getContextPath() +
                            "/login.html");


                }
            } else {
                LOGGER.debug("It's a guest command " + command.getName());
                chain.doFilter(request, response);
            }

        }

    }

    private boolean clientCommand(String commandName) {
        return false;
    }

    private boolean specialistCommand(String commandName) {

        return false;
    }


    @Override
    public void destroy() {
    }

    private boolean adminCommand(String command) {
        List<String> commands = new ArrayList<>();

        commands.add("/account/specialist/list");
        commands.add("/account/specialist/edit");
        commands.add("/account/specialist/save");
        commands.add("/account/specialist/delete");

        commands.add("/account/client/list");
        commands.add("/account/client/edit");
        commands.add("/account/client/save");
        commands.add("/account/client/delete");

        commands.add("/account/service/list");
        commands.add("/account/service/edit");
        commands.add("/account/service/delete");
        commands.add("/account/service/save");

        return commands.contains(command);
    }

    private boolean guestCommand(String command) {
        return (Arrays.asList("/specialists",
                "/services", "/feedback",
                "/login", "/signup",
                "/language")).contains(command);
    }

    private boolean userCommand(String command) {
        List<String> commands = Arrays.asList("/account/main",
                "/account/edit/info", "/account/edit/password",
                "/logout");
        return commands.contains(command);
    }
}

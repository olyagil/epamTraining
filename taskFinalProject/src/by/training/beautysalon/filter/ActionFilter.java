package by.training.beautysalon.filter;

import by.training.beautysalon.command.CommandFactory;
import by.training.beautysalon.command.LanguageCommand;
import by.training.beautysalon.command.MainCommand;
import by.training.beautysalon.command.account.AccountEditCommand;
import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.LoginCommand;
import by.training.beautysalon.command.LogoutCommand;
import by.training.beautysalon.command.SignUpCommand;
import by.training.beautysalon.command.account.AccountMainCommand;
import by.training.beautysalon.command.account.AccountSaveAvatarCommand;
import by.training.beautysalon.command.account.AccountSaveCommand;
import by.training.beautysalon.command.admin.*;
import by.training.beautysalon.command.guest.FeedBackCommand;
import by.training.beautysalon.command.guest.ServicesCommand;
import by.training.beautysalon.command.guest.EmployeesCommand;
import by.training.beautysalon.command.employee.TalonDeleteCommand;
import by.training.beautysalon.command.employee.TalonEditCommand;
import by.training.beautysalon.command.employee.TalonListCommand;
import by.training.beautysalon.command.employee.TalonSaveCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActionFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger();
//    private static Map<String, Class<? extends Command>> actions = new ConcurrentHashMap<>();
//
//    static {
//        actions.put("/", MainCommand.class);
//        actions.put("/index", MainCommand.class);
//        actions.put("/account/main", AccountMainCommand.class);
//        actions.put("/language", LanguageCommand.class);
//
//        actions.put("/login", LoginCommand.class);
//        actions.put("/logout", LogoutCommand.class);
//        actions.put("/signup", SignUpCommand.class);
//        actions.put("/specialists", EmployeesCommand.class);
//        actions.put("/services", ServicesCommand.class);
//        actions.put("/feedback", FeedBackCommand.class);
//
//        actions.put("/account", AccountMainCommand.class);
//        actions.put("/account/edit/info", AccountEditCommand.class);
//        actions.put("/account/edit/password", AccountEditCommand.class);
//        actions.put("/account/save", SignUpCommand.class);
//        actions.put("/account/img/save", AccountSaveAvatarCommand.class);
//        actions.put("/account/save/info", AccountSaveCommand.class);
//
//        actions.put("/account/client/list", ClientListCommand.class);
//        actions.put("/account/add", EmployeeEditCommand.class);
//        actions.put("/account/user/save", EmployeeSaveCommand.class);
//        actions.put("/account/user/edit", EmployeeEditCommand.class);
//        actions.put("/account/user/view", UserViewCommand.class);
//        actions.put("/account/user/delete", UserDeleteCommand.class);
//        actions.put("/account/employee/list", EmployeeListCommand.class);
//
//        actions.put("/account/service/list", ServiceListCommand.class);
//        actions.put("/account/service/edit", ServiceEditCommand.class);
//        actions.put("/account/service/save", ServiceSaveCommand.class);
//        actions.put("/account/service/delete", ServiceDeleteCommand.class);
//
//        actions.put("/account/talon/list", TalonListCommand.class);
//        actions.put("/account/talon/edit", TalonEditCommand.class);
//        actions.put("/account/talon/save", TalonSaveCommand.class);
//        actions.put("/account/talon/delete", TalonDeleteCommand.class);
//
//
//    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String contextPath = httpRequest.getContextPath();
            String uri = httpRequest.getRequestURI();
            LOGGER.debug("CONTEXT PATH: " + contextPath + " URI: " + uri);

            LOGGER.debug(String.format("Starting of processing of request for URI \"%s\"", uri));
            int beginAction = contextPath.length() + 1;
            int endAction = uri.lastIndexOf('.');
            String commandName;
            if (endAction >= 0) {
                commandName = uri.substring(beginAction, endAction);
            } else {
                commandName = uri.substring(beginAction);
            }

            Command command = CommandFactory.create(commandName);
            LOGGER.debug("command: " + commandName + " class: " + command);

                command.setName(commandName);
                httpRequest.setAttribute("command", command);
                LOGGER.debug("Before filter command: " + commandName);

                chain.doFilter(request, response);

//            } catch (InstantiationException | IllegalAccessException | NullPointerException e) {
//                LOGGER.error("It is impossible to create action handler object",
//                        e);
//                httpRequest.setAttribute("error", String.format("Запрошенный адрес %s не может быть обработан сервером", uri));
//                httpRequest.getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(request, response);
//            }
        } else {
            LOGGER.error("It is impossible to use HTTP filter");
            request.getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}

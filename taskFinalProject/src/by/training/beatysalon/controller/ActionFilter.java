package by.training.beatysalon.controller;

import by.training.beatysalon.action.Action;
import by.training.beatysalon.action.List;
import by.training.beatysalon.action.LoginAction;
import by.training.beatysalon.action.MainAction;
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
    private static Map<String, Class<? extends Action>> actions =
            new ConcurrentHashMap<>();

    static {
        actions.put("/", MainAction.class);
        actions.put("index", MainAction.class);
        actions.put("login", LoginAction.class);
        actions.put("list", List.class);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            String contextPath = request.getContextPath();
            String uri = request.getRequestURI();
            int beginAction = contextPath.length();
            int endAction = uri.lastIndexOf('.');
            String actionName;
            if (endAction >= 0) {
                actionName = uri.substring(beginAction, endAction);
            } else {
                actionName = uri.substring(beginAction);
            }
            Class<? extends Action> actionClass = actions.get(actionName);
            try {
                Action action = actionClass.newInstance();
                action.setName(actionName);
                request.setAttribute("action", action);
                filterChain.doFilter(servletRequest, servletResponse);

            } catch (InstantiationException | IllegalAccessException | NullPointerException e) {
                LOGGER.error("It is impossible to create action handler object",
                        e);
                request.setAttribute("error", String.format("Запрошенный " +
                        "адрес %s не может быть обработан сервером", uri));
                request.getServletContext().getRequestDispatcher("/WEB-INF" +
                        "/jsp/error.jsp").forward(servletRequest, servletResponse);
            }
        } else {
            LOGGER.error("It is impossible to use HTTP filter");
            servletRequest.getServletContext().getRequestDispatcher("/WEB-INF/jsp" +
                    "/error.jsp").forward(servletRequest, servletResponse);

        }
    }

    @Override
    public void destroy() {

    }
}

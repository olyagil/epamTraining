package by.training.beatysalon.controller;

import by.training.beatysalon.action.Action;
import by.training.beatysalon.action.ActionManager;
import by.training.beatysalon.action.ActionManagerFactory;
import by.training.beatysalon.dao.mysql.TransactionFactoryImpl;
import by.training.beatysalon.dao.pool.ConnectionPool;
import by.training.beatysalon.exception.PersistentException;
import by.training.beatysalon.service.ServiceFactory;
import by.training.beatysalon.service.ServiceFactoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger();
    private static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:8080" +
            "/salon_db?useUnicode=true&characterEncoding=UTF-8";
    private static final String DB_USER = "salon_user";
    private static final String DB_PASSWORD = "salon_password";
    private static final int DB_POOL_START_SIZE = 10;
    private static final int DB_POOL_MAX_SIZE = 1000;
    private static final int DB_POOL_CHECK_CONNECTION_TIMEOUT = 0;

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {
        Action action = (Action) request.getAttribute("action");
        System.out.println(request.getAttribute("action"));
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                Map<String, Object> attributes = (Map<String, Object>)
                        session.getAttribute("redirectedData");
                if (attributes != null) {
                    for (String key : attributes.keySet()) {
                        request.setAttribute(key, attributes.get(key));
                        LOGGER.info(key);
                        System.out.println(key);
                    }
                    session.removeAttribute("redirectedData");
                }
            }
            ActionManager actionManager =
                    ActionManagerFactory.getManager(getFactory());
            Action.Forward forward = actionManager.execute(action, request, response);
            actionManager.close();
            if (session != null && forward != null && !forward.getAttributes().isEmpty()) {
                session.setAttribute("redirectedData", forward.getAttributes());
            }
            String requestedUri = request.getRequestURI();
            if (forward != null && forward.isRedirect()) {
                String redirectedUri = request.getContextPath() + forward.getForward();
                LOGGER.debug(String.format("Request for URI \"%s\" id redirected " +
                        "to URI \"%s\"", requestedUri, redirectedUri));
                response.sendRedirect(redirectedUri);
            } else {
                String jspPage;
                if (forward != null) {
                    jspPage = forward.getForward();
                } else {
                    jspPage = action.getName() + ".jsp";
                }
                jspPage = "/WEB-INF/jsp" + jspPage;
                LOGGER.debug(String.format("Request for URI \"%s\" is forwarded " +
                        "to JSP \"%s\"", requestedUri, jspPage));
                getServletContext().getRequestDispatcher(jspPage).forward(request, response);
            }
        } catch (PersistentException e) {
            LOGGER.error("It is impossible to process request", e);
            request.setAttribute("error", "Ошибка обработки данных");
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }


    private ServiceFactory getFactory() throws PersistentException {

        return new ServiceFactoryImpl(new TransactionFactoryImpl());
    }

    @Override
    public void init() throws ServletException {
        try {
            ConnectionPool.getInstance().init(DB_DRIVER_CLASS, DB_URL, DB_USER,
                    DB_PASSWORD, DB_POOL_START_SIZE, DB_POOL_MAX_SIZE,
                    DB_POOL_CHECK_CONNECTION_TIMEOUT);
        } catch (PersistentException e) {
            LOGGER.error("Can't initialize application.");
            destroy();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }


}

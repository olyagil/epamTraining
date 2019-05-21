package by.training.beautysalon.controller;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.dao.connection.ConnectionPool;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
public class DispatcherServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Command command = (Command) request.getAttribute("command");
        LOGGER.debug(command.getName());

        try {
            command.setFactory(ServiceFactory.getInstance());
            Forward forward = command.execute(request, response);
            LOGGER.debug("forward: " + forward);
//            actionManager.close();

            String requestedUri = request.getRequestURI();
            LOGGER.debug("Requested Uri: " + requestedUri);
            LOGGER.debug("Context path: " + request.getContextPath());

            if (forward != null && forward.isRedirect()) {
                LOGGER.debug("Page: " + forward.getPage());
                String redirectedUri = request.getContextPath() + forward.getPage();
                LOGGER.debug(String.format("Request for URI \"%s\" is " +
                        "redirected to URI \"%s\"", requestedUri, redirectedUri));
                response.sendRedirect(redirectedUri);
            } else {
                String jspPage;
                if (forward != null) {
                    jspPage = forward.getPage();
                } else {
                    jspPage = command.getName() + ".jsp";
                }
                jspPage = "/jsp/" + jspPage;
                LOGGER.debug(String.format("Request for URI \"%s\" is forwarded " +
                        "to JSP \"%s\"", requestedUri, jspPage));
                getServletContext().getRequestDispatcher(jspPage).forward(request, response);
            }
        } catch (PersistentException e) {
            LOGGER.error("It is impossible to process request", e);
            request.setAttribute("error", "Ошибка обработки данных");
            getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(request, response);
        }

    }

    @Override
    public void init() throws ServletException {
        try {
            LOGGER.trace("Initializing application.");
            ConnectionPool.getInstance().init();
        } catch (PersistentException e) {
            LOGGER.error("Can't initialize application.");
            destroy();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        processRequest(req, resp);
    }


}

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
        LOGGER.debug("COMMAND: " + command.getName());
        ServiceFactory factory = ServiceFactory.getInstance();
        try {
            command.setFactory(factory);
            Forward forward = command.execute(request, response);
            factory.close();

            String requestedUri = request.getRequestURI();
            if (request.getMethod().equalsIgnoreCase("post")
                    || forward.isRedirect()) {
                String redirectedUri = request.getContextPath() + forward.getPage();
                LOGGER.debug(String.format("Request for URI \"%s\" id " +
                        "redirected to URI \"%s\"", requestedUri, redirectedUri));
                response.sendRedirect(redirectedUri);
            } else {
                String jspPage = "/jsp/" + forward.getPage() + ".jsp";
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
        LOGGER.debug("This is a get-method.");
        processRequest(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        LOGGER.debug("This is a post-method.");
        processRequest(req, resp);
    }


}

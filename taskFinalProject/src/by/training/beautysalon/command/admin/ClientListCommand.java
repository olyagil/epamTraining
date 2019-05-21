package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ClientListCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request,
                           HttpServletResponse response) throws PersistentException {
        UserService service = serviceFactory.getUserService();


//        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
//        int recordsPerPage = Integer.valueOf(request.getParameter("recordsPerPage"));

        if (request.getParameter("searchLogin") != null) {
            LOGGER.debug("searchLogin " + request.getAttribute("searchLogin"));
            String login = request.getParameter("searchLogin");
            request.setAttribute("clients", service.find(login));
            request.setAttribute("searchLogin", login);

            LOGGER.debug("Client with ths login # " + login + " : " + service.find(login));
        } else {
            List<User> userList = service.find();
            request.setAttribute("clients", userList);
            LOGGER.debug("Get list of users: " + userList);
//        int rows = service.countRows();
//        int nOfPages = rows / recordsPerPage;
//        if (nOfPages % recordsPerPage > 0) {
//            nOfPages++;
//        }

//        request.setAttribute("noOfPages", nOfPages);
//        request.setAttribute("currentPage", currentPage);
//        request.setAttribute("recordsPerPage", recordsPerPage);
        }
        return null;
    }
}

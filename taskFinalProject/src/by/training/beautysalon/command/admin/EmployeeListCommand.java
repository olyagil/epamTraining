package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.EmployeeService;
import by.training.beautysalon.service.UserService;
import by.training.beautysalon.utill.PaginationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeListCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int DEFAULT_CURRENT_PAGE = 1;
    private static final int RECORDS_PER_PAGE = 5;

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        EmployeeService service = serviceFactory.getEmployeeService();
        int currentPage;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.valueOf(request.getParameter("currentPage"));
        } else {
            currentPage = DEFAULT_CURRENT_PAGE;
        }
        int rows = service.countRows();
        int nOfPages = PaginationUtil.getNumOfPages(rows);
        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        LOGGER.debug("NUM OF PAGES: " + nOfPages);
        LOGGER.debug("rows: ", service.countRows());
        LOGGER.debug("currentPage: ", currentPage);
        if (request.getParameter("searchLogin") != null) {
            String login = request.getParameter("searchLogin");
            request.setAttribute("employees", service.find(login));
            request.setAttribute("searchLogin", login);
        } else {
            request.setAttribute("employees", service.find(currentPage, RECORDS_PER_PAGE));
            LOGGER.debug("Get list of specialists");
        }
        return null;
    }
}

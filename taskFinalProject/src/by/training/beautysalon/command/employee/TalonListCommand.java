package by.training.beautysalon.command.employee;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.TalonService;
import by.training.beautysalon.utill.PaginationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class TalonListCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int DEFAULT_CURRENT_PAGE = 1;
    private static final int RECORDS_PER_PAGE = 5;

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        TalonService service = serviceFactory.getTalonService();
        HttpSession session = request.getSession();

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

        try {
            LOGGER.debug("USER ID: " + session.getAttribute("id"));
            Integer id = (Integer) session.getAttribute("id");
            Role role = Role.getById((Integer) session.getAttribute("role"));
            if (request.getParameter("status") != null) {
                Boolean status = Boolean.valueOf(request.getParameter("status"));
                request.setAttribute("talons", service.find(status));
            } else if (request.getParameter("searchDate") != null) {
                Date date = Date.valueOf(request.getParameter("searchDate"));
                LOGGER.debug("DATE: " + date);
                request.setAttribute("talons", service.find(date));
                request.setAttribute("searchDate", date);
            } else {
                switch (role) {
                    case EMPLOYEE:
                        request.setAttribute("talons",
                                service.findByEmployee(id));
                        break;
                    case CLIENT:
                        request.setAttribute("talons", service.findByClient(id));
                        break;
                    case ADMINISTRATOR:
                        request.setAttribute("talons",
                                service.find(currentPage, RECORDS_PER_PAGE));
                }
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id" + e);
        }
        return null;
    }
}

package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.ServiceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceListCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int DEFAULT_CURRENT_PAGE = 1;
    private static final int RECORDS_PER_PAGE = 5;

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        int currentPage;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.valueOf(request.getParameter("currentPage"));
        } else {
            currentPage = DEFAULT_CURRENT_PAGE;
        }

        ServiceService service = factory.getService(ServiceService.class);

        int rows = service.getNumberOfRows();
        int nOfPages = rows / RECORDS_PER_PAGE;
        if (rows % RECORDS_PER_PAGE > 0) {
            nOfPages++;
        }
        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        LOGGER.debug("NUM OF PAGES: " + nOfPages);

        if (request.getParameter("searchName") != null) {
            String name = request.getParameter("searchName");
            request.setAttribute("services", service.find(name));
        } else {
            request.setAttribute("services", service.find(currentPage, RECORDS_PER_PAGE));
            LOGGER.debug("Get list if services");
        }
        return null;
    }
}

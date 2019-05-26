package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.CommandEnum;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.Service;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.ServiceService;
import by.training.beautysalon.utill.PaginationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ServiceListCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int DEFAULT_CURRENT_PAGE = 1;
    private static final int RECORDS_PER_PAGE = 5;

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        ServiceService service = serviceFactory.getServiceService();

        int currentPage;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.valueOf(request.getParameter("currentPage"));
        } else {
            currentPage = DEFAULT_CURRENT_PAGE;
        }

        int rows;
        if (request.getParameter("searchName") != null) {
            String name = request.getParameter("searchName");
            List<Service> serviceList = service.find(name);
            request.setAttribute("services", serviceList);
            rows = serviceList.size();
        } else {
            request.setAttribute("services", service.find(currentPage, RECORDS_PER_PAGE));
            rows = service.countRows();
            LOGGER.debug("Get list if services");
        }
        request.setAttribute("noOfPages", PaginationUtil.getNumOfPages(rows));
        request.setAttribute("currentPage", currentPage);
        return new Forward(CommandEnum.SERVICE_LIST.getName(), false);
    }
}

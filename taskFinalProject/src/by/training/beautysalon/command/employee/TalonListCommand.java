package by.training.beautysalon.command.employee;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.CommandEnum;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.Talon;
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
import java.util.List;

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

        int rows = 0;
        List<Talon> talonList;
        try {
            Integer id = (Integer) session.getAttribute("id");
            Role role = Role.getById((Integer) session.getAttribute("role"));
            if (request.getParameter("status") != null) {
                Boolean status = Boolean.valueOf(request.getParameter("status"));
                talonList = service.find(status);
                rows = 0;
                request.setAttribute("talons", talonList);
            } else if (request.getParameter("searchDate") != null) {
                Date date = Date.valueOf(request.getParameter("searchDate"));
                talonList = service.find(date);
                rows = 0;
                request.setAttribute("talons",talonList);
                request.setAttribute("searchDate", date);
            } else {
                switch (role) {
                    case EMPLOYEE:
                        talonList = service.findByEmployee(id);
                        request.setAttribute("talons", talonList);
                        rows = 0;
                        break;
                    case CLIENT:
                        talonList = service.findByClient(id);
                        request.setAttribute("talons", talonList);
                        rows = 0;
                        break;
                    case ADMINISTRATOR:
                        request.setAttribute("talons",
                                service.find(currentPage, RECORDS_PER_PAGE));
                        rows = service.countRows();
                }
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id" + e);
        }
        int nOfPages = PaginationUtil.getNumOfPages(rows);
        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);

        return new Forward(CommandEnum.TALON_LIST.getName(), false);
    }
}

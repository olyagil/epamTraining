package by.training.beautysalon.command.feedback;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.CommandEnum;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.FeedbackService;
import by.training.beautysalon.utill.PaginationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FeedBackListCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int DEFAULT_CURRENT_PAGE = 1;
    private static final int RECORDS_PER_PAGE = 5;

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        FeedbackService service = serviceFactory.getFeedbackService();
        HttpSession session = request.getSession();

        int currentPage;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.valueOf(request.getParameter("currentPage"));
        } else {
            currentPage = DEFAULT_CURRENT_PAGE;
        }
        int rows = 0;
        try {
            Integer id = (Integer) session.getAttribute("id");
            Role role = Role.getById((Integer) session.getAttribute("role"));

            switch (role) {
                case ADMINISTRATOR:
                    request.setAttribute("feedbacks",
                            service.find(currentPage, RECORDS_PER_PAGE));
                    rows = service.countRows();
                    break;
                case CLIENT:
                    request.setAttribute("feedbacks",
                            service.findByClientId(id));
                    rows = 0;
                    break;
                case EMPLOYEE:
                    request.setAttribute("feedbacks",
                            service.findBySpecialistId(id));
                    rows = 0;
                    break;
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id" + e);
        }

        request.setAttribute("noOfPages", PaginationUtil.getNumOfPages(rows));
        request.setAttribute("currentPage", currentPage);
        return new Forward(CommandEnum.FEEDBACK_LIST.getName(), false);
    }
}

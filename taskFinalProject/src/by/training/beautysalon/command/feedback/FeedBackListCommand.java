package by.training.beautysalon.command.feedback;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.DataBaseException;
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
    private static final String CURRENT_PAGE = "currentPage";
    private static final String ID = "id";
    private static final String ROLE = "role";
    private static final String FEEDBACKS = "feedbacks";
    private static final String NO_OF_PAGES = "noOfPages";

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        FeedbackService service = serviceFactory.getFeedbackService();
        HttpSession session = request.getSession();

        int currentPage;
        if (request.getParameter(CURRENT_PAGE) != null) {
            currentPage = Integer.valueOf(request.getParameter(CURRENT_PAGE));
        } else {
            currentPage = DEFAULT_CURRENT_PAGE;
        }
        int rows = 0;
        try {
            Integer id = (Integer) session.getAttribute(ID);
            Role role = Role.getById((Integer) session.getAttribute(ROLE));

            switch (role) {
                case ADMINISTRATOR:
                    request.setAttribute(FEEDBACKS,
                            service.find(currentPage, RECORDS_PER_PAGE));
                    rows = service.countRows();
                    break;
                case CLIENT:
                    request.setAttribute(FEEDBACKS,
                            service.findByClientId(id));
                    rows = 0;
                    break;
                case EMPLOYEE:
                    request.setAttribute(FEEDBACKS,
                            service.findBySpecialistId(id));
                    rows = 0;
                    break;
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id" + e);
        }

        request.setAttribute(NO_OF_PAGES, PaginationUtil.getNumOfPages(rows));
        request.setAttribute(CURRENT_PAGE, currentPage);
        return null;
    }
}

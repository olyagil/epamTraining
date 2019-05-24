package by.training.beautysalon.command.feedback;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.FeedbackService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FeedBackListCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        FeedbackService service = serviceFactory.getFeedbackService();
        HttpSession session = request.getSession();
        try {
            Integer id = (Integer) session.getAttribute("id");
            Role role = Role.getById((Integer) session.getAttribute("role"));

            switch (role) {
                case ADMINISTRATOR:
                    request.setAttribute("feedbacks", service.find());
                    break;
                case CLIENT:
                    request.setAttribute("feedbacks",
                            service.findByClientId(id));
                    break;
                case EMPLOYEE:
                    request.setAttribute("feedbacks",
                            service.findBySpecialistId(id));
                    break;
            }


        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id" + e);
        }
        return null;
    }
}

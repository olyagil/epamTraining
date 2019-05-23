package by.training.beautysalon.command.feedback;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.FeedbackService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedBackDeleteCommand extends Command {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        FeedbackService service = serviceFactory.getFeedbackService();
        String id = request.getParameter("feedbackId");
        if (id != null) {
            service.delete(Integer.parseInt(id));
            return new Forward("/feedback/list.html");
        }

        return null;
    }
}

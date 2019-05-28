package by.training.beautysalon.command.feedback;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.DataBaseException;
import by.training.beautysalon.service.FeedbackService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedBackDeleteCommand extends Command {

    private static final String FEEDBACK_ID = "feedbackId";

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        FeedbackService service = serviceFactory.getFeedbackService();
        String id = request.getParameter(FEEDBACK_ID);
        if (id != null) {
            service.delete(Integer.parseInt(id));
        }

        return new Forward("/feedback/list.html");
    }
}

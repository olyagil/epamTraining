package by.training.beautysalon.command.feedback;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.Employee;
import by.training.beautysalon.entity.Feedback;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.exception.DataBaseException;
import by.training.beautysalon.service.FeedbackService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class FeedBackSaveCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String ID = "id";
    private static final String EMPLOYEE_ID = "employeeId";
    private static final String REVIEW = "review";

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        FeedbackService service = serviceFactory.getFeedbackService();
        try {
            Integer id = (Integer) request.getSession().getAttribute(ID);

            String employeeId = request.getParameter(EMPLOYEE_ID);
            String review = request.getParameter(REVIEW);
            Date date = new Date(System.currentTimeMillis());

            Feedback feedback = new Feedback();
            User client = new User();
            Employee employee = new Employee();
            client.setId(id);
            employee.setId(Integer.parseInt(employeeId));
            feedback.setClient(client);
            feedback.setEmployee(employee);
            feedback.setDate(date);
            feedback.setReview(review);
            service.save(feedback);
        } catch (IllegalArgumentException e) {
            LOGGER.debug("Can't parse data.", e);
            return new Forward("/talon/list.html");
        }
        return new Forward("/talon/list.html");

    }
}

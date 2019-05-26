package by.training.beautysalon.command.feedback;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.Employee;
import by.training.beautysalon.entity.Feedback;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.FeedbackService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class FeedBackSaveCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        FeedbackService service = serviceFactory.getFeedbackService();

        Integer id = (Integer) request.getSession().getAttribute("id");

        String employeeId = request.getParameter("employeeId");
        String review = request.getParameter("review");
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
        return new Forward("/talon/list.html");
    }
}

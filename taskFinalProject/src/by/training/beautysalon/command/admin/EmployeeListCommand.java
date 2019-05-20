package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.SpecialistService;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeListCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        SpecialistService service = factory.getService(SpecialistService.class);
        UserService userService = factory.getService(UserService.class);

        if (request.getParameter("searchLogin") != null) {
            String login = request.getParameter("searchLogin");
            request.setAttribute("specialists", service.find(login));
            request.setAttribute("searchLogin", login);
        } else {
//            List<Employee> specialistList = service.find();
//            List<User> users = new ArrayList<>();
//            for (Employee employee : specialistList) {
//                users.add(userService.find(employee.getId()));
//            }
            request.setAttribute("specialists", service.find());
            LOGGER.debug("Get list of specialists");
        }
        return null;
    }
}

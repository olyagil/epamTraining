package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.EmployeeService;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeListCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
//        EmployeeService employeeService = factory.getService(EmployeeService.class);
//        UserService userService = factory.getService(UserService.class);
        EmployeeService employeeService = serviceFactory.getEmployeeService();
        UserService service = serviceFactory.getUserService();

        if (request.getParameter("searchLogin") != null) {
            String login = request.getParameter("searchLogin");
            request.setAttribute("specialists", employeeService.find(login));
            request.setAttribute("searchLogin", login);
        } else {
//            List<Employee> specialistList = service.find();
//            List<User> users = new ArrayList<>();
//            for (Employee employee : specialistList) {
//                users.add(userService.find(employee.getId()));
//            }
            request.setAttribute("specialists", employeeService.find());
            LOGGER.debug("Get list of specialists");
        }
        return null;
    }
}

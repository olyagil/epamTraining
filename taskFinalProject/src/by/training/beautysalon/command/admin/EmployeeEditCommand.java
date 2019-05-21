package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.entity.enumeration.Specialty;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.EmployeeService;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeEditCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        try {
            int id = Integer.parseInt(request.getParameter("specialistId"));
            LOGGER.debug("User id: " + id);

//            UserService service = factory.getService(UserService.class);
            UserService service = serviceFactory.getUserService();
//            EmployeeService service =
//                    factory.getService(EmployeeService.class);
            EmployeeService employeeService = serviceFactory.getEmployeeService();
            User user = service.find(id);
            if (user != null) {
                request.setAttribute("user",
                        employeeService.find(user.getId()));
                request.setAttribute("specialties", Specialty.values());
            }
            LOGGER.info("Edit User " + user.getId());
        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id of the user");
            throw new PersistentException(e);
        }
        return null;

    }
}

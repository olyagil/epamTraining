package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.CommandEnum;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.Employee;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.entity.enumeration.Specialty;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.EmployeeService;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeEditCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        EmployeeService service = serviceFactory.getEmployeeService();

        try {
            int id = Integer.parseInt(request.getParameter("specialistId"));

            Employee employee = service.find(id);
            if (employee != null) {
                request.setAttribute("user", service.find(employee.getId()));
                request.setAttribute("specialties", Specialty.values());
            } else {
                LOGGER.debug(String.format("The user with id %s is not found"
                        , id));
                request.setAttribute("alert_message", "Such user doesn't " +
                        "exist!");

            }
        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id of the user");
            throw new PersistentException(e);
        }
        return new Forward(CommandEnum.EMPLOYEE_EDIT.getName(), false);

    }
}

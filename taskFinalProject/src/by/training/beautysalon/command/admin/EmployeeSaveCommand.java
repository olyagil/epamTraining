package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.domain.Employee;
import by.training.beautysalon.domain.enumeration.Specialty;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.SpecialistService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class EmployeeSaveCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Command.Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/account/employee/list.html");
        SpecialistService service = factory.getService(SpecialistService.class);

        Integer id = Integer.parseInt(request.getParameter("specialistId"));
        Employee employee = service.find(id);
        if (employee != null) {
            employee.setCabinetNumber(Integer.parseInt(request.getParameter(
                    "cabinet_number")));
            employee.setSalary(Double.parseDouble(request.getParameter(
                    "salary")));
            employee.setEmploymentDate(Date.valueOf(request.getParameter(
                    "employment_date")));
            employee.setSpecialty(Specialty.getById(Integer
                    .parseInt(request.getParameter("specialty"))));
            service.save(employee);
            LOGGER.debug("Employee is changed");
            return forward;
        }

        return null;
    }
}

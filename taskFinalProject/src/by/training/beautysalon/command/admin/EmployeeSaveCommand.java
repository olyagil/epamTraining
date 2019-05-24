package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.Employee;
import by.training.beautysalon.entity.enumeration.Gender;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.entity.enumeration.Specialty;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.EmployeeService;
import by.training.beautysalon.service.UserService;
import by.training.beautysalon.utill.ImageUtill;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Base64;

public class EmployeeSaveCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/employee/list.html");
        EmployeeService service = serviceFactory.getEmployeeService();
        UserService userService = serviceFactory.getUserService();
        String id = request.getParameter("specialistId");
        String login = request.getParameter("login");
        Employee employee = new Employee();
        if (id != null) {
            employee.setId(Integer.parseInt(id));
        }
        if (login != null) {
            employee.setLogin(request.getParameter("login"));
            employee.setPassword(request.getParameter("password"));
            employee.setRole(Role.EMPLOYEE);
            employee.setSurname(request.getParameter("surname"));
            employee.setName(request.getParameter("name"));
            employee.setPatronymic(request.getParameter("patronymic"));
            if (request.getParameter("gender").equals(Gender.FEMALE.getName())) {
                employee.setGender(Gender.FEMALE);
            } else {
                employee.setGender(Gender.MALE);
            }
            employee.setPhone(Integer.valueOf(request.getParameter("phone")));
            employee.setBirthDate(Date.valueOf(request.getParameter(
                    "birth_date")));
            try {
                Part filePart = request.getPart("img");
                InputStream stream = filePart.getInputStream();
                byte[] imageBytes = stream.readAllBytes();
                employee.setAvatar(Base64.getEncoder().encodeToString(imageBytes));
            } catch (IOException | ServletException e) {
                LOGGER.error("Can't read the image from file", e);
                throw new PersistentException(e);
            }
            employee.setId(userService.save(employee));
            LOGGER.debug("Employee is saved.");
        }
        LOGGER.debug("Employee id: " + employee.getId());
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
}


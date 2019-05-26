package by.training.beautysalon.command.employee;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.Employee;
import by.training.beautysalon.entity.Service;
import by.training.beautysalon.entity.Talon;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.TalonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TalonSaveCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        HttpSession session = request.getSession();
        TalonService service = serviceFactory.getTalonService();
        Talon talon = new Talon();
        Service serv = new Service();
        User client = new User();
        Employee employee = new Employee();

        String id = request.getParameter("id");
        String serviceId = request.getParameter("serviceId");
        String clientId = request.getParameter("clientId");
        String employeeId = request.getParameter("employeeId");
        if (id != null) {
            talon.setId(Integer.parseInt(id));
        }
        if (employeeId != null) {
            employee.setId(Integer.parseInt(employeeId));
        }
        if (serviceId != null) {
            serv.setId(Integer.parseInt(serviceId));
        }
        if (clientId != null) {
            client.setId(Integer.parseInt(clientId));
        }

        talon.setService(serv);
        talon.setClient(client);
        talon.setEmployee(employee);
        Date date;
        try {
            if (request.getParameter("receptionDateCol") != null) {
                date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
                        .parse(request.getParameter("receptionDateCol"));
            } else {
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .parse(request.getParameter("receptionDate"));
            }
        } catch (ParseException e) {
            LOGGER.debug("Can't parse the date");
            throw new PersistentException(e);
        }

        talon.setReceptionDate(new Timestamp(date.getTime()));
        talon.setStatus(Boolean.valueOf(request.getParameter("status")));
        service.save(talon);
        session.setAttribute("success_save_talon", "Talon is successfully" +
                " saved!");
        return new Forward("/talon/list.html");
    }
}

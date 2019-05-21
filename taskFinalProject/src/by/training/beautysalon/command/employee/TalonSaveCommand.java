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
import java.sql.Timestamp;

public class TalonSaveCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/account/talon/edit.html");
//        TalonService service = factory.getService(TalonService.class);
       TalonService service = serviceFactory.getTalonService();
        Talon talon = new Talon();
        Service serv = new Service();
        User client = new User();
        Employee employee = new Employee();
        String id = request.getParameter("id");
        String serviceId = request.getParameter("serviceId");
        String clientId = request.getParameter("clientId");
        String specialistId = request.getParameter("specialistId");
        if (id != null) {
           talon.setId(Integer.parseInt(id));
        }
        if (specialistId != null) {
            employee.setId(Integer.parseInt(specialistId));
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
        LOGGER.debug("CLIENT ID: " + talon.getClient().getId() + "SERVICE " +
                "ID: " + talon.getService().getId()
                + "SPECIALIST ID: " + talon.getEmployee().getId());
        LOGGER.debug("DATE_LOCAL TIME: " + request.getParameter("receptionDate"));
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = Date.valueOf(request.getParameter(
//                "receptionDate"));
        talon.setReceptionDate(Timestamp.valueOf((request.getParameter(
                "receptionDate")+":00.0").replace("T", " ")));
//        talon.setReceptionDate(date.getTime());
        talon.setStatus(Boolean.valueOf(request.getParameter("status")));
        service.save(talon);
//        forward.getAttributes().put("id", talon.getId());

        return forward;
    }
}

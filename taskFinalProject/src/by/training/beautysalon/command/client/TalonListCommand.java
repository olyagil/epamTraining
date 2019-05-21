package by.training.beautysalon.command.client;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.TalonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TalonListCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        try {
//            TalonService service = factory.getService(TalonService.class);
            TalonService service = serviceFactory.getTalonService();
            HttpSession session = request.getSession();
            LOGGER.debug("TALON ID: " + session.getAttribute("id"));
            Integer id = (Integer) session.getAttribute("id");
            request.setAttribute("talons", service.findBySpecialist(id));

        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse the id" + e);
        }
        return null;
    }
}

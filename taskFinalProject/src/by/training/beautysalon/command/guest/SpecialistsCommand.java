package by.training.beautysalon.command.guest;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.SpecialistService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpecialistsCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
//        Forward forward = new Forward("/specialists.jsp", false);
        SpecialistService service = factory.getService(SpecialistService.class);
        request.setAttribute("specialists", service.find());
        LOGGER.info("Get list of specialists");
        return null;
    }
}

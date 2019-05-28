package by.training.beautysalon.command.feedback;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.DataBaseException;
import by.training.beautysalon.service.TalonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedBackAddCommand extends Command {
    private static final String TALON_ID = "talonId";
    private static final String TALON = "talon";

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        TalonService service = serviceFactory.getTalonService();

        String id = request.getParameter(TALON_ID);
        if (id == null) {
            return new Forward("/talon/list.html");
        } else {
            request.setAttribute(TALON, service.find(Integer.parseInt(id)));
            return null;
        }

    }
}

package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientDeleteCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/client/list.html");
        try {
            UserInfoService service = factory.getService(UserInfoService.class);
            Integer id = Integer.parseInt(request.getParameter("id"));
            service.delete(id);
            forward.getAttributes().put("message", "Клиент удален");
            LOGGER.info(String.format("Client \"%s\" is successfully deleted.",
                    getAuthorizedUser().getLogin()));
        } catch (NumberFormatException e) {
            LOGGER.warn(String.format("Incorrect data was found when user \"%s\" " +
                            "tried to delete client", getAuthorizedUser().getLogin()),
                    e);
        }
        return forward;
    }
}

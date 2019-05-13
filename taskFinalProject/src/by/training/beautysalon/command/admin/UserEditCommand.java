package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.domain.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserEditCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Role role =
                    Role.getById(Integer.parseInt(request.getParameter("role")));
            LOGGER.debug("User id: " + id + " role: " + role);

        
            UserInfoService service = factory.getService(UserInfoService.class);
            UserInfo user = service.find(id);
            if (user != null) {
                request.setAttribute("user", user);
            }
            LOGGER.info("Edit User " + user);
        } catch (NumberFormatException e) {
        }
        return null;

    }
}

package by.training.beautysalon.command.account;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class AccountSaveAvatarCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {

        Integer id = (Integer) request.getSession().getAttribute("id");
        User user = new User();
        user.setId(id);
//        UserService service = factory.getService(UserService.class);
        UserService service = serviceFactory.getUserService();
        try {
            Part filePart = request.getPart("img");
            InputStream stream = filePart.getInputStream();
            byte[] imageBytes = stream.readAllBytes();
            user.setAvatar(Base64.getEncoder().encodeToString(imageBytes));
            service.save(user);
        } catch (IOException | ServletException e) {
            LOGGER.error("Can't read the image from file", e);
            throw new PersistentException(e);
        }
        return new Forward("/account/edit/info.html");
    }
}

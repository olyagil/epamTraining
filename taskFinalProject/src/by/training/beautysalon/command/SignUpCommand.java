package by.training.beautysalon.command;

import by.training.beautysalon.utill.ImageUtill;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.entity.enumeration.Gender;
import by.training.beautysalon.entity.enumeration.Role;
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
import java.sql.Date;
import java.sql.SQLException;
import java.util.Base64;


public class SignUpCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request,
                           HttpServletResponse response)
            throws PersistentException {
        Forward forward = new Forward("/account/main.html");
        UserService service = serviceFactory.getUserService();
        User user = new User();
        String avatar;


        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");

        if (login != null) {
            try {
                Gender gender;
                if (request.getParameter("gender").equals(Gender.FEMALE.getName())) {
                    gender = Gender.FEMALE;
                } else {
                    gender = Gender.MALE;
                }
                Integer phone = Integer.parseInt(request.getParameter("phone"));
                Date birthDate = Date.valueOf(request.getParameter("birth_date"));
                try {
                    Part filePart = request.getPart("img");
                    InputStream stream = filePart.getInputStream();
                    byte[] imageBytes = stream.readAllBytes();
                    avatar = Base64.getEncoder().encodeToString(imageBytes);
                } catch (IOException | ServletException e) {
                    LOGGER.error("Can't read the image from file", e);
                    throw new PersistentException(e);
                }

                user.setLogin(login);
                user.setPassword(password);
                user.setRole(Role.CLIENT);
                user.setName(name);
                user.setSurname(surname);
                user.setPatronymic(patronymic);
                user.setGender(gender);
                user.setPhone(phone);
                user.setBirthDate(birthDate);
                if (avatar.isEmpty()) {
                    if (user.getGender().equals(Gender.MALE)) {
                        avatar = ImageUtill.encoderFromFile("D:" +
                                "/IdeaProjects/epamTraining" +
                                "/taskFinalProject" +
                                "/web/img/man_avatar.png");

                    } else {
                        avatar = ImageUtill.encoderFromFile("D:" +
                                "/IdeaProjects/epamTraining" +
                                "/taskFinalProject" +
                                "/web/img/woman_avatar.png");
                    }

                }
                user.setAvatar(avatar);
                LOGGER.debug("AVATAR: " + user.getAvatar());
            } catch (SQLException e) {
                throw new PersistentException(e);
            }
            service.save(user);
//            forward.getAttributes().put("message", "Вы успешно " +
//                    "зарегестрированы! Для продолжения введите логин и " +
//                    "пароль.");
            return forward;
        }
        return null;

    }
}

package by.training.beautysalon.command.common;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.CommandEnum;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.entity.enumeration.Gender;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserService;
import by.training.beautysalon.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;


public class SignUpCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request,
                           HttpServletResponse response)
            throws PersistentException {
        Forward forward = new Forward("/login.html");
        UserService service = serviceFactory.getUserService();
        HttpSession session = request.getSession();
        User user = new User();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        if (UserValidator.checkLogin(login)) {
            if (service.find(login).isEmpty()) {
                if (UserValidator.checkPassword(password)) {
                    user.setPassword(password);
                    try {
                        Gender gender = Gender.valueOf(request
                                .getParameter("gender").toUpperCase());
                        String phone = request.getParameter("phone");
                        Date birthDate = Date.valueOf(request.getParameter("birth_date"));
                        try {
                            user.setAvatar(UserValidator.getAvatar(request.getPart("img"), gender));
                        } catch (IOException | ServletException e) {
                            LOGGER.error("Can't read the image from file", e);
                            throw new PersistentException(e);
                        }
                        user.setPhone(Integer.parseInt(UserValidator.getPhone(phone)));

                        user.setLogin(login);
                        user.setRole(Role.CLIENT);
                        user.setName(name);
                        user.setSurname(surname);
                        user.setPatronymic(patronymic);
                        user.setGender(gender);
                        user.setBirthDate(birthDate);
                    } catch (SQLException e) {
                        LOGGER.error("Can't insert user in DB.", e);
                        session.setAttribute("message_signup",
                                "Incorrect data. Please, try again!");
                        throw new PersistentException(e);
                    }

                    service.save(user);
                    session.setAttribute("message_success_signup", "Вы " +
                            "успешно " +
                            "зарегестрированы! Для продолжения введите логин и " +
                            "пароль.");
                    return forward;
                } else {
                    session.setAttribute("message_signup", "Password must be " +
                            "in pattern: a-zA-Z0-9-_");
                }
            } else {
                session.setAttribute("message_signup", "Such user is " +
                        "already exist.");
            }
        }
        return new Forward(CommandEnum.SIGNUP.getName(), false);

    }
}

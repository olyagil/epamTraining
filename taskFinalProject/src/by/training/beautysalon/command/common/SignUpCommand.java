package by.training.beautysalon.command.common;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.entity.enumeration.Gender;
import by.training.beautysalon.entity.enumeration.Role;
import by.training.beautysalon.exception.DataBaseException;
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
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PATRONYMIC = "patronymic";
    private static final String GENDER = "gender";
    private static final String PHONE = "phone";
    private static final String BIRTH_DATE = "birth_date";
    private static final String IMG = "img";

    @Override
    public Forward execute(HttpServletRequest request,
                           HttpServletResponse response)
            throws DataBaseException {
        Forward forward = new Forward("/login.html");
        UserService service = serviceFactory.getUserService();
        HttpSession session = request.getSession();
        User user = new User();

        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String name = request.getParameter(NAME);
        String surname = request.getParameter(SURNAME);
        String patronymic = request.getParameter(PATRONYMIC);
        if (UserValidator.checkLogin(login) && (service.find(login).isEmpty())) {

            if (UserValidator.checkPassword(password)) {
                user.setPassword(password);
                try {
                    Gender gender = Gender.valueOf(request
                            .getParameter(GENDER).toUpperCase());
                    String phone = request.getParameter(PHONE);
                    Date birthDate = Date.valueOf(request.getParameter(BIRTH_DATE));
                    try {
                        user.setAvatar(UserValidator.getAvatar(request.getPart(IMG), gender));
                    } catch (IOException | ServletException e) {
                        LOGGER.error("Can't read the image from file", e);
                        throw new DataBaseException(e);
                    }
                    user.setPhone(Integer.parseInt(UserValidator.getPhone(phone)));

                    user.setLogin(login);
                    user.setRole(Role.CLIENT);
                    user.setName(name);
                    user.setSurname(surname);
                    user.setPatronymic(patronymic);
                    user.setGender(gender);
                    user.setBirthDate(birthDate);
                } catch (SQLException | IllegalArgumentException e) {
                    LOGGER.error("Can't insert user in DB.", e);
                    session.setAttribute("message_signup",
                            "Incorrect data. Please, try again!");
                    return null;
                }

                service.save(user);
                session.setAttribute("message_success_signup", "Вы " +
                        "успешно зарегестрированы! Для продолжения введите логин и " +
                        "пароль.");
                return forward;
            } else {
                session.setAttribute("message_signup", "Password must be " +
                        " at list 6 digits and in pattern: a-zA-Z0-9-_");
            }
        } else {
            session.setAttribute("message_signup", "Such user is " +
                    "already exist.");

        }
        return null;

    }
}

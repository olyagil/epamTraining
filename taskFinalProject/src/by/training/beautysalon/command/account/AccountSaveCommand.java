package by.training.beautysalon.command.account;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.domain.User;
import by.training.beautysalon.domain.enumeration.Gender;
import by.training.beautysalon.domain.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class AccountSaveCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/account/edit/info.html");
        HttpSession session = request.getSession();

        Integer id = (Integer) session.getAttribute("id");
        Role role = Role.getById((Integer) session.getAttribute("role"));
        User user = new User();
        UserService service = factory.getService(UserService.class);

        user.setId(id);
        String login = request.getParameter("login");
//        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        Gender gender;
        if (login != null) {
            if (request.getParameter("gender").equals(Gender.FEMALE.getName())) {
                gender = Gender.FEMALE;
            } else {
                gender = Gender.MALE;
            }
            Integer phone = Integer.parseInt(request.getParameter("phone"));
            Date birthDate = Date.valueOf(request.getParameter("birth_date"));

            user.setLogin(login);
            user.setRole(role);
            user.setName(name);
            user.setSurname(surname);
            user.setPatronymic(patronymic);
            user.setGender(gender);
            user.setPhone(phone);
            user.setBirthDate(birthDate);
            LOGGER.debug("user: " + user);
            service.save(user);
        }

        return forward;
    }
}
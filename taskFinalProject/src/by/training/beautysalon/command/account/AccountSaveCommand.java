package by.training.beautysalon.command.account;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.entity.User;
import by.training.beautysalon.entity.enumeration.Gender;
import by.training.beautysalon.entity.enumeration.Role;
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
        HttpSession session = request.getSession();

        Integer id = (Integer) session.getAttribute("id");
        Role role = Role.getById((Integer) session.getAttribute("role"));
        User user = new User();
        UserService service = serviceFactory.getUserService();

        user.setId(id);
        String login = request.getParameter("login");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        Gender gender;
        if (login != null) {
            Integer phone = Integer.parseInt(request.getParameter("phone"));
            Date birthDate = Date.valueOf(request.getParameter("birth_date"));
            user.setGender(Gender.valueOf(request.getParameter("gender").toUpperCase()));
            user.setLogin(login);
            user.setRole(role);
            user.setName(name);
            user.setSurname(surname);
            user.setPatronymic(patronymic);
            user.setPhone(phone);
            user.setBirthDate(birthDate);
            LOGGER.debug("user: " + user);
            service.save(user);
            session.setAttribute("success_save_info", "The information is " +
                    "successful updated");
        } else {
            session.setAttribute("failure_save_info", "The information " +
                    "can't be updated");
        }

        return new Forward("/account/edit/info.html");
    }
}
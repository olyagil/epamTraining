package by.training.beautysalon.command;

import by.training.beautysalon.domain.enumeration.Gender;
import by.training.beautysalon.domain.enumeration.Role;
import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.impl.UserInfoServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class SignUpCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request,
                           HttpServletResponse response)
            throws PersistentException {

        Forward forward = new Forward("/login.jsp");
        String login =
                request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        Gender gender;
        if (request.getParameter("gender").equals(Gender.FEMALE.getName())) {
            gender = Gender.FEMALE;
        } else {
            gender = Gender.MALE;
        }
        Integer phone = Integer.parseInt(request.getParameter("phone"));
        Date birthDate = Date.valueOf(request.getParameter("birthdate"));
        LOGGER.debug("l: " + login + password + name + surname + patronymic
                + gender.getName() + phone  + birthDate);
//        Blob photo = new Blob() request.getParameter("photo");
        UserInfo userInfo = new UserInfo();
        userInfo.setLogin(login);
        userInfo.setPassword(password);
        userInfo.setRole(Role.CLIENT);
        userInfo.setName(name);
        userInfo.setSurname(surname);
        userInfo.setPatronymic(patronymic);
        userInfo.setGender(gender);
        userInfo.setPhone(phone);
        userInfo.setBirthDate(birthDate);
        UserInfoServiceImpl service = factory.getUserServiceImpl();
//                factory.getService(UserInfoServiceImpl.class);
        service.save(userInfo);
        forward.getAttributes().put("id", userInfo.getId());
        forward.getAttributes().put("message", "Данные сотрудника успешно сохранены");
        LOGGER.info(String.format("User \"%s\" saved user with id %d",
                getAuthorizedUser().getLogin(), userInfo.getId()));
        HttpSession session = request.getSession();
//        session.setAttribute("user", userInfo);
//        session.setAttribute("menu", menu.get(userInfo.getRole()));
        return forward;

    }
}

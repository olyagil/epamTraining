package by.training.beautysalon.command;

import by.training.beautysalon.domain.Role;
import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserInfoServiceImpl;
import by.training.beautysalon.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Blob;
import java.sql.Date;

public class SignUpCommand extends Command {
    @Override
    public Forward execute(HttpServletRequest request,
                           HttpServletResponse response)
            throws PersistentException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        Integer phone = Integer.parseInt(request.getParameter("phone"));
        Date birthDate = Date.valueOf(request.getParameter("birth_date"));
//        Blob photo = request.getParameter("photo");
        UserInfo userInfo = new UserInfo();
        userInfo.setLogin(login);
        userInfo.setPassword(password);
        userInfo.setRole(Role.CLIENT);
        userInfo.setName(name);
        userInfo.setSurname(surname);
        userInfo.setPatronymic(patronymic);
        userInfo.setPhone(phone);
        userInfo.setBirthDate(birthDate);
        UserInfoServiceImpl service =
                factory.getService(UserInfoServiceImpl.class);
        service.save(userInfo);
        return null;

    }
}

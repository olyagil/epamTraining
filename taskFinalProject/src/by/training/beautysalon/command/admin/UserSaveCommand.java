package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.domain.enumeration.Gender;
import by.training.beautysalon.domain.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class UserSaveCommand extends Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/account/client.html");

        UserInfoService service = factory.getService(UserInfoService.class);
        UserInfo user = new UserInfo();
//        user.setLogin(request.getParameter("login"));
//        user.setPatronymic(request.getParameter("password"));
//        user.setRole(Role.CLIENT);
//        user.setSurname(request.getParameter("surname"));
//        user.setName(request.getParameter("name"));
//        user.setPatronymic(request.getParameter("patronymic"));
////        user.setGender(Gender.getById(request.getParameter("gender")));
//        user.setPhone(Integer.parseInt(request.getParameter("phone")));
//        user.setBirthDate(Date.valueOf(request.getParameter("birthDate")));
////        user.setAvatar(request.getParameter("avatar"));
        LOGGER.debug("User is created");
//        service.save(user);

        return null;
    }
}

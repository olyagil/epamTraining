package by.training.beautysalon.command.account;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.domain.UserInfo;
import by.training.beautysalon.domain.enumeration.Role;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.SpecialistService;
import by.training.beautysalon.service.UserInfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccountMainCommand extends Command {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        HttpSession session = request.getSession(false);
        Role role = Role.getById((Integer) (session.getAttribute("role")));
        Integer id = (Integer) session.getAttribute("id");
        UserInfoService service = factory.getService(UserInfoService.class);
        SpecialistService specialistService =
                factory.getService(SpecialistService.class);

        switch (role) {
            case SPECIALIST:
                request.setAttribute("user", specialistService.find(id));
                break;
            case ADMINISTRATOR:
            case CLIENT:
                request.setAttribute("user", service.find(id));
                break;
        }
        return null;
    }
}

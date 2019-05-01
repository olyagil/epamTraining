package by.training.beatysalon.action.admin;

import by.training.beatysalon.action.Action;
import by.training.beatysalon.exception.PersistentException;
import by.training.beatysalon.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientListAction extends AdminAction {

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        UserService service = factory.getService(UserService.class);
        request.setAttribute("clients", service.findAll());

        return null;
    }
}

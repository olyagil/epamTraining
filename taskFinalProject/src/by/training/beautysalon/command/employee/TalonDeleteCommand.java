package by.training.beautysalon.command.employee;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.TalonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TalonDeleteCommand extends Command {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/account/talon/list.html");
        TalonService service = factory.getService(TalonService.class);
        Integer id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        return forward;
    }
}

package by.training.beautysalon.command.employee;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.DataBaseException;
import by.training.beautysalon.service.TalonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TalonDeleteCommand extends Command {

    private static final String ID = "id";

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        TalonService service = serviceFactory.getTalonService();
        Integer id = Integer.parseInt(request.getParameter(ID));
        service.delete(id);
        return new Forward("/talon/list.html");
    }
}

package by.training.beautysalon.command.specialist;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.exception.PersistentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TalonDeleteCommand extends Command {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/account/talon/list.html");

        return null;
    }
}

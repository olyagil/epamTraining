package by.training.beautysalon.command.comman;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.PersistentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnknownCommand extends Command {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        return new Forward("/error.jsp");
    }
}

package by.training.beautysalon.command.common;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.DataBaseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotFoundCommand extends Command {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        return null;
    }
}

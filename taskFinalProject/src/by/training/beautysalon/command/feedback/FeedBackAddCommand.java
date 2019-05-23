package by.training.beautysalon.command.feedback;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.PersistentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedBackAddCommand extends Command {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        return null;
    }
}

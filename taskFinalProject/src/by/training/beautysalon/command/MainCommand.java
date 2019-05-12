package by.training.beautysalon.command;

import by.training.beautysalon.exception.PersistentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MainCommand extends AuthorizedUserCommand {
    @Override
    public Command.Forward execute(HttpServletRequest request,
                            HttpServletResponse response) throws PersistentException {
        @SuppressWarnings("unchecked")
        List<MenuItem> menu = (List<MenuItem>)request.getSession(false).getAttribute("menu");
        return new Forward(menu.get(0).getUrl());
    }
}

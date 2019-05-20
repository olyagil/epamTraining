package by.training.beautysalon.command;

import by.training.beautysalon.exception.PersistentException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MainCommand extends Command {
    @Override
    public Command.Forward execute(HttpServletRequest request,
                                   HttpServletResponse response) throws PersistentException {
        @SuppressWarnings("unchecked")
        List<MenuItem> menu = (List<MenuItem>) request.getSession(false).getAttribute("menu");
//        request.getSession().setAttribute("lang", request.getParameter(
//                "lang"));
//        RequestDispatcher dispatcher = getServletContext()
//                .getRequestDispatcher("/index.jsp");
//        dispatcher.forward(request, response);
        return new Forward(menu.get(0).getUrl());
    }
}

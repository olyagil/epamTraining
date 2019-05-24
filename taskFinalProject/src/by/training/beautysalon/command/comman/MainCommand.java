package by.training.beautysalon.command.comman;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.PersistentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainCommand extends Command {
    @Override
    public Forward execute(HttpServletRequest request,
                           HttpServletResponse response) throws PersistentException {
//        request.getSession().setAttribute("lang", request.getParameter(
//                "lang"));
//        RequestDispatcher dispatcher = getServletContext()
//                .getRequestDispatcher("/index.jsp");
//        dispatcher.forward(request, response);
//        return null;
    return new Forward("main.jsp", false);
    }
}

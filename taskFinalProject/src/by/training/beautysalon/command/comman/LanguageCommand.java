package by.training.beautysalon.command.comman;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;

public class LanguageCommand extends Command {
    private static Logger LOGGER = LogManager.getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws PersistentException {

        String lang = request.getParameter("lang");
        LOGGER.debug(request.getSession(false).getAttribute("lang"));
        request.getSession().setAttribute("lang", lang);
        LOGGER.debug("LOCALE: " + lang);
        LOGGER.debug(request.getSession(false).getAttribute("lang"));
        URI uri = null;
        try {
            uri = new URI(request.getHeader("referer"));
        } catch (URISyntaxException e) {
            LOGGER.error("Can't get the previous page");
        }
        LOGGER.debug("REFERER: " + uri.getPath());
        return new Forward(uri.getPath().replace("/salon", ""));
    }
}

package by.training.beautysalon.command;

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

        String locale = request.getParameter("locale");
        LOGGER.debug(request.getSession().getAttribute("locale"));
        request.getSession().setAttribute("locale", locale);
        LOGGER.debug("LOCALE: " + locale);
        LOGGER.debug(request.getSession().getAttribute("lang"));
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
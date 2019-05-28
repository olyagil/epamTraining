package by.training.beautysalon.command.common;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.command.Forward;
import by.training.beautysalon.exception.DataBaseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Class ${@code LanguageCommand} is used for changing language.
 */
public class LanguageCommand extends Command {
    private final static Logger LOGGER = LogManager.getLogger();
    private static final String LANGUAGE = "lang";

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {

        String lang = request.getParameter(LANGUAGE);
        request.getSession().setAttribute(LANGUAGE, lang);
        URI uri = null;
        try {
            uri = new URI(request.getHeader("referer"));
        } catch (URISyntaxException e) {
            LOGGER.error("Can't get the previous page");
        }
        LOGGER.debug("The language is changed to: " + lang);

        return new Forward(uri.getPath().replace("/salon", ""));
    }
}

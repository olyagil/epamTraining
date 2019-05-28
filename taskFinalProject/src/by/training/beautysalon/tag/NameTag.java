package by.training.beautysalon.tag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class NameTag extends TagSupport {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int doStartTag() throws JspException {

        String name = "  \"Sunshine\" ";
        JspWriter out = pageContext.getOut();
        try {
            out.write(name);
        } catch (IOException e) {
            LOGGER.error("Can't write tag.", e);
            throw new JspException(e);
        }
        return SKIP_BODY;
    }
}

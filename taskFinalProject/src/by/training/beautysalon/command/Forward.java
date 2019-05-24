package by.training.beautysalon.command;

import java.util.HashMap;
import java.util.Map;

public class Forward {

    private String page;
    private boolean redirect;
    private Map<String, Object> attributes = new HashMap<>();

    public Forward(String page) {
        this(page, true);
    }

    public Forward(String page, boolean redirect) {
        this.page = page;
        this.redirect = redirect;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public boolean isRedirect() {
        return redirect;
    }

    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }
}

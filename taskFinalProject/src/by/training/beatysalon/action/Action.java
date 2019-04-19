package by.training.beatysalon.action;

import by.training.beatysalon.domain.Role;
import by.training.beatysalon.domain.User;
import by.training.beatysalon.exception.PersistentException;
import by.training.beatysalon.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Action {

    private Set<Role> allowedRoles = new HashSet<>();
    private User authorizedUser;
    private String name;

    protected ServiceFactory factory;

    public void setAllowedRoles(Set<Role> allowedRoles) {
        this.allowedRoles = allowedRoles;
    }

    public void setAuthorizedUser(User authorizedUser) {
        this.authorizedUser = authorizedUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuthorizedUser() {
        return authorizedUser;
    }

    public String getName() {
        return name;
    }

    abstract Forward exec(HttpServletRequest request,
                          HttpServletResponse response) throws PersistentException;

    public static class Forward {
        private String forward;
        private boolean redirect;
        private Map<String, Object> attributes = new HashMap<>();

        public Forward(String forward, boolean redirect) {
            this.forward = forward;
            this.redirect = redirect;
        }

        public Forward(String forward) {
            this(forward, true);
        }

        public String getForward() {
            return forward;
        }

        public boolean isRedirect() {
            return redirect;
        }

        public Map<String, Object> getAttributes() {
            return attributes;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public void setRedirect(boolean redirect) {
            this.redirect = redirect;
        }
    }
}

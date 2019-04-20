package by.training.beatysalon.action;

import by.training.beatysalon.domain.Role;

import java.util.Arrays;

public abstract class AuthorizedUserAction extends Action {

    public AuthorizedUserAction() {
        getAllowedRoles().addAll(Arrays.asList(Role.values()));
    }
}

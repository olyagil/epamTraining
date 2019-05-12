package by.training.beautysalon.command;

import by.training.beautysalon.domain.enumeration.Role;

import java.util.Arrays;

public abstract class AuthorizedUserCommand extends Command {

    public AuthorizedUserCommand() {
        getAllowRoles().addAll(Arrays.asList(Role.values()));
    }
}
